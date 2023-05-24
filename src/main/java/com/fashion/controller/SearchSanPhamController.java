package com.fashion.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.base.BaseService;
import com.fashion.entity.ImagerEntity;
import com.fashion.entity.TypeProductEntity;
import com.fashion.entity.BranchEntity;
import com.fashion.entity.ProductEntity;

@Controller
public class SearchSanPhamController {

	@GetMapping(value = "/ket-qua-tim-kiem")
	public String searchName(@RequestParam(value = "name") String tenla, Model model) {
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		List<ProductEntity> list = BaseService.selectByNameProduct(tenla);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		int mucgia = Integer.parseInt(request.getParameter("gia"));
		// Lấy lại cái list loại sản phẩm
		List<TypeProductEntity> loaisp = BaseService.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<BranchEntity> lnhanhieu = BaseService.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		if (mucgia == 100) {
			model.addAttribute("mucgia", mucgia);
			List<ProductEntity> list = BaseService.sanPham100den200();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 200) {
			model.addAttribute("mucgia", mucgia);
			List<ProductEntity> list = BaseService.sanPham200den300();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 300) {
			model.addAttribute("mucgia", mucgia);
			List<ProductEntity> list = BaseService.sanPham300den500();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			
			model.addAttribute("list", list);
		} else if (mucgia == 500) {
			model.addAttribute("mucgia", mucgia);
			List<ProductEntity> list = BaseService.sanPhamTren500();
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		int idla = Integer.parseInt(request.getParameter("nhanhieu"));
		model.addAttribute("idla", idla);
		// Lấy lại cái list loại sản phẩm
		List<TypeProductEntity> loaisp = BaseService.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<BranchEntity> lnhanhieu = BaseService.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		// Lấy page mặc định là 1
		Long slsp = BaseService.countNhanHieu(idla);
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		// Tìm nhãn hiệu
		List<ProductEntity> list = BaseService.timNhanHieu(idla, page);
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		List<TypeProductEntity> loaisp = BaseService.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<BranchEntity> lnhanhieu = BaseService.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		////////
		model.addAttribute("timlsp", "timLoaiSanPham");
		int loaisanpham = Integer.parseInt(param.getOrDefault("loaisp", "1"));
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		// Mặc định là lấy ra 8 sản phẩm đầu tiên
		if (loaisanpham == 1) {
			List<ProductEntity> list = BaseService.PhanTrangCaBo(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = BaseService.countCaBo();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
			// Car booj
		} else if (loaisanpham == 2) {
			// Đầm
			List<ProductEntity> list = BaseService.PhanTrangDam(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = BaseService.countDam();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 3) {
			// Aó
			List<ProductEntity> list = BaseService.PhanTrangAo(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = BaseService.countAo();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 4) {
			// Quần
			List<ProductEntity> list = BaseService.PhanTrangQuan(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = BaseService.countQuan();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		} else if (loaisanpham == 5) {
			// Aó dai
			List<ProductEntity> list = BaseService.PhanTrangAoDai(page);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			Long dem = BaseService.countAoDai();
			model.addAttribute("sl", dem);
			model.addAttribute("idla", loaisanpham);
		}
		return "product/product-sigle";
	}
	
	
	
	///tìm kiếm theo giá
	@GetMapping(value = "/tim-kiem-product")
	public String selectByName(@RequestParam(value = "tensp")String tenla, Model model) {
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		List<TypeProductEntity> loaisp = BaseService.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		// Lấy list nhãn hiệu
		List<BranchEntity> lnhanhieu = BaseService.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		/////////////////
		List<ProductEntity> list = BaseService.selectByNameProduct(tenla);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hinhanh.size(); j++) {
				if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("tenla", tenla);
		model.addAttribute("list", list);
		return "product/product-sigle";
	}

}
