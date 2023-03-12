package com.fashion.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.entity.Hinhanh;
import com.fashion.entity.LoaiSanPham;
import com.fashion.entity.NhanHieu;
import com.fashion.entity.Sanpham;

@Controller
public class SearchSanPham {

	@GetMapping(value = "/ket-qua-tim-kiem")
	public String searchName(@RequestParam(value = "name") String tenla, Model model) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		List<Sanpham> list = TienIch.selectByNameProduct(tenla);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("ten", tenla);
		model.addAttribute("lst", list);
		return "home";
	}

	@GetMapping(value = "/timKiemTheoGia")
	public String timKiemSanPham(HttpServletRequest request, Model model) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		int mucgia = Integer.parseInt(request.getParameter("gia"));
		// Lấy lại cái list loại sản phẩm
		List<LoaiSanPham> loaisp = TienIch.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<NhanHieu> lnhanhieu = TienIch.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		if (mucgia == 100) {
			model.addAttribute("mucgia", mucgia);
			List<Sanpham> list = TienIch.sanPham100den200();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 200) {
			model.addAttribute("mucgia", mucgia);
			List<Sanpham> list = TienIch.sanPham200den300();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 300) {
			model.addAttribute("mucgia", mucgia);
			List<Sanpham> list = TienIch.sanPham300den500();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 500) {
			model.addAttribute("mucgia", mucgia);
			List<Sanpham> list = TienIch.sanPhamTren500();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		}
		return "product/product-sigle";
	}

	@GetMapping(value = "/product/timBrand")
	public String timLoaiSanPham(HttpServletRequest request, Model model,
			@RequestParam(required = false) Map<String, String> param) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		int idla = Integer.parseInt(request.getParameter("nhanhieu"));
		model.addAttribute("idla", idla);
		// Lấy lại cái list loại sản phẩm
		List<LoaiSanPham> loaisp = TienIch.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<NhanHieu> lnhanhieu = TienIch.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		// Lấy page mặc định là 1
		Long slsp = TienIch.countNhanHieu(idla);
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		// Tìm nhãn hiệu
		List<Sanpham> list = TienIch.timNhanHieu(idla, page);
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
//		model.addAttribute("pok", page);
		model.addAttribute("list", list);
		// Đếm số phần tử trong list nhãn hiệu
		model.addAttribute("sl", slsp);
		model.addAttribute("timbrand", "timBrand");
		return "product/product-sigle";
	}

	// Tìm loại sản phẩm
	@GetMapping(value = "/product/timLoaiSanPham")
	public String timLoaiSanPham(@RequestParam(required = false) Map<String, String> param, Model model) {
		// Lấy lại cái list loại sản phẩm
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		List<LoaiSanPham> loaisp = TienIch.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<NhanHieu> lnhanhieu = TienIch.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		////////
		model.addAttribute("timlsp", "timLoaiSanPham");
		int loaisanpham = Integer.parseInt(param.getOrDefault("loaisp", "1"));
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		// Mặc định là lấy ra 8 sản phẩm đầu tiên
		if (loaisanpham == 1) {
			List<Sanpham> list = TienIch.PhanTrangCaBo(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = TienIch.countCaBo();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
			// Car booj
		} else if (loaisanpham == 2) {
			// Đầm
			List<Sanpham> list = TienIch.PhanTrangDam(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = TienIch.countDam();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 3) {
			// Aó
			List<Sanpham> list = TienIch.PhanTrangAo(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = TienIch.countAo();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 4) {
			// Quần
			List<Sanpham> list = TienIch.PhanTrangQuan(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = TienIch.countQuan();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 5) {
			// Aó dai
			List<Sanpham> list = TienIch.PhanTrangAoDai(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = TienIch.countAoDai();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		}
		return "product/product-sigle";
	}
	
	
	
	///tìm kiếm theo giá
	@GetMapping(value = "/tim-kiem-product")
	public String selectByName(@RequestParam(value = "tensp")String tenla, Model model) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		List<LoaiSanPham> loaisp = TienIch.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<NhanHieu> lnhanhieu = TienIch.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		/////////////////
		List<Sanpham> list = TienIch.selectByNameProduct(tenla);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("tenla", tenla);
		model.addAttribute("list", list);
		return "product/product-sigle";
	}

}
