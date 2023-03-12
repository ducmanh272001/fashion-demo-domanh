package com.fashion.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.ui.Model;

import com.fashion.entity.CartChiTiet;
import com.fashion.entity.Hinhanh;
import com.fashion.entity.HoaDon;
import com.fashion.entity.HoaDonChiTiet;
import com.fashion.entity.KhachHang;
import com.fashion.entity.Kichco;
import com.fashion.entity.LoaiSanPham;
import com.fashion.entity.Mausac;
import com.fashion.entity.NhanHieu;
import com.fashion.entity.Roles;
import com.fashion.entity.SanPhamChiTiet;
import com.fashion.entity.Sanpham;
import com.fashion.entity.ThongBao;
import com.fashion.entity.TinTuc;
import com.fashion.entity.User;
import com.fashion.entity.UserRole;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TienIch {

	public static int getsoluong(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<CartChiTiet> lokk = (List<CartChiTiet>) session.getAttribute("listct");
		int dem = 0;
		for (CartChiTiet cct : lokk) {
			dem += cct.getSanphamchitiet().getAmount();
		}
		return dem;
	}

///Tính tổng tiền
	public static float gettongtien(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<CartChiTiet> lokk = (List<CartChiTiet>) session.getAttribute("listct");
		float tongtien = 0;
		for (CartChiTiet cct : lokk) {
			tongtien += cct.getSanphamchitiet().getMact().getPrice_new() * cct.getSanphamchitiet().getAmount();
		}
		return tongtien;
	}

	// Thêm list Khách Hàng
	public static List<KhachHang> listKhachHang() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<KhachHang>>() {
		}.getType();
		List<KhachHang> lstkh = gs.fromJson(data, typeOfT);
		return lstkh;
	}

	// List SanPhamCHi tiết search id hoadon
	public static List<HoaDonChiTiet> listHoaDonChiTiet(int id) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Ct-hoa-don/search-id-hoadon/" + id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<HoaDonChiTiet>>() {
		}.getType();
		List<HoaDonChiTiet> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Thêm list Khách Hàng
	public static int InsertKhachHang(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb.getMacode();
	}

	// Insert Hóa đơn
	public static int InsertHoaDon(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb.getMacode();
	}

	public static KhachHang selectByKhachHang(int id) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/search-kh/" + id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		KhachHang kh = gs.fromJson(data, KhachHang.class);
		return kh;
	}

	// Về trang chủ
	public static List<Sanpham> ListSanPham(Model model) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> lst = gs.fromJson(data, typeOfT);
		model.addAttribute("lst", lst);
		return lst;
	}
	
	// Tra ID
	public static Sanpham searchIdSanPham(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/search-id/" + idla;
		Gson gs = new Gson();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String trave = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Sanpham sp = gs.fromJson(trave, Sanpham.class);
		return sp;
	}

	// Lọc theo đầm
	public static List<Sanpham> ListDamSanPham(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham/dam";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> ldam = gs.fromJson(data, typeOfT);
		return ldam;
	}

	// Lọc theo đầm
	public static List<Sanpham> ListShirt(Model model) {
		String URLAO = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham/ao";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLAO);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> lao = gs.fromJson(data, typeOfT);
		return lao;
	}

	// Lọc theo set cả bộ
	public static List<Sanpham> ListSanPhamCaBo(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham/ca-bo";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> lcabo = gs.fromJson(data, typeOfT);
		return lcabo;
	}

	// Lọc theo set cả bộ
	public static List<Sanpham> ListSanPhamAoDai(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham/ao-dai";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> laodai = gs.fromJson(data, typeOfT);
		return laodai;
	}

	// Lọc theo set cả bộ
	public static List<Sanpham> ListSanPhamQuan(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham/quan";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> laodai = gs.fromJson(data, typeOfT);
		return laodai;
	}

	// Lấy ra số lượng khách hàng
	public static long CountKhachHang() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/count-khach-hang";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int SLKH = Integer.parseInt(dulieu);
		return SLKH;
	}

	// Lấy ra số lượng Hóa Đơn
	public static int CountHoaDon() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/count-hoa-don";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int sohd = Integer.parseInt(dulieu);
		return sohd;
	}

	/// Sửa Khách Hàng
	public static void SuaKhachHang(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
	}

	// Xóa khách hàng
	public static String deleteKhachHang(int xoaid) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/deleteKhachHang/" + xoaid;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		KhachHang kh = new KhachHang();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(kh);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		String xoatc = tb.getText();
		return xoatc;
	}

	// List hóa đơn
	public static List<HoaDon> ListHoaDon() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<HoaDon>>() {
		}.getType();
		List<HoaDon> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Sửa hóa đơn
	public static String suaHoaDon(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String suatc = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		ThongBao tb = gs.fromJson(suatc, ThongBao.class);
		String thongbao = tb.getText();
		return thongbao;
	}

	// tìm hóa đơn
	public static HoaDon timHoaDon(int idtim) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/search-id-hd/" + idtim;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		HoaDon hd = gs.fromJson(data, HoaDon.class);
		return hd;
	}

	// Xóa hóa đơn
	public static String xoaHoaDon(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/delete-hoa-don/" + idxoa;
		HoaDon hd = new HoaDon();
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(hd);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb.getText();
	}

	// Xem chi tiết hóa đơn
	public static SanPhamChiTiet searchSanPhamCt(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/san-pham-detail/search-sp-detail/" + idla;
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget spdetail = client.target(URL);
		String detail = spdetail.request(MediaType.APPLICATION_JSON).get(String.class);
		SanPhamChiTiet spctok = gs.fromJson(detail, SanPhamChiTiet.class);
		return spctok;
	}

	// Lấy ra sản phẩm đang sale
	public static List<Sanpham> sanPhamSale() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-sale";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;

	}

	// Lấy user
	public static User kiemTraDangNhap(String taikhoan, String matkhau) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/User/kiemTraDangNhap/" + taikhoan + "/" + matkhau;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		User user = gs.fromJson(data, User.class);
		return user;
	}

	// Lấy list User
	public static List<User> listUser() {
		// Lấy ra list user
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/User";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<User>>() {
		}.getType();
		List<User> user = gs.fromJson(data, typeOfT);
		return user;
	}

	// Lấy ra sản phẩm mới nhất
	public static List<Sanpham> sanPhamMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;

	}

	// Lấy ra số lượng phân trang
	public static List<Sanpham> PhanTrang(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang
	public static List<Sanpham> PhanTrangAo(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang Đầm
	public static List<Sanpham> PhanTrangDam(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Dam/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang áo dài
	public static List<Sanpham> PhanTrangAoDai(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao-dai/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang Cả bộ
	public static List<Sanpham> PhanTrangCaBo(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ca-bo/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang quần
	public static List<Sanpham> PhanTrangQuan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Quan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng count sản phẩm
	public static long count() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của áo
	public static long countAo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-ao";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của quần
	public static long countQuan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-quan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của cả bộ
	public static long countCaBo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-ca-bo";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm áo dài
	public static long countAoDai() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-ao-dai";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm đầm
	public static long countDam() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-dam";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy sản phẩm tăng giần
	public static List<Sanpham> SanPhamTangDan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham-tang-dan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy sản phẩm giảm giần
	public static List<Sanpham> SanPhamGiamDan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham-giam-dan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang áo tăng dần
	// Lấy ra số lượng phân trang quần
	public static List<Sanpham> PhanTrangAoTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang áo giảm dần
	public static List<Sanpham> PhanTrangAoGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang đầm giảm dần
	public static List<Sanpham> PhanTrangDamGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Dam-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang đầm tăng dần
	public static List<Sanpham> PhanTrangDamTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Dam-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang quần tăng dần
	public static List<Sanpham> PhanTrangQuanTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Quan-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang quần giảm dần
	public static List<Sanpham> PhanTrangQuanGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Quan-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang ÁO dài tăng dần
	public static List<Sanpham> PhanTrangAoDaiTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao-Dai-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang ÁO dài giảm dần
	public static List<Sanpham> PhanTrangAoDaiGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ao-Dai-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang cả bộ giảm dần
	public static List<Sanpham> PhanTrangCaBoGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ca-Bo-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang cả bộ tăng dần
	public static List<Sanpham> PhanTrangCaBoTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/Ca-Bo-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo
	public static List<Sanpham> sanPhamAoMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat-ao";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của quần
	public static List<Sanpham> sanPhamQuanMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat-quan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<Sanpham> sanPhamAoDaiMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat-ao-dai";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<Sanpham> sanPhamCaBoMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat-ca-bo";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<Sanpham> sanPhamDamMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-moi-nhat-dam";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang sản phẩm giảm dần
	public static List<Sanpham> phanTrangSanPhamGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/San-Pham-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang sản phẩm tăng dần
	public static List<Sanpham> phanTrangSanPhamTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/Phan-Trang/San-Pham-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// thể loại sản phẩm
	public static List<LoaiSanPham> ListLoaiSanPham() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<LoaiSanPham>>() {
		}.getType();
		List<LoaiSanPham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list màu sắc
	public static List<Mausac> ListMauSac() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Mau-sac";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Mausac>>() {
		}.getType();
		List<Mausac> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list kích cỡ
	public static List<Kichco> ListKichCo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/kich-thuoc";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Kichco>>() {
		}.getType();
		List<Kichco> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list nhãn hiệu
	public static List<NhanHieu> ListNhanHieu() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Nhan-hieu/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<NhanHieu>>() {
		}.getType();
		List<NhanHieu> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 100 - 200
	public static List<Sanpham> sanPham100den200() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-100-200";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 200 - 300
	public static List<Sanpham> sanPham200den300() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-200-300";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 300 - 500
	public static List<Sanpham> sanPham300den500() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-300-500";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Gía trên 500
	public static List<Sanpham> sanPhamTren500() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/san-pham-gia-tren-500";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Tìm loại sản phẩm
	public static List<Sanpham> timNhanHieu(int idla, int idphan) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/tim-nhan-hieu/" + idla + "/phan-trang/"
				+ idphan;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// tìm số lượng Nhãn hiệu
	public static Long countNhanHieu(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/count-nhan-hieu/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		long sl = Long.parseLong(data);
		return sl;
	}

	// tìm kiếm sản phẩm
	public static List<Sanpham> selectByNameProduct(String tenla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/search-name/" + tenla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang khách hàng
	public static List<KhachHang> phanTrangKhachHang(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/KhachHang/phan-trang-khach-hang/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<KhachHang>>() {
		}.getType();
		List<KhachHang> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang hóa đơn
	public static List<HoaDon> phanTrangHoaDon(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/HoaDon/phanTrangHoaDon/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<HoaDon>>() {
		}.getType();
		List<HoaDon> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Thêm tintuc
	public static String themTinTuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		TinTuc themtt = gs.fromJson(data, TinTuc.class);
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb.getText();
	}

	// Sửa tin tức
	public static String suaTinTuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		TinTuc themtt = gs.fromJson(data, TinTuc.class);
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb.getText();
	}

	// XOá tin tức
	public static ThongBao xoaTinTuc(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/delete/" + idxoa;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		TinTuc themtt = new TinTuc();
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb;
	}

	// Tìm tin tức
	// XOá tin tức
	public static TinTuc TimTinTuc(int idtim) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/search-id/" + idtim;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		TinTuc tintuc = gs.fromJson(data, TinTuc.class);
		return tintuc;
	}

	// Lấy list tin tức
	// Sửa tin tức
	public static List<TinTuc> listTinTuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<TinTuc>>() {
		}.getType();
		List<TinTuc> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}
	// Đếm số lươngj

	public static int countTinTuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Tintuc/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int soluong = Integer.parseInt(dulieu);
		return soluong;
	}

	// List Role
	public static List<Roles> selectAllRole() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/role/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Type typeOfT = new TypeToken<List<Roles>>() {
		}.getType();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		List<Roles> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang danh mục
	public static List<LoaiSanPham> phanTrangDanhMuc(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/phan-trang/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<LoaiSanPham>>() {
		}.getType();
		List<LoaiSanPham> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Đếm số lượng danh mục
	public static Long countDanhMuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long soluong = Long.parseLong(dulieu);
		return soluong;
	}

	// thêm danh mục
	public static ThongBao themDanhMuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb;
	}

	// Sửa danh mục
	public static ThongBao suaDanhMuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb;
	}

	// xóa danh mục
	public static ThongBao xoaDanhMuc(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/delete/" + idxoa;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		LoaiSanPham lsp = new LoaiSanPham();
		Gson gs = new Gson();
		String dulieu = gs.toJson(lsp);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb;
	}

	// Tìm danh mục
	public static LoaiSanPham timDanhMuc(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		LoaiSanPham lsp = gs.fromJson(data, LoaiSanPham.class);
		return lsp;
	}

	// Lấy user Role
	public static List<UserRole> listUserRole() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/user-role/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<UserRole>>() {
		}.getType();
		List<UserRole> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Tìm UserRole
	public static UserRole timUserRole(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/user-role/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserRole lsp = gs.fromJson(data, UserRole.class);
		return lsp;
	}

	// Tìm UserRole
	public static UserRole timIdNguoiDung(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/user-role/search-user/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserRole lsp = gs.fromJson(data, UserRole.class);
		return lsp;
	}

	public static ThongBao InsertUserRole(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/user-role/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		return tb;
	}

	// Tìm role
	public static Roles timRole(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/role/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Roles lsp = gs.fromJson(data, Roles.class);
		return lsp;
	}

	// Tìm user
	public static User timUser(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/User/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		User lsp = gs.fromJson(data, User.class);
		return lsp;
	}

	// Lấy list hình ảnh
	public static List<Hinhanh> selectAllHinhAnh() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Hinhanh/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Hinhanh>>() {
		}.getType();
		List<Hinhanh> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Tìm Hình ảnh theo id sản phẩm
	public static List<Hinhanh> selectByIdSpHinhAnh(int idha) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Hinhanh/list-tim-idsp/" + idha;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Hinhanh>>() {
		}.getType();
		List<Hinhanh> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

}
