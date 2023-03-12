package com.fashion.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.entity.Roles;
import com.fashion.entity.ThongBao;
import com.fashion.entity.User;
import com.fashion.entity.UserRole;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class DangKyController {

	@GetMapping(value = "/dang-ky")
	public String dangKy(Model model) {
		User user = new User();
		model.addAttribute("luser", user);
		return "login/sign-up";
	}

	@PostMapping(value = "/dang-ky/success")
	public String dangKySuccess(@ModelAttribute(value = "luser") @Valid User userok, BindingResult result, Model model,
			@RequestParam(value = "laipass") String laipass) {
		if (result.hasErrors()) {
			return "login/sign-up";
		}

		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/User/insert";
		// Thêm vào api
		userok.setEnabled(1);

		// tìm xem tên đăng nhập đã có hay chưa nếu có rồi thì cút
		Client client = ClientBuilder.newClient();
		String URLLIST = "http://localhost:8080/Fashion-Shop-Api/rest/User";
		Gson gs = new Gson();
		WebTarget target = client.target(URLLIST);
		String listUser = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<User>>() {
		}.getType();
		List<User> listok = gs.fromJson(listUser, typeOfT);
		for (int i = 0; i < listok.size(); i++) {
			if (listok.get(i).getName().equals(userok.getName())) {
				model.addAttribute("tb", "Email không hợp lệ");
				model.addAttribute("pass", laipass);
				return "login/sign-up";
			}
		}
		if (userok.getPassword().equals(laipass)) {
			// Nếu mà 2 cái khớp nhau thì sẽ cho đi đăng ký tiếp
			WebTarget target2 = client.target(URL);
			// Thêm thôi không cần lấy về
			// Truyền dữ liệu dưới dang chuỗi
			String data = gs.toJson(userok);
			Response response = target2.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
			String layve = response.readEntity(String.class);
			ThongBao soUser = gs.fromJson(layve, ThongBao.class);
			User userThem = TienIch.timUser(soUser.getMacode());
			// Thêm id là user trước
			int idrole = 2;
			Roles roleok = TienIch.timRole(idrole);
//			roleok.set
			UserRole userRole = new UserRole(userThem, roleok);
			String dulieu = gs.toJson(userRole);
			ThongBao tb = TienIch.InsertUserRole(dulieu);
			if (tb.getMacode() == 1) {
				return "redirect:/dang-nhap";
			}
			// Còn nếu mà không thành công thì vẩn ở lại trang đăng ký
			model.addAttribute("pass", laipass);
			model.addAttribute("tbok", tb);
			return "login/sign-up";
		} else {
			model.addAttribute("pass", laipass);
			model.addAttribute("tb", "Mật khẩu không khớp nhau");
		}
		return "login/sign-up";

	}

}
