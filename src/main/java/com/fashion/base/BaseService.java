package com.fashion.base;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.ui.Model;

import com.fashion.entity.CartDetailEntity;
import com.fashion.entity.ImagerEntity;
import com.fashion.entity.BillEntity;
import com.fashion.entity.BillDetailEntity;
import com.fashion.entity.CustomerEntity;
import com.fashion.entity.HotProductEntity;
import com.fashion.entity.SizeEntity;
import com.fashion.entity.TypeProductEntity;
import com.fashion.entity.ColorEntity;
import com.fashion.entity.BranchEntity;
import com.fashion.entity.CalculateEntity;
import com.fashion.entity.RoleEntity;
import com.fashion.entity.ProductDetailEntity;
import com.fashion.entity.ProductEntity;
import com.fashion.entity.NewsEntity;
import com.fashion.entity.UserEntity;
import com.fashion.entity.UserRoleEntity;
import com.fashion.notify.Notifies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BaseService {

	public static int getsoluong(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		int dem = 0;
		for (CartDetailEntity cct : lokk) {
			dem += cct.getSanphamchitiet().getAmount();
		}
		return dem;
	}

///Tính tổng tiền
	public static float gettongtien(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		float tongtien = 0;
		for (CartDetailEntity cct : lokk) {
			tongtien += cct.getSanphamchitiet().getMact().getPrice_new() * cct.getSanphamchitiet().getAmount();
		}
		return tongtien;
	}

	// Thêm list Khách Hàng
	public static List<CustomerEntity> listKhachHang() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<CustomerEntity>>() {
		}.getType();
		List<CustomerEntity> lstkh = gs.fromJson(data, typeOfT);
		return lstkh;
	}

	public static List<Long> listLongIdSpFromHotProduct() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/listLongIdSP";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Long>>() {
		}.getType();
		List<Long> lstkh = gs.fromJson(data, typeOfT);
		return lstkh;
	}

	// List SanPhamCHi tiết search id hoadon
	public static List<BillDetailEntity> listHoaDonChiTiet(int id) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill-detail/search-id-hoadon/" + id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<BillDetailEntity>>() {
		}.getType();
		List<BillDetailEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Thêm list Khách Hàng
	public static int InsertKhachHang(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getMacode();
	}
	
	public static int insertCalcuate(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getMacode();
	}
	
	
	
	
	
	public static long quantityCalcualate(Integer productId) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/search-quantity/" + productId;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new Gson();
		Long kh = gs.fromJson(data, Long.class);
		return kh;
	}

	
	
	
	
	
	

	
	public static String deleteCalculate(Integer calculidateId) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/delete/" + calculidateId;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		CalculateEntity calculateEntity = new CalculateEntity();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(calculateEntity);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		String xoatc = tb.getText();
		return xoatc;
	}
	
	public static String deleteAllCalculate() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/delete-all";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		CalculateEntity calculateEntity = new CalculateEntity();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(calculateEntity);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		String xoatc = tb.getText();
		return xoatc;
	}
	
	
	public static String deleteCalculateFromProductId(Integer productId) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/delete-productId/" + productId;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		CalculateEntity calculateEntity = new CalculateEntity();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(calculateEntity);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		String xoatc = tb.getText();
		return xoatc;
	}
	
	// Insert Hóa đơn
	public static int InsertHoaDon(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getMacode();
	}

	public static CustomerEntity selectByKhachHang(int id) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/search/" + id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		CustomerEntity kh = gs.fromJson(data, CustomerEntity.class);
		return kh;
	}
	
	
	public static UserEntity selectUserFromEmail(String email) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user/search-email/" + email;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		UserEntity kh = gs.fromJson(data, UserEntity.class);
		return kh;
	}

	// Them product
	public static String saveHotProduct(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getText();
	}

	public static HotProductEntity findAllHotProductByIdsp(long idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/find-idsp/" + idla;
		Gson gs = new Gson();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String trave = target.request(MediaType.APPLICATION_JSON).get(String.class);
		HotProductEntity sp = gs.fromJson(trave, HotProductEntity.class);
		return sp;
	}
	
	
	
	public static List<CalculateEntity>  listCanculate(Integer productId) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/calculate/" + productId;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<CalculateEntity>>() {
		}.getType();
		List<CalculateEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}
	

	public static List<ProductEntity> findAllProductsByIdList() {

		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/listIdSp";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;

	}

	public static String updateHotProduct(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String suatc = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(suatc, Notifies.class);
		String thongbao = tb.getText();
		return thongbao;
	}

	public static List<HotProductEntity> findAllHotProductEntity() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();

		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);

		Type typeOfT = new TypeToken<List<HotProductEntity>>() {
		}.getType();
		List<HotProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Thêm hot product

	// Về trang chủ
	public static List<ProductEntity> ListSanPham(Model model) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> lst = gs.fromJson(data, typeOfT);
		model.addAttribute("lst", lst);
		return lst;
	}

	// Tra ID
	public static ProductEntity searchIdSanPham(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/search-id/" + idla;
		Gson gs = new Gson();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String trave = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ProductEntity sp = gs.fromJson(trave, ProductEntity.class);
		return sp;
	}

	// Lọc theo đầm
	public static List<ProductEntity> ListDamSanPham(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham/dam";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> ldam = gs.fromJson(data, typeOfT);
		return ldam;
	}

	// Lọc theo đầm
	public static List<ProductEntity> ListShirt(Model model) {
		String URLAO = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham/ao";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLAO);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> lao = gs.fromJson(data, typeOfT);
		return lao;
	}

	// Lọc theo set cả bộ
	public static List<ProductEntity> ListSanPhamCaBo(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham/ca-bo";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> lcabo = gs.fromJson(data, typeOfT);
		return lcabo;
	}

	// Lọc theo set cả bộ
	public static List<ProductEntity> ListSanPhamAoDai(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham/ao-dai";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> laodai = gs.fromJson(data, typeOfT);
		return laodai;
	}

	// Lọc theo set cả bộ
	public static List<ProductEntity> ListSanPhamQuan(Model model) {
		String URLDAM = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham/quan";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URLDAM);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> laodai = gs.fromJson(data, typeOfT);
		return laodai;
	}

	// Lấy ra số lượng khách hàng
	public static long CountKhachHang() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/count-khach-hang";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int SLKH = Integer.parseInt(dulieu);
		return SLKH;
	}

	// Lấy ra số lượng Hóa Đơn
	public static int CountHoaDon() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/count-hoa-don";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int sohd = Integer.parseInt(dulieu);
		return sohd;
	}

	/// Sửa Khách Hàng
	public static void SuaKhachHang(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
	}
	
	/// Sửa Khách Hàng
		public static void updateUser(String data) {
			String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user/update";
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(URL);
			target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		}

	// Xóa khách hàng
	public static String deleteKhachHang(int xoaid) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/delete/" + xoaid;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		CustomerEntity kh = new CustomerEntity();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(kh);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		String xoatc = tb.getText();
		return xoatc;
	}

	// List hóa đơn
	public static List<BillEntity> ListHoaDon() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<BillEntity>>() {
		}.getType();
		List<BillEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Sửa hóa đơn
	public static String suaHoaDon(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String suatc = response.readEntity(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Notifies tb = gs.fromJson(suatc, Notifies.class);
		String thongbao = tb.getText();
		return thongbao;
	}

	// tìm hóa đơn
	public static BillEntity timHoaDon(int idtim) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/" + idtim;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		BillEntity hd = gs.fromJson(data, BillEntity.class);
		return hd;
	}

	// Xóa hóa đơn
	public static String xoaHoaDon(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/delete-hoa-don/" + idxoa;
		BillEntity hd = new BillEntity();
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(hd);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getText();
	}
	
	// Xóa hóa đơn chi t
		public static String deleteBillDetailFromBillId(int billId) {
			String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill-detail/delete-hoa-don-ct/" + billId;
			BillDetailEntity hd = new BillDetailEntity();
			Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String data = gs.toJson(hd);
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(URL);
			Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
			String trave = response.readEntity(String.class);
			Notifies tb = gs.fromJson(trave, Notifies.class);
			return tb.getText();
		}

	// Xem chi tiết hóa đơn
	public static ProductDetailEntity searchSanPhamCt(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product-detail/" + idla;
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget spdetail = client.target(URL);
		String detail = spdetail.request(MediaType.APPLICATION_JSON).get(String.class);
		ProductDetailEntity spctok = gs.fromJson(detail, ProductDetailEntity.class);
		return spctok;
	}


	// Lấy user
	public static UserEntity kiemTraDangNhap(String taikhoan, String matkhau) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user/kiemTraDangNhap/" + taikhoan + "/"
				+ matkhau;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserEntity user = gs.fromJson(data, UserEntity.class);
		return user;
	}

	// Lấy list User
	public static List<UserEntity> listUser() {
		// Lấy ra list user
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<UserEntity>>() {
		}.getType();
		List<UserEntity> user = gs.fromJson(data, typeOfT);
		return user;
	}

	// Lấy ra sản phẩm mới nhất
	public static List<String> sanPhamBanChay() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/hot-product/listLongIdSP";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new Gson();
		Type typeOfT = new TypeToken<List<String>>() {
		}.getType();
		List<String> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang
	public static List<ProductEntity> PhanTrang(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang
	public static List<ProductEntity> PhanTrangAo(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang Đầm
	public static List<ProductEntity> PhanTrangDam(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Dam/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang áo dài
	public static List<ProductEntity> PhanTrangAoDai(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao-dai/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang Cả bộ
	public static List<ProductEntity> PhanTrangCaBo(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ca-bo/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng phân trang quần
	public static List<ProductEntity> PhanTrangQuan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Quan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy ra số lượng count sản phẩm
	public static long count() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của áo
	public static long countAo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-ao";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của quần
	public static long countQuan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-quan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm của cả bộ
	public static long countCaBo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-ca-bo";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm áo dài
	public static long countAoDai() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-ao-dai";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy Số lượng Sản phẩm đầm
	public static long countDam() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-dam";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long slsp = Long.parseLong(data);
		return slsp;
	}

	// Lấy sản phẩm tăng giần
	public static List<ProductEntity> SanPhamTangDan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham-tang-dan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy sản phẩm giảm giần
	public static List<ProductEntity> SanPhamGiamDan() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/list-san-pham-giam-dan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang áo tăng dần
	// Lấy ra số lượng phân trang quần
	public static List<ProductEntity> PhanTrangAoTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang áo giảm dần
	public static List<ProductEntity> PhanTrangAoGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang đầm giảm dần
	public static List<ProductEntity> PhanTrangDamGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Dam-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang đầm tăng dần
	public static List<ProductEntity> PhanTrangDamTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Dam-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang quần tăng dần
	public static List<ProductEntity> PhanTrangQuanTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Quan-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang quần giảm dần
	public static List<ProductEntity> PhanTrangQuanGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Quan-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang ÁO dài tăng dần
	public static List<ProductEntity> PhanTrangAoDaiTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao-Dai-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang ÁO dài giảm dần
	public static List<ProductEntity> PhanTrangAoDaiGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ao-Dai-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang cả bộ giảm dần
	public static List<ProductEntity> PhanTrangCaBoGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ca-Bo-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang cả bộ tăng dần
	public static List<ProductEntity> PhanTrangCaBoTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/Ca-Bo-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo
	public static List<ProductEntity> sanPhamAoMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-moi-nhat-ao";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của quần
	public static List<ProductEntity> sanPhamQuanMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-moi-nhat-quan";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<ProductEntity> sanPhamAoDaiMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-moi-nhat-ao-dai";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<ProductEntity> sanPhamCaBoMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-moi-nhat-ca-bo";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	/// Lấy ra 4 sản phẩm mới nhất của áo dài
	public static List<ProductEntity> sanPhamDamMoiNhat() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-moi-nhat-dam";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang sản phẩm giảm dần
	public static List<ProductEntity> phanTrangSanPhamGiamDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/San-Pham-Giam-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang sản phẩm tăng dần
	public static List<ProductEntity> phanTrangSanPhamTangDan(int page) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/Phan-Trang/San-Pham-Tang-Dan/" + page;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// thể loại sản phẩm
	public static List<TypeProductEntity> ListLoaiSanPham() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<TypeProductEntity>>() {
		}.getType();
		List<TypeProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list màu sắc
	public static List<ColorEntity> ListMauSac() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/color";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ColorEntity>>() {
		}.getType();
		List<ColorEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list kích cỡ
	public static List<SizeEntity> ListKichCo() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/size";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<SizeEntity>>() {
		}.getType();
		List<SizeEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Lấy list nhãn hiệu
	public static List<BranchEntity> ListNhanHieu() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/branch/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<BranchEntity>>() {
		}.getType();
		List<BranchEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 100 - 200
	public static List<ProductEntity> sanPham100den200() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-100-200";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 200 - 300
	public static List<ProductEntity> sanPham200den300() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-200-300";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Sản phẩm giá 300 - 500
	public static List<ProductEntity> sanPham300den500() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-300-500";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Gía trên 500
	public static List<ProductEntity> sanPhamTren500() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/san-pham-gia-tren-500";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Tìm loại sản phẩm
	public static List<ProductEntity> timNhanHieu(int idla, int idphan) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/tim-nhan-hieu/" + idla + "/phan-trang/"
				+ idphan;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// tìm số lượng Nhãn hiệu
	public static Long countNhanHieu(int idla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/count-nhan-hieu/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		long sl = Long.parseLong(data);
		return sl;
	}

	// tìm kiếm sản phẩm
	public static List<ProductEntity> selectByNameProduct(String tenla) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/search-name/" + tenla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang khách hàng
	public static List<CustomerEntity> phanTrangKhachHang(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/customer/phan-trang-khach-hang/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<CustomerEntity>>() {
		}.getType();
		List<CustomerEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang hóa đơn
	public static List<BillEntity> phanTrangHoaDon(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/bill/phanTrangHoaDon/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<BillEntity>>() {
		}.getType();
		List<BillEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Thêm tintuc
	public static String themTinTuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		NewsEntity themtt = gs.fromJson(data, NewsEntity.class);
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getText();
	}

	// Sửa tin tức
	public static String suaTinTuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		NewsEntity themtt = gs.fromJson(data, NewsEntity.class);
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb.getText();
	}

	// XOá tin tức
	public static Notifies xoaTinTuc(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/delete/" + idxoa;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		NewsEntity themtt = new NewsEntity();
		String dulieu = gs.toJson(themtt);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}

	// Tìm tin tức
	// XOá tin tức
	public static NewsEntity TimTinTuc(int idtim) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/search-id/" + idtim;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		NewsEntity tintuc = gs.fromJson(data, NewsEntity.class);
		return tintuc;
	}

	// Lấy list tin tức
	// Sửa tin tức
	public static List<NewsEntity> listTinTuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<NewsEntity>>() {
		}.getType();
		List<NewsEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}
	// Đếm số lươngj

	public static int countTinTuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/news/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		int soluong = Integer.parseInt(dulieu);
		return soluong;
	}

	// List Role
	public static List<RoleEntity> selectAllRole() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/role/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Type typeOfT = new TypeToken<List<RoleEntity>>() {
		}.getType();
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		List<RoleEntity> list = gs.fromJson(data, typeOfT);
		return list;
	}

	// Phân trang danh mục
	public static List<TypeProductEntity> phanTrangDanhMuc(int sotrang) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/phan-trang/" + sotrang;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<TypeProductEntity>>() {
		}.getType();
		List<TypeProductEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Đếm số lượng danh mục
	public static Long countDanhMuc() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/count";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Long soluong = Long.parseLong(dulieu);
		return soluong;
	}

	// thêm danh mục
	public static Notifies themDanhMuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}
	
	
	public static Notifies updateProduct(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/product/update-san-pham";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}

	// Sửa danh mục
	public static Notifies suaDanhMuc(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/update";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}

	// xóa danh mục
	public static Notifies xoaDanhMuc(int idxoa) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/delete/" + idxoa;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		TypeProductEntity lsp = new TypeProductEntity();
		Gson gs = new Gson();
		String dulieu = gs.toJson(lsp);
		Response response = target.request().post(Entity.entity(dulieu, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}

	// Tìm danh mục
	public static TypeProductEntity timDanhMuc(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/type-product/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		TypeProductEntity lsp = gs.fromJson(data, TypeProductEntity.class);
		return lsp;
	}

	// Lấy user Role
	public static List<UserRoleEntity> listUserRole() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user-role/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<UserRoleEntity>>() {
		}.getType();
		List<UserRoleEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Tìm UserRole
	public static UserRoleEntity timUserRole(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user-role/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserRoleEntity lsp = gs.fromJson(data, UserRoleEntity.class);
		return lsp;
	}

	// Tìm UserRole
	public static UserRoleEntity timIdNguoiDung(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user-role/search-user/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserRoleEntity lsp = gs.fromJson(data, UserRoleEntity.class);
		return lsp;
	}

	public static Notifies InsertUserRole(String data) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user-role/insert";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		Notifies tb = gs.fromJson(trave, Notifies.class);
		return tb;
	}

	// Tìm role
	public static RoleEntity timRole(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/role/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		RoleEntity lsp = gs.fromJson(data, RoleEntity.class);
		return lsp;
	}

	// Tìm user
	public static UserEntity timUser(int idla) {
		Gson gs = new Gson();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user/search/" + idla;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		UserEntity lsp = gs.fromJson(data, UserEntity.class);
		return lsp;
	}

	// Lấy list hình ảnh
	public static List<ImagerEntity> selectAllHinhAnh() {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/imager/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ImagerEntity>>() {
		}.getType();
		List<ImagerEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}

	// Tìm Hình ảnh theo id sản phẩm
	public static List<ImagerEntity> selectByIdSpHinhAnh(int idha) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/imager/list-tim-idsp/" + idha;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Gson gs = new Gson();
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ImagerEntity>>() {
		}.getType();
		List<ImagerEntity> list = gs.fromJson(dulieu, typeOfT);
		return list;
	}
	
	
	///Save hot produtc
	
}
