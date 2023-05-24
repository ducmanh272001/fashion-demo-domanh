package com.fashion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fashion.base.BaseService;
import com.fashion.entity.CartEntity;

@Controller
public class LogOutController {

	@GetMapping(value = "/log-out")
	public String logOut(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("acc");
		session.removeAttribute("idkh");
		session.removeAttribute("dem");
		session.removeAttribute("role");
		BaseService.ListSanPham(model);
		BaseService.ListDamSanPham(model);
		return "redirect:/";
	}
	
	
	// Hàm số lượng xuống đây
	private static int soLuong(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		int amount = 0;
		List<CartEntity> lokk = (List<CartEntity>) session.getAttribute("list");
		for (CartEntity cart : lokk) {
			amount += cart.getSanpham().getSp_view();
		}
		return amount;
	}
}
