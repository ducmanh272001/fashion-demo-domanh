package com.fashion.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fashion.entity.Hinhanh;
import com.fashion.entity.HoaDon;
import com.fashion.entity.HoaDonChiTiet;
import com.fashion.entity.KhachHang;
import com.fashion.entity.LoaiSanPham;
import com.fashion.entity.NhanHieu;
import com.fashion.entity.SanPhamChiTiet;
import com.fashion.entity.Sanpham;
import com.fashion.entity.ThongBao;
import com.fashion.entity.TinTuc;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class AdminController {

	@GetMapping(value = "/ql-san-pham")
	public String quanLySanPham(HttpServletRequest request, @RequestParam(required = false) Map<String, String> param,
			Model model) {
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null || ROLE.equals("USER")) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			List<LoaiSanPham> lsp = TienIch.ListLoaiSanPham();
			int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
			model.addAttribute("sotrang", sotrang);
			List<Sanpham> list = TienIch.PhanTrang(sotrang);
			model.addAttribute("list", list);
			model.addAttribute("lsp", lsp);
			listNhanHieu(model);
			Long slsp = TienIch.count();
			model.addAttribute("sl", slsp);
			String lag = request.getParameter("lag");
			if (lag == null) {
				return "admin/sanpham";
			}
			switch (lag) {
			case "vi": {
				session.setAttribute("lag", "vi_VN");
				break;
			}
			case "en": {
				session.setAttribute("lag", "en_US");
				break;
			}
			case "ja": {
				session.setAttribute("lag", "ja_JP");
				break;
			}
			case "ko": {
				session.setAttribute("lag", "ko_KR");
				break;
			}
			case "lo": {
				session.setAttribute("lag", "lo_LA");
				break;
			}
			default:
				session.setAttribute("lag", "vi_VN");
			}
			return "admin/sanpham";
		}

		return "redirect:/dang-nhap";
	}

	// Lấy ra dánh sách Nhãn hiệu
	private static void listNhanHieu(Model model) {
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Nhan-hieu/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<NhanHieu>>() {
		}.getType();
		List<NhanHieu> list = gs.fromJson(data, typeOfT);
		model.addAttribute("lnh", list);
	}

	// Gửi cái form tìm kiếm sản phẩm ngay tại đây
	@GetMapping(value = "/tim-kiem-sp")
	public String timKiemSanPham(HttpServletRequest request, Model model) {
		// Lấy tên tìm + nhãn hiệu + loại sản phẩm để tìm
		String tentim = request.getParameter("tentim");
		int loaisp = Integer.parseInt(request.getParameter("loaisanpham"));
		int nhanhieu = Integer.parseInt(request.getParameter("nhanhieu"));
		// List sản phẩm ở đây
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> listspp = gs.fromJson(data, typeOfT);
		//////////////////////////////////
		for (int i = 0; i < listspp.size(); i++) {
			if (listspp.get(i).getName().equals(tentim) && listspp.get(i).getIdtheloai() == loaisp
					&& listspp.get(i).getIdnhanhieu() == nhanhieu) {
				model.addAttribute("ltim", listspp.get(i));
				// Gửi lại cái list của nhan hiệu và list của loại sản phẩm
				listNhanHieu(model);
				List<LoaiSanPham> lst = TienIch.ListLoaiSanPham();
				model.addAttribute("lsp", lst);
				return "admin/sanpham";
			}
		}
		// Lạp lại cái list cho nhãn hiệu và list cho loại sản phẩm
		listNhanHieu(model);
		List<LoaiSanPham> lst = TienIch.ListLoaiSanPham();
		model.addAttribute("lsp", lst);
		model.addAttribute("oco", "Không tìm thấy sản phẩm!");
		return "admin/sanpham";
	}

	// list Log

	// Quản lý khách hàng
	@GetMapping(value = "/khach-hang")
	public String QuanLyKh(@RequestParam(required = false) Map<String, String> param, HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
			List<KhachHang> list = TienIch.phanTrangKhachHang(sotrang);
			model.addAttribute("lok", list);
			Long soluong = TienIch.CountKhachHang();
			model.addAttribute("sl", soluong);
			return "khachhang/khachhang";
		}
		return "redirect:/dang-nhap";
	}

	// Sửa khách hàng
	@GetMapping(value = "/sua-khach-hang/{idla}")
	public String suaKhachHang(@PathVariable(value = "idla") int idla, Model model) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/search-kh/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		KhachHang kh = gs.fromJson(dulieu, KhachHang.class);
		model.addAttribute("kh", kh);
		return "khachhang/update";
	}

	// Sửa khách hàng
	@PostMapping(value = "/udate-kh-tc")
	public String updateKhachHangThanhCong(@ModelAttribute(value = "kh") @Valid KhachHang khachhang,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("kh", khachhang);
			return "khachhang/update";
		}
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(khachhang);
		TienIch.SuaKhachHang(data);
		return "redirect:/khach-hang";
	}

	// Xóa khách hàng
	@GetMapping(value = "/delete-khach-hang/{idla}")
	public String deleteKhachHang(@PathVariable(value = "idla") int idla, Model model) {
		String xoatc = TienIch.deleteKhachHang(idla);
		model.addAttribute("xoatc", xoatc);
		return "redirect:/khach-hang";
	}

	// List hóa đơn
	@GetMapping(value = "/list-hoa-don")
	public String ListHoaDon(@RequestParam(required = false) Map<String, String> param, HttpServletRequest request,
			Model model) {
		// Lấy role để so sanh 2 giá trị
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
			List<HoaDon> list = TienIch.phanTrangHoaDon(sotrang);
			model.addAttribute("list", list);
			int soluong = TienIch.CountHoaDon();
			model.addAttribute("sl", soluong);
			return "hoadon/hoadon";
		}
		return "redirect:/dang-nhap";
	}

	// Xử lý hóa đơn
	@GetMapping(value = "/sua-hoa-don/{idla}")
	public String xuLyHoaDon(@PathVariable(value = "idla") int idla, Model model) {
		HoaDon hd = TienIch.timHoaDon(idla);
		model.addAttribute("hd", hd);
		return "hoadon/update";
	}

	@PostMapping(value = "/sua-hd-tc")
	public String suaHoaDon(@ModelAttribute(value = "hd") HoaDon hoadon) {
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		int idkh = hoadon.getIdmakh();
		KhachHang kh = TienIch.selectByKhachHang(idkh);
		hoadon.setMakh(kh);
		String data = gs.toJson(hoadon);
		TienIch.suaHoaDon(data);
		return "redirect:/list-hoa-don";
	}

	@GetMapping(value = "/delete-hoadon/{idxoa}")
	public String xoaHoaDon(@PathVariable(value = "idxoa") int idxoa,
			@RequestParam(required = false) Map<String, String> param, Model model) {
		String xoatc = TienIch.xoaHoaDon(idxoa);
		model.addAttribute("xoatc", xoatc);
		// Nạp lại phân trang
		int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
		List<HoaDon> list = TienIch.phanTrangHoaDon(sotrang);
		model.addAttribute("list", list);
		int soluong = TienIch.CountHoaDon();
		model.addAttribute("sl", soluong);
		return "hoadon/hoadon";
	}

	@PostMapping(value = "/xuly-hoadon-ok")
	public String xuLyOk(HttpServletRequest request) {
		Boolean trangthai = Boolean.parseBoolean(request.getParameter("trangthai"));
		int idla = Integer.parseInt(request.getParameter("idla"));
		HoaDon hd = TienIch.timHoaDon(idla);
		hd.setStatus(trangthai);
		int idkh = hd.getIdmakh();
		KhachHang kh = TienIch.selectByKhachHang(idkh);
		hd.setMakh(kh);
		// Sẽ sửa lại hóa đơn
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(hd);
		TienIch.suaHoaDon(data);
		return "redirect:/list-hoa-don";
	}

	// xEM chi tiết hóa đơn
	@GetMapping(value = "/xem-ct-hoa-don/{idla}")
	public String xemChitietHoaDon(@PathVariable(value = "idla") int idla, HttpServletRequest request, Model model) {
		List<HoaDonChiTiet> list = TienIch.listHoaDonChiTiet(idla);
		HttpSession session = request.getSession();
		float tongtien = 0;
		for (HoaDonChiTiet hdct : list) {
			int Idspct = hdct.getIdSanPhamCt();
			SanPhamChiTiet spct = TienIch.searchSanPhamCt(Idspct);
			hdct.setId_sp(spct);
			// Tính tổng tiển
			tongtien += hdct.getPrice() * hdct.getQuantity();
		}
		session.setAttribute("tthd", tongtien);
		model.addAttribute("list", list);
		return "hoadon/chitiet-hoadon";
	}

	// Tin tức
	@GetMapping(value = "/tin-tuc")
	public String listTinTuc(HttpServletRequest request, Model model) {
		// Lấy list tin tức
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			List<TinTuc> list = TienIch.listTinTuc();
			model.addAttribute("list", list);
			model.addAttribute("title", "Tạo tin tức");
			model.addAttribute("tintuc", "Tin tức");
			// Số lượng tin tức
			int soluong = TienIch.countTinTuc();
			model.addAttribute("sl", soluong);
			return "admin/tintuc";
		}
		return "redirect:/dang-nhap";
	}

	@GetMapping(value = "/insert-tin-tuc")
	public String insertTinTuc(Model model) {
		TinTuc tintuc = new TinTuc();
		model.addAttribute("tintuc", tintuc);
		return "admin/insert-tin-tuc";
	}

	// Thêm tin tức
	@PostMapping(value = "/insert-tintuc-thanhcong")
	public String insertThanhCong(HttpServletRequest request, @ModelAttribute(value = "tintuc") @Valid TinTuc tintuc,
			BindingResult result, @RequestParam(value = "information") String infor, Model model,
			@RequestParam(value = "uploadfile") MultipartFile mf) {
		if (result.hasErrors()) {
			model.addAttribute("tintuc", tintuc);
			model.addAttribute("information", infor);
			return "admin/insert-tin-tuc";
		}
		// Sau lấy về tên đường dẫn
		String tendd = mf.getOriginalFilename();
		/////////////////////////////////////////
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/insert";
		Client client = ClientBuilder.newClient();
		client.register(MultiPartFeature.class);
		Date ngay = new Date();
		tintuc.setDay_tin(ngay);
		tintuc.setImg(tendd);
		tintuc.setContent(infor);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String dulieu = gs.toJson(tintuc);

		// Lấy ra cái list tin tức
		String URLl = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/list";
		WebTarget targetsp = client.target(URLl);
		WebTarget target = client.target(URL);
		String listSp = targetsp.request(MediaType.APPLICATION_JSON).get(String.class);
		Type lok = new TypeToken<List<TinTuc>>() {
		}.getType();
		List<TinTuc> spList = gs.fromJson(listSp, lok);
		for (int i = 0; i < spList.size(); i++) {
			if (spList.get(i).getImg().equals(tendd)) {
				model.addAttribute("tintuc", tintuc);
				model.addAttribute("tbl", "Error hình ảnh sản phẩm đã có trong database !");
				return "admin/insert-tin-tuc";
			}
		}
		// Đây là lưu lại fie hình ảnh
		String ddgoc = request.getServletContext().getRealPath("/public/img");
		try {
			File file = new File(ddgoc + File.separator + tendd);
			System.out.println(file);
			byte luu[] = mf.getBytes();
			Path path = file.toPath();
			Files.write(path, luu, StandardOpenOption.CREATE_NEW);
			// Đọc dữ liệu đã
			FormDataMultiPart fdm = new FormDataMultiPart();
			InputStream is = mf.getInputStream();
			fdm.field("mf", is, new MediaType());
			fdm.field("dulieu", dulieu);
			Response response = target.request().post(Entity.entity(fdm, MediaType.MULTIPART_FORM_DATA));
			String trave = response.readEntity(String.class);
			ThongBao tb = gs.fromJson(trave, ThongBao.class);
			if (tb.getMacode() == 0) {
				model.addAttribute("tintuc", tintuc);
				model.addAttribute("tb", tb);
				model.addAttribute("information", infor);
				return "admin/insert-tin-tuc";
			}
		} catch (Exception e) {
			model.addAttribute("tintuc", tintuc);
			model.addAttribute("tbl", "Xảy ra lỗi file hình ảnh đã được lưu!");
			model.addAttribute("information", infor);
			return "admin/insert-tin-tuc";
		}
		return "redirect:/tin-tuc";
	}

	// Xóa tin tức
	@GetMapping(value = "/delete-tin-tuc/{idla}")
	public String deleteTinTuc(@PathVariable(value = "idla") int idla, HttpServletRequest request, Model model) {
		// Xóa cả ở trong file lun
		TinTuc timtintuc = TienIch.TimTinTuc(idla);
		String img = timtintuc.getImg();
		String ddgoc = request.getServletContext().getRealPath("/public/img");
		File file = new File(ddgoc + File.separator + img);
		Boolean xoaTc = file.delete();
		if (xoaTc) {
			System.out.println("Đã xóa file img thành công");
		} else {
			System.out.println("Xóa ko thành công");
		}
		ThongBao tb = TienIch.xoaTinTuc(idla);
		model.addAttribute("tb", tb);
		return "redirect:/tin-tuc";
	}

	// Tìm tin tức
	@GetMapping(value = "/search-tin-tuc/{idla}")
	public String searchTinTuc(@PathVariable(value = "idla") int idla, Model model) {
		TinTuc tintuc = TienIch.TimTinTuc(idla);
		model.addAttribute("tintuc", tintuc);
		return "admin/update-tin-tuc";
	}

	@PostMapping(value = "/update-tintuc-thanhcong")
	public String updateTinTuc(HttpServletRequest request, @ModelAttribute(value = "tintuc") @Valid TinTuc tintuc,
			BindingResult result, @RequestParam(value = "information") String infor, Model model,
			@RequestParam(value = "uploadfile") MultipartFile mf) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("tintuc", tintuc);
			model.addAttribute("infor", infor);
			return "admin/update-tin-tuc";
		}
		// Nếu mafko nhập ảnh sẽ lấy ảnh gốc
		String img = null;
		if (mf.getSize() != 0) {
			img = mf.getOriginalFilename();
		} else {
			img = tintuc.getImg();
		}
		// Cái ni là lấy cả id về
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/update";
		String URLLIST = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/list";
		Client client = ClientBuilder.newClient();
		client.register(MultiPartFeature.class);
		WebTarget target = client.target(URLLIST);
		WebTarget target2 = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<TinTuc>>() {
		}.getType();
		Gson gs2 = new Gson();
		List<TinTuc> listok = gs2.fromJson(data, typeOfT);
		Date ngay = new Date();
		tintuc.setDay_tin(ngay);
		tintuc.setImg(img);
		tintuc.setContent(infor);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String dulieu = gs.toJson(tintuc);
		InputStream is = mf.getInputStream();
		FormDataMultiPart fdm = new FormDataMultiPart();
		fdm.field("dulieu", dulieu);
		fdm.field("mf", is, new MediaType());
		for (int i = 0; i < listok.size(); i++) {
			if (listok.get(i).getImg().equals(img)) {
				Response response = target2.request().post(Entity.entity(fdm, MediaType.MULTIPART_FORM_DATA));
				String layve = response.readEntity(String.class);
				ThongBao tb = gs.fromJson(layve, ThongBao.class);
				if (tb.getMacode() == 0) {
					model.addAttribute("tintuc", tintuc);
					model.addAttribute("tb", tb);
					model.addAttribute("information", infor);
					return "admin/update-tin-tuc";
				}
				return "redirect:/tin-tuc";
			}
		}
		// Còn đây thì sẽ lưu lại hình hảnh thôi
		// Nếu mà thay đổi mà muốn xóa lun cả ảnh thì ntn
		String ddgoc = request.getServletContext().getRealPath("/public/img");
		try {
			File file1 = new File(ddgoc + File.separator + tintuc.getImg());
			Boolean xoaTc = file1.delete();
			if (xoaTc) {
				System.out.println("Đã xóa file img thành công");
			} else {
				System.out.println("Xóa ko thành công");
			}
			File file = new File(ddgoc + File.separator + img);
			System.out.println(file);
			Path path = file.toPath();
			byte luulai[] = mf.getBytes();
			Files.write(path, luulai, StandardOpenOption.CREATE_NEW);
			// Và thêm vào formdata mang đi
			Response response = target2.request().post(Entity.entity(fdm, MediaType.MULTIPART_FORM_DATA));
			String tradulieu = response.readEntity(String.class);
			ThongBao tb = gs.fromJson(tradulieu, ThongBao.class);
			if (tb.getMacode() == 0) {
				model.addAttribute("tintuc", tintuc);
				model.addAttribute("tbl", "Sửa tin tức không thành công !");
				model.addAttribute("information", infor);
				return "admin/update-tin-tuc";
			}
		} catch (Exception e) {
			model.addAttribute("tintuc", tintuc);
			model.addAttribute("information", infor);
			model.addAttribute("tbl", "Xảy ra lỗi hình ảnh tin tức đã được lưu!");
			return "admin/update-tin-tuc";
		}
		return "redirect:/tin-tuc";
	}

	@GetMapping(value = "/danh-muc")
	public String danhmuc(@RequestParam(required = false) Map<String, String> param, HttpServletRequest request,
			Model model) {
		// Lấy role để so sanh 2 giá trị
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
			List<LoaiSanPham> list = TienIch.phanTrangDanhMuc(sotrang);
			model.addAttribute("list", list);
			Long soluong = TienIch.countDanhMuc();
			model.addAttribute("sl", soluong);
			model.addAttribute("danhsach", "Danh sách danh mục");
			model.addAttribute("tao", "Tạo danh mục");
			return "danhmuc/danhmuc";
		}
		return "redirect:/dang-nhap";
	}

	@GetMapping(value = "/tim-danh-muc/{idla}")
	public String suaDanhMuc(@PathVariable(value = "idla") int idla, Model model) {
		LoaiSanPham lsp = TienIch.timDanhMuc(idla);
		model.addAttribute("lsp", lsp);
		return "danhmuc/update";
	}

	// Sửa danh mục
	@PostMapping(value = "/sua-danhmuc-tc")
	public String suaThanhCongDanhMuc(@ModelAttribute(value = "lsp") LoaiSanPham loaisp, Model model) {
		Gson gs = new Gson();
		String data = gs.toJson(loaisp);
		ThongBao tb = TienIch.suaDanhMuc(data);
		model.addAttribute("tb", tb);
		if (tb.getMacode() == 1) {
			return "redirect:/danh-muc";
		}
		return "danhmuc/update";
	}

	@GetMapping(value = "/insert-danh-muc")
	public String insertDanhMuc(Model model) {
		LoaiSanPham lsp = new LoaiSanPham();
		model.addAttribute("lsp", lsp);
		return "danhmuc/insert";
	}

	// Thêm danh mục
	@PostMapping(value = "/them-danhmuc-tc")
	public String themThanhCongDanhMuc(@ModelAttribute(value = "lsp") LoaiSanPham loaisp, Model model) {
		Gson gs = new Gson();
		String data = gs.toJson(loaisp);
		ThongBao tb = TienIch.themDanhMuc(data);
		model.addAttribute("tb", tb);
		if (tb.getMacode() == 1) {
			return "redirect:/danh-muc";
		}
		return "danhmuc/insert";
	}

	// Xóa danh mục
	@GetMapping(value = "/delete-danh-muc/{idxoa}")
	public String xoaDanhMuc(@RequestParam(required = false) Map<String, String> param,
			@PathVariable(value = "idxoa") int idxoa, Model model) {
		ThongBao tb = TienIch.xoaDanhMuc(idxoa);
		model.addAttribute("tb", tb);
		int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
		List<LoaiSanPham> list = TienIch.phanTrangDanhMuc(sotrang);
		model.addAttribute("list", list);
		Long soluong = TienIch.countDanhMuc();
		model.addAttribute("sl", soluong);
		model.addAttribute("danhsach", "Danh sách danh mục");
		model.addAttribute("tao", "Tạo danh mục");
		return "danhmuc/danhmuc";
	}

	// Test
	@GetMapping(value = "/trang-them-san-pham")
	public String themSanPham(HttpServletRequest request, Model model) {
		// Lấy cái list nhãn hiệu về đây
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute("role");
		if (ROLE == null || ROLE.equals("USER")) {
			return "redirect:/dang-nhap";
		} else if (ROLE.equals("ADMIN") || ROLE.equals("EDITOR")) {
			List<NhanHieu> listnh = TienIch.ListNhanHieu();
			model.addAttribute("list", listnh);
			List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
			model.addAttribute("lsp", list);
			Sanpham sanpham = new Sanpham();
			model.addAttribute("sanpham", sanpham);
		}
		return "sanpham/insert";
	}

	@PostMapping(value = "/them-san-phamok")
	public String themSanPham(HttpServletRequest request, @ModelAttribute(value = "sanpham") @Valid Sanpham sanpham,
			BindingResult result, Model model, @RequestParam(value = "uploadFile") MultipartFile[] mf)
			throws IOException {
		if (result.hasErrors()) {
			List<NhanHieu> listnh = TienIch.ListNhanHieu();
			model.addAttribute("list", listnh);
			List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
			model.addAttribute("lsp", list);
			model.addAttribute("sanpham", sanpham);
			return "sanpham/insert";
		}
		// Sửa lại import vào ảnh
//		String tensp = request.getParameter("tensp");
//		String mota = request.getParameter("descripe");
//		String information = request.getParameter("information");
//		float gianhap = Float.parseFloat(request.getParameter("gianhap"));
//		float giacu = Float.parseFloat(request.getParameter("giacu"));
//		float giamoi = Float.parseFloat(request.getParameter("giamoi"));
//		int spview = Integer.parseInt(request.getParameter("nguoixem"));
		int loaisp = Integer.parseInt(request.getParameter("loaisanpham"));
		int brand = Integer.parseInt(request.getParameter("nhanhieu"));
//		Boolean trangthai = Boolean.parseBoolean(request.getParameter("status"));
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/insert-san-pham";
		Client client = ClientBuilder.newClient();
		client.register(MultiPartFeature.class);
		NhanHieu nh = new NhanHieu();
		nh.setId(brand);
		LoaiSanPham lsp = new LoaiSanPham();
		lsp.setId(loaisp);
		// Lấy cái ngày cập nhât lun
		Date date = new Date();
		sanpham.setDay_update(date);
		sanpham.setIdnh(nh);
		sanpham.setIdlsp(lsp);
//		Sanpham sanphamok = new Sanpham(tensp, mota, information, gianhap, giacu, giamoi, spview, date, trangthai, nh,
//				lsp);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String dulieu = gs.toJson(sanpham);
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		int masp = tb.getMacode();
		Sanpham timsp = TienIch.searchIdSanPham(masp);
		// Xong sau thêm vào danh mục hình ảnh
		for (MultipartFile multipart : mf) {
			// Đây là lưu lại fie hình ảnh
			String ddgoc = request.getServletContext().getRealPath("/public/img");
			String tenanh = multipart.getOriginalFilename();
			try {
				String mahinhanh = "http://localhost:8080/Fashion-Shop-Api/rest/Hinhanh/insert";
				WebTarget targetha = client.target(mahinhanh);
				Hinhanh fileha = new Hinhanh(tenanh, timsp);
				String dlhinhanh = gs.toJson(fileha);
				File file = new File(ddgoc + File.separator + tenanh);
				System.out.println(file);
				System.out.println("Đường dẫn api");
				byte luu[] = multipart.getBytes();
				Path path = file.toPath();
				Files.write(path, luu, StandardOpenOption.CREATE_NEW);
				// Đọc dữ liệu đã
				FormDataMultiPart fdm = new FormDataMultiPart();
				InputStream is = multipart.getInputStream();
				fdm.field("mf", is, new MediaType());
				fdm.field("dulieu", dlhinhanh);
				Response response2 = targetha.request().post(Entity.entity(fdm, MediaType.MULTIPART_FORM_DATA));
				String traveha = response2.readEntity(String.class);
				ThongBao tbha = gs.fromJson(traveha, ThongBao.class);
				if (tbha.getMacode() == 0) {
					model.addAttribute("spok", sanpham);
					List<NhanHieu> listnh = TienIch.ListNhanHieu();
					model.addAttribute("list", listnh);
					List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
					model.addAttribute("lsp", list);
					model.addAttribute("tb", tb);
					return "sanpham/insert";
				}
			} catch (Exception e) {
				model.addAttribute("spok", sanpham);
				List<NhanHieu> listnh = TienIch.ListNhanHieu();
				model.addAttribute("list", listnh);
				List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
				model.addAttribute("lsp", list);
				model.addAttribute("loinl", "Xảy ra lỗi file hình ảnh đã được lưu!");
				return "sanpham/insert";
			}

		}
		return "redirect:/ql-san-pham";
	}
}
