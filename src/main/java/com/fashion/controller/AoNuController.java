package com.fashion.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fashion.entity.CartChiTiet;
import com.fashion.entity.Hinhanh;
import com.fashion.entity.Kichco;
import com.fashion.entity.Mausac;
import com.fashion.entity.Sanpham;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class AoNuController {

	@GetMapping(value = "/ao-nu/{idla}")
	public String aoNuA280(@PathVariable(value = "idla") int idok, HttpServletRequest request, Model model) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		// Nạp biến api Tìm theo id vào đây
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/search-id/"
				+ idok;
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Sanpham sp = gs.fromJson(data, Sanpham.class);
		// Tìm áo nữ này có id là mấy thì gắn vào list hình ảnh
		List<Hinhanh> listha = TienIch.selectByIdSpHinhAnh(sp.getId());
		sp.setListHinhAnh(listha);
		model.addAttribute("sp", sp);
		// Bỏ cái size vào đây
		String kichco = "http://localhost:8080/Fashion-Shop-Api/rest/kich-thuoc";
		Client cliekc = ClientBuilder.newClient();
		WebTarget targekc = cliekc.target(kichco);
		String layve = targekc.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Kichco>>() {
		}.getType();
		List<Kichco> lsize = gs.fromJson(layve, typeOfT);
		model.addAttribute("lsize", lsize);
		// Lấy cái list màu sắc
		String mausac = "http://localhost:8080/Fashion-Shop-Api/rest/Mau-sac";
		WebTarget ms = client.target(mausac);
		String layms = ms.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typems = new TypeToken<List<Mausac>>() {
		}.getType();
		List<Mausac> lms = gs.fromJson(layms, typems);
		model.addAttribute("lms", lms);
		// List sản phẩm nổi bật
		List<Sanpham> list = TienIch.sanPhamSale();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", list);
		// Số lượng đơn
		HttpSession session = request.getSession();
		List<CartChiTiet> lokk = (List<CartChiTiet>) session.getAttribute("listct");
		int dem = 0;
		if (lokk == null) {
			model.addAttribute("dem", dem);
			return "product/aonu/product-detail";
		}
		// Còn không bằng null thì lấy dữ liệu ra
		for (CartChiTiet cct : lokk) {
			dem += cct.getSanphamchitiet().getAmount();
		}
		model.addAttribute("dem", dem);
		return "product/aonu/product-detail";
	}
}
