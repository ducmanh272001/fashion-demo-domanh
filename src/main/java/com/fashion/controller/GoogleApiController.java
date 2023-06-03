package com.fashion.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fashion.base.BaseService;
import com.fashion.base.GoogleUntils;
import com.fashion.entity.CustomerEntity;
import com.fashion.entity.GoogleEntity;
import com.fashion.entity.RoleEntity;
import com.fashion.entity.UserEntity;
import com.fashion.entity.UserRoleEntity;
import com.fashion.notify.Notifies;
import com.google.gson.Gson;

@Controller
public class GoogleApiController {

	@GetMapping(value = "/login-google")
	public String handleLoginGoogle(HttpServletRequest request, Model model)
			throws ClientProtocolException, IOException {
		String code = request.getParameter("code");
		String accessToken = GoogleUntils.getToken(code);
		GoogleEntity googlePojo = GoogleUntils.getUserInfo(accessToken);
		request.setAttribute("id", googlePojo.getId());
		request.setAttribute("name", googlePojo.getName());
		request.setAttribute("email", googlePojo.getEmail());
		UserEntity userEntity = BaseService.selectUserFromEmail(googlePojo.getEmail());
		if (userEntity == null || Objects.isNull(userEntity)) {
			UserEntity userEntities = new UserEntity();
			userEntities.setEnabled(1);
			userEntities.setFullName("Đỗ Đức Mạnh");
			userEntities.setName(googlePojo.getEmail());
			Gson gs = new Gson();
			String data = gs.toJson(userEntities);
			UserEntity userSave = BaseService.insertUser(data);
			int idrole = 3;
			RoleEntity roleok = BaseService.timRole(idrole);
			UserRoleEntity userRole = new UserRoleEntity(userSave, roleok);
			String dulieu = gs.toJson(userRole);
			BaseService.InsertUserRole(dulieu);
			userEntity = userSave;
		}
		HttpSession session = request.getSession();
		session.setAttribute("acc", userEntity);
		session.setAttribute("role", "USER");
		BaseService.ListSanPham(model);
		BaseService.ListDamSanPham(model);
		String namedn = userEntity.getFullName();
		String accountdn = userEntity.getName();
		List<CustomerEntity> listkh = BaseService.listKhachHang();
		
		
		for (int j = 0; j < listkh.size(); j++) {
			if (listkh.get(j).getName().equals(namedn) && listkh.get(j).getEmail().equals(accountdn)) {
				session.setAttribute("idkh", listkh.get(j).getId());
			}
		}
		
		
		return "redirect:/";
	}
}