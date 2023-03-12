package com.fashion.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.entity.Hinhanh;
import com.fashion.entity.Kichco;
import com.fashion.entity.LoaiSanPham;
import com.fashion.entity.Mausac;
import com.fashion.entity.NhanHieu;
import com.fashion.entity.Sanpham;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@GetMapping(value = "/dam")
	public String productDam(Model model) {
		List<Sanpham> listdam = TienIch.ListDamSanPham(null);
		model.addAttribute("lst", listdam);
		return "home";
	}

	@GetMapping(value = "/product-detail")
	public String productDetail() {
		return "product/product-detail";
	}

	@GetMapping(value = "/product-sigle")
	public String productSigle() {
		return "product/product-sigle";
	}

	@GetMapping(value = "/ca-bo")
	public String productCaBo(Model model) {
		List<Sanpham> list = TienIch.ListSanPhamCaBo(model);
		model.addAttribute("lst", list);
		return "home";
	}

	@GetMapping(value = "/ao-dai")
	public String productAoDai(Model model) {
		List<Sanpham> list = TienIch.ListSanPhamAoDai(model);
		model.addAttribute("lst", list);
		return "home";
	}

	@GetMapping(value = "/quan")
	public String productQuan(Model model) {
		List<Sanpham> list = TienIch.ListSanPhamQuan(model);
		model.addAttribute("lst", list);
		return "home";
	}

	/// Lấy tất cả cái list củ áo
	@GetMapping(value = "/ao")
	public String productAo(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.countAo();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "ao");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrangAo(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.PhanTrangAoTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.PhanTrangAoGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		return "product/product-sigle";
	}

	// Lấy list của đầm
	@GetMapping(value = "/all-dam")
	public String productDam(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.countDam();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-dam");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrangDam(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.PhanTrangDamTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.PhanTrangDamGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		return "product/product-sigle";
	}

	// Lấy list của Quần
	@GetMapping(value = "/all-quan")
	public String productQuan(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.countQuan();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-quan");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrangQuan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.PhanTrangQuanTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.PhanTrangQuanGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		return "product/product-sigle";
	}

	// Lấy list của Cả bộ
	@GetMapping(value = "/all-ca-bo")
	public String productCaBo(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.countCaBo();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-ca-bo");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrangCaBo(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.PhanTrangCaBoTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.PhanTrangCaBoGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		return "product/product-sigle";
	}

	// Lấy list của Aó dài
	@GetMapping(value = "/all-ao-dai")
	public String productAoDai(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.countAoDai();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-ao-dai");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrangAoDai(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.PhanTrangAoDaiTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.PhanTrangAoDaiGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		return "product/product-sigle";
	}

	// Lấy ra các sản phẩm bán chạy
	@GetMapping(value = "/ban-chay/dam")
	public String sanPhamDamMoiNhat(Model model) {
		List<Sanpham> list = TienIch.sanPhamDamMoiNhat();
		List<Hinhanh> listha = TienIch.selectAllHinhAnh();
		// Add hinhf anh vao listdam
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		List<Sanpham> lsale = TienIch.sanPhamSale();
		// Đến List sản phẩm sale
		for (int i = 0; i < lsale.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (lsale.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					lsale.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", lsale);
		return "home";
	}

	// Lấy ra các sản phẩm bán chạy
	@GetMapping(value = "/ban-chay/ca-bo")
	public String sanPhamCaBoMoiNhat(Model model) {
		List<Sanpham> list = TienIch.sanPhamCaBoMoiNhat();
		List<Hinhanh> listha = TienIch.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		List<Sanpham> lsale = TienIch.sanPhamSale();
		for (int i = 0; i < lsale.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (lsale.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					lsale.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", lsale);
		return "home";
	}

	// Lấy ra các sản phẩm áo dài bán chạy
	@GetMapping(value = "/ban-chay/ao-dai")
	public String sanPhamAoDaiMoiNhat(Model model) {
		List<Sanpham> list = TienIch.sanPhamAoDaiMoiNhat();
		List<Hinhanh> listha = TienIch.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		List<Sanpham> lsale = TienIch.sanPhamSale();
		for (int i = 0; i < lsale.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (lsale.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					lsale.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", lsale);
		return "home";
	}

	// Lấy ra các sản phẩm quần bán chạy
	@GetMapping(value = "/ban-chay/quan")
	public String sanPhamQuanMoiNhat(Model model) {
		List<Sanpham> list = TienIch.sanPhamQuanMoiNhat();
		List<Hinhanh> listha = TienIch.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		List<Sanpham> lsale = TienIch.sanPhamSale();
		for (int i = 0; i < lsale.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (lsale.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					lsale.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", lsale);
		return "home";
	}

	// Lấy ra các sản phẩm quần bán chạy
	@GetMapping(value = "/ban-chay/ao")
	public String sanPhamAoMoiNhat(Model model) {
		List<Sanpham> list = TienIch.sanPhamAoMoiNhat();
		List<Hinhanh> listha = TienIch.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		List<Sanpham> lsale = TienIch.sanPhamSale();
		for (int i = 0; i < lsale.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (lsale.get(i).getId() == listha.get(j).getIdsp()) {
					List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					lsale.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lspmt", lsale);
		return "home";
	}

	// Lấy tất cả sản phẩm ở đây
	@GetMapping(value = "/all")
	public String TatCaSanPham(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<Hinhanh> hinhanh = TienIch.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = TienIch.count();
		model.addAttribute("sl", slsp);
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		// Lấy category
		List<LoaiSanPham> loaisp = TienIch.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		List<NhanHieu> lnhanhieu = TienIch.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		if (tangdan == null || tangdan.equals("default")) {
			List<Sanpham> list = TienIch.PhanTrang(slpage);
			// Kiểm tra xem là nếu mà cái phần tử nào mà bằng với cái id hình ảnh thì thêm
			// vào
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
		} else if (tangdan.equals("ascending")) {
			List<Sanpham> list = TienIch.phanTrangSanPhamTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<Sanpham> list = TienIch.phanTrangSanPhamGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<Hinhanh> lhanh = TienIch.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		}
		model.addAttribute("ten", "all");
		return "product/product-sigle";
	}

}
