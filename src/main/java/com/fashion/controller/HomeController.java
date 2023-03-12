package com.fashion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashion.entity.Hinhanh;
import com.fashion.entity.Sanpham;
import com.fashion.entity.TinTuc;

@Controller
public class HomeController {

	@RequestMapping(value = { "", "/fashion" }, method = RequestMethod.GET)
	public String homeFahsion(Model model, HttpServletRequest request) {
		// Lấy ra 12 sản phẩm mới nhất
		List<Sanpham> lst = TienIch.sanPhamMoiNhat();
		// Sản phẩm nổi bật
		List<Sanpham> list = TienIch.sanPhamSale();
		// Nạp sản phẩm đang sale
		HttpSession session = request.getSession();
		session.setAttribute("lag", "vi_VN");
		// Lấy list tin tức
		List<TinTuc> listtt = TienIch.listTinTuc();
		// Lấy list hình ảnh
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		// Kiểm tra xem là nếu mà cái phần tử nào mà bằng với cái id hình ảnh thì thêm
		// vào
		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (lst.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					lst.get(i).setListHinhAnh(lhanh);
				}
			}
		}

		// Đến List sản phẩm sale
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		String ngonngu = request.getParameter("lag");
		if (ngonngu == null) {
			model.addAttribute("lst", lst);
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
		model.addAttribute("lst", lst);
		model.addAttribute("lspmt", list);
		model.addAttribute("ltintuc", listtt);
		return "home";
	}

	// Xem tin tức
	@GetMapping(value = "/xem-tin-tuc/{id}")
	public String xemTinTuc(@PathVariable(value = "id") int idla, Model model) {
		TinTuc tintuc = TienIch.TimTinTuc(idla);
		model.addAttribute("ltt", tintuc);
		model.addAttribute("tintuc", "Tin tức");
		return "tintuc/tintuc";
	}
}
