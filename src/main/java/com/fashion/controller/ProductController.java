package com.fashion.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.base.BaseService;
import com.fashion.entity.CartDetailEntity;
import com.fashion.entity.ImagerEntity;
import com.fashion.entity.SizeEntity;
import com.fashion.entity.TypeProductEntity;
import com.fashion.entity.ColorEntity;
import com.fashion.entity.BranchEntity;
import com.fashion.entity.ProductEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@GetMapping(value = "/dam")
	public String productDam(Model model) {
		List<ProductEntity> listdam = BaseService.ListDamSanPham(null);
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
		List<ProductEntity> list = BaseService.ListSanPhamCaBo(model);
		model.addAttribute("lst", list);
		return "home";
	}

	@GetMapping(value = "/ao-dai")
	public String productAoDai(Model model) {
		List<ProductEntity> list = BaseService.ListSanPhamAoDai(model);
		model.addAttribute("lst", list);
		return "home";
	}

	@GetMapping(value = "/quan")
	public String productQuan(Model model) {
		List<ProductEntity> list = BaseService.ListSanPhamQuan(model);
		model.addAttribute("lst", list);
		return "home";
	}

	/// Lấy tất cả cái list củ áo
	@GetMapping(value = "/ao")
	public String productAo(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.countAo();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "ao");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrangAo(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.PhanTrangAoTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.PhanTrangAoGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.countDam();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-dam");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrangDam(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.PhanTrangDamTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.PhanTrangDamGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.countQuan();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-quan");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrangQuan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.PhanTrangQuanTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.PhanTrangQuanGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.countCaBo();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-ca-bo");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrangCaBo(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.PhanTrangCaBoTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.PhanTrangCaBoGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.countAoDai();
		model.addAttribute("sl", slsp);
		model.addAttribute("ten", "all-ao-dai");
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrangAoDai(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.PhanTrangAoDaiTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.PhanTrangAoDaiGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
		List<ProductEntity> list = BaseService.sanPhamDamMoiNhat();
		List<ImagerEntity> listha = BaseService.selectAllHinhAnh();
		// Add hinhf anh vao listdam
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		
		return "home";
	}

	// Lấy ra các sản phẩm bán chạy
	@GetMapping(value = "/ban-chay/ca-bo")
	public String sanPhamCaBoMoiNhat(Model model) {
		List<ProductEntity> list = BaseService.sanPhamCaBoMoiNhat();
		List<ImagerEntity> listha = BaseService.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		return "home";
	}

	// Lấy ra các sản phẩm áo dài bán chạy
	@GetMapping(value = "/ban-chay/ao-dai")
	public String sanPhamAoDaiMoiNhat(Model model) {
		List<ProductEntity> list = BaseService.sanPhamAoDaiMoiNhat();
		List<ImagerEntity> listha = BaseService.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		return "home";
	}

	// Lấy ra các sản phẩm quần bán chạy
	@GetMapping(value = "/ban-chay/quan")
	public String sanPhamQuanMoiNhat(Model model) {
		List<ProductEntity> list = BaseService.sanPhamQuanMoiNhat();
		List<ImagerEntity> listha = BaseService.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		
		return "home";
	}

	// Lấy ra các sản phẩm quần bán chạy
	@GetMapping(value = "/ban-chay/ao")
	public String sanPhamAoMoiNhat(Model model) {
		List<ProductEntity> list = BaseService.sanPhamAoMoiNhat();
		List<ImagerEntity> listha = BaseService.selectAllHinhAnh();
		// Add hinhf anh vao listcabo
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listha.size(); j++) {
				if (list.get(i).getId() == listha.get(j).getIdsp()) {
					List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(listha.get(j).getIdsp());
					list.get(i).setListHinhAnh(lhanh);
				}
			}
		}
		model.addAttribute("lst", list);
		// Lấy thêm sản phẩm sale
		
		return "home";
	}

	// Lấy tất cả sản phẩm ở đây
	@GetMapping(value = "/all")
	public String TatCaSanPham(Model model, @RequestParam(required = false) Map<String, String> param,
			HttpServletRequest request) {
		List<ImagerEntity> hinhanh = BaseService.selectAllHinhAnh();
		String tangdan = request.getParameter("show");
		int slpage = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("trang", slpage);
		Long slsp = BaseService.count();
		model.addAttribute("sl", slsp);
		// Lấy tên của get parametter
		model.addAttribute("tangdan", tangdan);
		// Số lượng page
		model.addAttribute("slpage", slpage);
		// Lấy category
		List<TypeProductEntity> loaisp = BaseService.ListLoaiSanPham();
		model.addAttribute("loaisp", loaisp);
		List<BranchEntity> lnhanhieu = BaseService.ListNhanHieu();
		model.addAttribute("lnh", lnhanhieu);
		if (tangdan == null || tangdan.equals("default")) {
			List<ProductEntity> list = BaseService.PhanTrang(slpage);
			// Kiểm tra xem là nếu mà cái phần tử nào mà bằng với cái id hình ảnh thì thêm
			// vào
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			// Đếm số lượng trong list = list.size()
			model.addAttribute("size", list.size());
		} else if (tangdan.equals("ascending")) {
			List<ProductEntity> list = BaseService.phanTrangSanPhamTangDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
						list.get(i).setListHinhAnh(lhanh);
					}
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			return "product/product-sigle";
		} else if (tangdan.equals("decrease")) {
			List<ProductEntity> list = BaseService.phanTrangSanPhamGiamDan(slpage);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < hinhanh.size(); j++) {
					if (list.get(i).getId() == hinhanh.get(j).getIdsp()) {
						List<ImagerEntity> lhanh = BaseService.selectByIdSpHinhAnh(hinhanh.get(j).getIdsp());
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
	
	
	///Ao nu
	@GetMapping(value = {"/ao-nu/{idla}", "/ao-nu/{idla}/"})
	public String aoNuA280(@PathVariable(value = "idla") int idok,@RequestParam(value = "tt", required = false) Integer tt,HttpServletRequest request, Model model) {
		// Nạp biến api Tìm theo id vào đây
		
		
		List<String> lst = BaseService.sanPhamBanChay();
		List<Long> longList = lst.stream()
		                        .map(Long::parseLong)
		                        .collect(Collectors.toList());

        List<ProductEntity> sanPhamBanChay = new ArrayList<>();
        
        for (int i = 0; i < longList.size(); i++) {
			ProductEntity productEntity =  BaseService.searchIdSanPham(longList.get(i).intValue());
			sanPhamBanChay.add(productEntity);
		}
        
        
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
		
		
		String URL = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product/search-id/"
				+ idok;
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ProductEntity sp = gs.fromJson(data, ProductEntity.class);
		
		
		
		// Tìm áo nữ này có id là mấy thì gắn vào list hình ảnh
		List<ImagerEntity> listha = BaseService.selectByIdSpHinhAnh(sp.getId());
		sp.setListHinhAnh(listha);
		model.addAttribute("sp", sp);
		// Bỏ cái size vào đây
		String kichco = "https://fashion-shop-api.herokuapp.com/rest/api/v1/size";
		Client cliekc = ClientBuilder.newClient();
		WebTarget targekc = cliekc.target(kichco);
		String layve = targekc.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<SizeEntity>>() {
		}.getType();
		List<SizeEntity> lsize = gs.fromJson(layve, typeOfT);
		model.addAttribute("lsize", lsize);
		// Lấy cái list màu sắc
		String mausac = "https://fashion-shop-api.herokuapp.com/rest/api/v1/color";
		WebTarget ms = client.target(mausac);
		String layms = ms.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typems = new TypeToken<List<ColorEntity>>() {
		}.getType();
		List<ColorEntity> lms = gs.fromJson(layms, typems);
		model.addAttribute("lms", lms);
		
		
		///sản phẩm sal phải từ 2 sảnphâm trở lên
		// List sản phẩm nổi bật
		
		model.addAttribute("lspmt", sanPhamBanChay);
		model.addAttribute("tonkho", tt);
		// Số lượng đơn
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		int dem = 0;
		if (lokk == null) {
			model.addAttribute("dem", dem);
			return "product/aonu/product-detail";
		}
		// Còn không bằng null thì lấy dữ liệu ra
		for (CartDetailEntity cct : lokk) {
			dem += cct.getSanphamchitiet().getAmount();
		}
		model.addAttribute("dem", dem);
		
		
		return "product/aonu/product-detail";
	}
	
	

}
