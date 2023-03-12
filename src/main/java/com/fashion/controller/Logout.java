package com.fashion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fashion.entity.Cart;

@Controller
public class Logout {

	@GetMapping(value = "/log-out")
	public String logOut(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("acc");
		session.removeAttribute("idkh");
		session.removeAttribute("dem");
		session.removeAttribute("role");
		TienIch.ListSanPham(model);
		TienIch.ListDamSanPham(model);
		return "redirect:/";
	}
	
	
	// Hàm số lượng xuống đây
	private static int soLuong(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		int amount = 0;
		List<Cart> lokk = (List<Cart>) session.getAttribute("list");
		for (Cart cart : lokk) {
			amount += cart.getSanpham().getSp_view();
		}
		return amount;
	}
}
