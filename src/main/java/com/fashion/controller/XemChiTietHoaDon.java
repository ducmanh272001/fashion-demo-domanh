package com.fashion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fashion.entity.HoaDon;
import com.fashion.entity.HoaDonChiTiet;
import com.fashion.entity.SanPhamChiTiet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class XemChiTietHoaDon {

	@GetMapping(value = "/xem-chi-tiet/{idla}")
	public String xemChiTiet(@PathVariable(value = "idla")int idla, HttpServletRequest request,Model model) {
		Client client = ClientBuilder.newClient();
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<HoaDonChiTiet> list = TienIch.listHoaDonChiTiet(idla);
		for (HoaDonChiTiet hdct : list) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/san-pham-detail/search-sp-detail/"
				+ hdct.getIdSanPhamCt();
		WebTarget spdetail = client.target(URL);
		String detail = spdetail.request(MediaType.APPLICATION_JSON).get(String.class);
		SanPhamChiTiet spctok = gs.fromJson(detail, SanPhamChiTiet.class);
		hdct.setId_sp(spctok);
		// Xong sau là set luôn cho biến Hóa đơn
		String URL2 = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/search-id-hd/" + hdct.getIdHoaDon();
		WebTarget hoadonct = client.target(URL2);
		String trave = hoadonct.request(MediaType.APPLICATION_JSON).get(String.class);
		HoaDon hoadon = gs.fromJson(trave, HoaDon.class);
		hdct.setId_hoadon(hoadon);
	}
		model.addAttribute("list", list);
		return "cart/view-detail";
	}
}
