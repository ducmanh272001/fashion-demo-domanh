package com.fashion.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashion.base.BaseService;
import com.fashion.entity.ImagerEntity;
import com.fashion.entity.ProductEntity;
import com.fashion.entity.NewsEntity;

@Controller
public class HomeController {

	@RequestMapping(value = {"", "/fashion"}, method = RequestMethod.GET)
	public String homeFashion(Model model, HttpServletRequest request) {
		
		// Lấy ra 12 sản phẩm bán chayj
		
		List<String> lst = BaseService.sanPhamBanChay();
		List<Long> longList = lst.stream()
		                        .map(Long::parseLong)
		                        .collect(Collectors.toList());

        List<ProductEntity> sanPhamBanChay = new ArrayList<>();
		
		
		for (int i = 0; i < longList.size(); i++) {
			ProductEntity productEntity =  BaseService.searchIdSanPham(longList.get(i).intValue());
			sanPhamBanChay.add(productEntity);
		}
	
		
		// Sản phẩm nổi bật
		List<ProductEntity> list = BaseService.ListSanPham(model);
		// Nạp sản phẩm đang sale
		HttpSession session = request.getSession();
		session.setAttribute("lag", "vi_VN");
		// Lấy list tin tức
		List<NewsEntity> listtt = BaseService.listTinTuc();
		// Lấy list hình ảnh
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		// Kiểm tra xem là nếu mà cái phần tử nào mà bằng với cái id hình ảnh thì thêm
		// vào
		for (int i = 0; i < sanPhamBanChay.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (sanPhamBanChay.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					sanPhamBanChay.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		
		

		// Đến List sản phẩm sale
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		String ngonngu = request.getParameter("lag");
		if (ngonngu == null) {
			model.addAttribute("lstmn", sanPhamBanChay);
		
			model.addAttribute("lspmt", list);
			model.addAttribute("ltintuc", listtt);
			return "home";
		}
		switch (ngonngu) {
		case "vi_VN": {
			session.setAttribute("lag", "vi_VN");
			break;
		}
		case "ko_KR": {
			session.setAttribute("lag", "ko_KR");
			break;
		}
		case "id_ID": {
			session.setAttribute("lag", "id_ID");
			break;
		}
		case "lo_LA": {
			session.setAttribute("lag", "lo_LA");
			break;
		}
		case "ja_JP": {
			session.setAttribute("lag", "ja_JP");
			break;
		}
		case "en_US": {
			session.setAttribute("lag", "en_US");
			break;
		}
		default: {
			session.setAttribute("lag", "vi_VN");
			break;
		}
		}
		model.addAttribute("lstmn", sanPhamBanChay);
		model.addAttribute("lspmt", list);
		model.addAttribute("ltintuc", listtt);
		return "home";
	}

	// Xem tin tức
	@GetMapping(value = "/xem-tin-tuc/{id}")
	public String xemTinTuc(@PathVariable(value = "id") int idla, Model model) {
		NewsEntity tintuc = BaseService.TimTinTuc(idla);
		model.addAttribute("ltt", tintuc);
		model.addAttribute("tintuc", "Tin tức");
		return "tintuc/tintuc";
	}
}
