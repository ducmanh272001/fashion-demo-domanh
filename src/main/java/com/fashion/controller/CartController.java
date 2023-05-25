package com.fashion.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fashion.base.BaseService;
import com.fashion.entity.CartEntity;
import com.fashion.entity.CartDetailEntity;
import com.fashion.entity.ImagerEntity;
import com.fashion.entity.BillEntity;
import com.fashion.entity.BranchEntity;
import com.fashion.entity.CalculateEntity;
import com.fashion.entity.BillDetailEntity;
import com.fashion.entity.CustomerEntity;
import com.fashion.entity.HotProductEntity;
import com.fashion.entity.SizeEntity;
import com.fashion.entity.TypeProductEntity;
import com.fashion.entity.ColorEntity;
import com.fashion.entity.ProductDetailEntity;
import com.fashion.entity.ProductEntity;
import com.fashion.entity.UserEntity;
import com.fashion.notify.Notifies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class CartController {

	@PostMapping(value = "/cart")
	public String CartSanPham(@RequestParam(value = "idsanpham") int idsp, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		// Kiểm tra cart neus chưa có thì add vào
		List<CartEntity> lokk = (List<CartEntity>) session.getAttribute("list");
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		CartEntity cart = new CartEntity();
		int amount = 0;
		// Dữ liệu
		String URL = "https://fashion-shop-api.herokuapp.com/api/v1/product/search-id/" + idsp;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String layve = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ProductEntity sp = gs.fromJson(layve, ProductEntity.class);
		if (lokk == null) {
			cart.setSanpham(sp);
			cart.getSanpham().setSp_view(1);
			amount = cart.getSanpham().getSp_view();
			List<CartEntity> listCart = new ArrayList<CartEntity>();
			listCart.add(cart);
			session.setAttribute("list", listCart);
			listSanPham(model);
			// Đã lưu
			int slok = soLuong(request);
			model.addAttribute("sl", slok);
			return "home";
		} else {
			for (int i = 0; i < lokk.size(); i++) {
				if (lokk.get(i).getSanpham().getId() == sp.getId()) {
					int soluong = lokk.get(i).getSanpham().getSp_view();
					amount = soluong + 1;
					lokk.get(i).getSanpham().setSp_view(amount);
					listSanPham(model);
					// Tăng số lượng lên thôi
					int slok = soLuong(request);
					model.addAttribute("sl", slok);
					return "home";
				}
			}
		}
		cart.setSanpham(sp);
		cart.getSanpham().setSp_view(1);
		lokk.add(cart);
		listSanPham(model);
		// THỬ NHẢ Sâu cái số lượng ra đây
		int slok = soLuong(request);
		model.addAttribute("sl", slok);
		return "home";
	}

	// Hàm số lượng xuống đây
	private static int soLuong(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		int amount = 0;
		List<CartEntity> lokk = (List<CartEntity>) session.getAttribute("list");
		for (CartEntity cart : lokk) {
			amount += cart.getSanpham().getSp_view();
		}
		return amount;
	}

	private static void listSanPham(Model model) {
		String URL = "https://fashion-shop-api.herokuapp.com/rest/San-pham/list-san-pham";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<ProductEntity>>() {
		}.getType();
		List<ProductEntity> listok = gs.fromJson(data, typeOfT);
		model.addAttribute("lst", listok);
	}

	// bắt lấy cái xác nhậ thanh toán
	@GetMapping(value = "/xac-nhan-thanh-toan")
	public String xacNhanThanhToan(HttpServletRequest request, Model m) {
		/// Kiểm tra trong sản phẩm còn bao nhiêu trong kho

		// Nếu mà chưa có tài khoản thì bắt đăng nhập mới được mua hàng
		HttpSession session = request.getSession();
		UserEntity dangNhap = (UserEntity) session.getAttribute("acc");
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		if (dangNhap == null) {
			m.addAttribute("lokk", lokk);
			m.addAttribute("tbl", "Xin mời đăng nhập");
			tinhTongTien(request, m);
			soluongdon(request, m);
			return "cart/cartthu";
		}
        for (CartDetailEntity cartDetailEntity : lokk) {
        	int productId = cartDetailEntity.getSanphamchitiet().getMact().getId();	
        	if(productId != 0) {
        		ProductEntity productEntity = BaseService.searchIdSanPham(productId);
        		if(cartDetailEntity.getSanphamchitiet().getAmount() > productEntity.getSp_view()) {
        			m.addAttribute("lokk", lokk);
        			tinhTongTien(request, m);
        			soluongdon(request, m);
        			String tonkhoOk = "Sản phẩm "+ productEntity.getName() + " còn " + productEntity.getSp_view() +" sản phẩm trong kho";
        			m.addAttribute("tonkhoOk", tonkhoOk);
        			return "cart/cartthu";
        		}
        	}
		}
		

		// List dơn hàng
		m.addAttribute("list", lokk);
		// Tổng tiền
		tinhTongTien(request, m);
		// Tên đăng nhập và full name
		m.addAttribute("nd", dangNhap);
		return "cart/confirm";
	}

	// Thanh toán thành công
	@GetMapping(value = "/thanh-toan-gio")
	public ModelAndView thanhToanThanhCong(Model model, HttpServletRequest request) {
		// Đầu tiên là phải lấy ra cái sản phẩm đó đã
		int idsp = Integer.parseInt(request.getParameter("idsp"));
		String color = request.getParameter("gender");
		String size = request.getParameter("product");

		int quantity = Integer.parseInt(request.getParameter("quantity"));

		String URL = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product/search-id/" + idsp;
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		////////////// Dữ Liệu////////////////////////////////////
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String dulieu = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ProductEntity sanpham = gs.fromJson(dulieu, ProductEntity.class);

		if (sanpham.getSp_view() == 0) {
			model.addAttribute("tt", 0);
			return new ModelAndView("redirect:" + "/product/ao-nu/" + sanpham.getId());
		}

		List<ImagerEntity> listha = BaseService.selectByIdSpHinhAnh(sanpham.getId());
		sanpham.setListHinhAnh(listha);
		// Xong sau phải kiểm tra xem giỏ hàng có chưa
		HttpSession session = request.getSession(true);
		// Kiểm tra cart neus chưa có thì add vào
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		CartDetailEntity cart = new CartDetailEntity();
		//// Sản phẩm chi tiêt//////
		SizeEntity kcla = new SizeEntity();
		ColorEntity ms = new ColorEntity();
		ProductDetailEntity spct = new ProductDetailEntity();
		kcla.setName(size);
		ms.setName(color);
		spct.setAmount(quantity);
		spct.setIdkc(kcla);
		spct.setIdms(ms);
		spct.setMact(sanpham);
		cart.setSanphamchitiet(spct);
		if (lokk == null) {
			List<CartDetailEntity> listCart = new ArrayList<CartDetailEntity>();
			listCart.add(cart);

			session.setMaxInactiveInterval(1800);

			session.setAttribute("listct", listCart);
			return new ModelAndView("redirect:" + "/thanh-toan-tc");
		} else {
			// Nếu mà khác null
			for (int i = 0; i < lokk.size(); i++) {
				if (lokk.get(i).getSanphamchitiet().getMact().getId() == sanpham.getId()
						&& lokk.get(i).getSanphamchitiet().getIdms().getName()
								.equals(cart.getSanphamchitiet().getIdms().getName())
						&& lokk.get(i).getSanphamchitiet().getIdkc().getName()
								.equals(cart.getSanphamchitiet().getIdkc().getName())) {
					// Thỏa mãn thì tăng số lượng ko thì add vào
					int tang = lokk.get(i).getSanphamchitiet().getAmount() + quantity;
					lokk.get(i).getSanphamchitiet().setAmount(tang);
					return new ModelAndView("redirect:" + "/thanh-toan-tc");
				}
			}
		}
		lokk.add(cart);
		return new ModelAndView("redirect:" + "/thanh-toan-tc");
	}

	// Tính tổng
	private static void tinhTongTien(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		float tongtien = 0;
		float pvc = 0;
		for (CartDetailEntity cct : lokk) {
			tongtien += cct.getSanphamchitiet().getMact().getPrice_new() * cct.getSanphamchitiet().getAmount();
		}
		model.addAttribute("tt", tongtien);
		model.addAttribute("pvc", pvc);
	}

	// giỏ hàng
	@GetMapping(value = "/thanh-toan-tc")
	public String thanhToan(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");

		if (lokk == null) {
			return "cart/cartthu";
		}
		try {
			// Lấy tên sản phẩm rồi lấy số lượng được thay đổi
			String quantity[] = request.getParameterValues("quantity");
			int[] ints = new int[quantity.length];
			for (int i = 0; i < quantity.length; i++) {
				try {
					ints[i] = Integer.parseInt(quantity[i]);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			String tensp[] = request.getParameterValues("tensp");
			String tenms[] = request.getParameterValues("tenms");
			String tenkc[] = request.getParameterValues("tenkc");

			for (int i = 0; i < tenkc.length; i++) {
				for (int j = 0; j < tenms.length; j++) {
					for (int j2 = 0; j2 < tensp.length; j2++) {
						for (int k = 0; k < lokk.size(); k++) {
							if (lokk.get(k).getSanphamchitiet().getMact().getName().equals(tensp[j2])
									&& lokk.get(k).getSanphamchitiet().getIdms().getName().equals(tenms[j])
									&& lokk.get(k).getSanphamchitiet().getIdkc().getName().equals(tenkc[i])) {
								lokk.get(k).getSanphamchitiet().setAmount(ints[k]);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			model.addAttribute("lokk", lokk);
			// Mang tổng tiền đi nữa
			tinhTongTien(request, model);
			// Lấy số lượng đơn
			soluongdon(request, model);
		}
		// Mang lại list sản phẩm ở đây
		model.addAttribute("lokk", lokk);
		// Mang tổng tiền đi nữa
		tinhTongTien(request, model);
		// Lấy số lượng đơn
		soluongdon(request, model);
		return "cart/cartthu";
	}

	// Tính số lượng đơn hàng trong giỏ hàng
	private static void soluongdon(HttpServletRequest request, Model model) {
		// Đưa cái số lượng
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		int dem = 0;
		for (CartDetailEntity cct : lokk) {
			dem += cct.getSanphamchitiet().getAmount();
		}
		// Lưu vào biến session
		session.setAttribute("dem", dem);
	}

	// Bắt biến thanh toán giỏ hàng
	@RequestMapping(value = ("/thanh-toan-gh-tc"), method = RequestMethod.POST)
	public ModelAndView thanhToanTcGh(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		String fname = request.getParameter("tenkh");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String diachi = request.getParameter("address");
		String call = request.getParameter("call");
		Boolean gioitinh = Boolean.parseBoolean(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngay = null;
		try {
			ngay = sdf.parse(request.getParameter("ngaysinh"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Client client = ClientBuilder.newClient();
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		// Kiểm tra xem có khách hàng này chưa
		String ListKh = "https://fashion-shop-api.herokuapp.com/rest/api/v1/customer/";
		WebTarget lkh = client.target(ListKh);
		String dlkh = lkh.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<CustomerEntity>>() {
		}.getType();
		List<CustomerEntity> listkh = gs.fromJson(dlkh, typeOfT);
		for (int i = 0; i < listkh.size(); i++) {
			if (listkh.get(i).getName().equals(fname) && listkh.get(i).getEmail().equals(email)
					&& listkh.get(i).getPasswword().equals(pass)) {
				BillEntity hd = new BillEntity();
				hd.setAddress(diachi);
				hd.setNameKH(listkh.get(i).getName());
				hd.setMakh(listkh.get(i));
				Date date = java.util.Calendar.getInstance().getTime();
				hd.setNgayban(date);
				hd.setSdt(call);
				hd.setStatus(true);
				String dlhoadon = gs.toJson(hd);
				int idhoadon = BaseService.InsertHoaDon(dlhoadon);
				for (CartDetailEntity cart : lokk) {
					String themok = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product-detail/insert";
					String mausac = "https://fashion-shop-api.herokuapp.com/rest/api/v1/color/"
							+ cart.getSanphamchitiet().getIdms().getName();
					String kichco = "https://fashion-shop-api.herokuapp.com/rest/api/v1/size/"
							+ cart.getSanphamchitiet().getIdkc().getName();
					WebTarget tams = client.target(mausac);
					WebTarget takc = client.target(kichco);
					String datams = tams.request(MediaType.APPLICATION_JSON).get(String.class);
					String datakc = takc.request(MediaType.APPLICATION_JSON).get(String.class);
					ColorEntity ms = gs.fromJson(datams, ColorEntity.class);
					SizeEntity kc = gs.fromJson(datakc, SizeEntity.class);
					ProductEntity spok = cart.getSanphamchitiet().getMact();
					ProductDetailEntity spct = new ProductDetailEntity(cart.getSanphamchitiet().getAmount(), ms, kc,
							spok);
					String data = gs.toJson(spct);
					WebTarget tarlol = client.target(themok);
					Response response = tarlol.request(MediaType.APPLICATION_JSON_TYPE)
							.post(Entity.entity(data, MediaType.APPLICATION_JSON));
					String trave = response.readEntity(String.class);
					Notifies tb = gs.fromJson(trave, Notifies.class);
					// Sản phẩm chi tiết sẽ thuộc về 1 cái hóa đơn chi tiết
					String HDCT = "https://fashion-shop-api.herokuapp.com/rest/api/v1/bill-detail/";
					// Số lượng đơn
					int sldon = cart.getSanphamchitiet().getAmount();

					// up date lại sản phẩm trừ đi số lượng
					ProductEntity productEntity = BaseService.searchIdSanPham(spok.getId());
					int sodonHientai = productEntity.getSp_view() - sldon;

					productEntity.setSp_view(sodonHientai);
					BranchEntity branchEntity = new BranchEntity();
					branchEntity.setId(productEntity.getIdnhanhieu());
					TypeProductEntity typeProductEntity = new TypeProductEntity();
					typeProductEntity.setId(productEntity.getIdtheloai());

					productEntity.setIdnh(branchEntity);
					productEntity.setIdlsp(typeProductEntity);
					String dataProduct = gs.toJson(productEntity);
					Notifies traveProduct = BaseService.updateProduct(dataProduct);
					System.out.println(traveProduct.getText());

					// save

					long idSpInsertHotProduct = (long) cart.getSanphamchitiet().getMact().getId();//////////////
					long sldonInsertHotProduct = (long) sldon;
					if (BaseService.findAllHotProductByIdsp(idSpInsertHotProduct) != null) {
						HotProductEntity hotProductEntity = BaseService.findAllHotProductByIdsp(idSpInsertHotProduct);
						long increaseQuantity = hotProductEntity.getSellNumber() + sldonInsertHotProduct;
						hotProductEntity.setSellNumber(increaseQuantity);
						String updateHotProduct = gs.toJson(hotProductEntity);
						String updateSuccess = BaseService.updateHotProduct(updateHotProduct);
						System.out.print(updateSuccess);
					} else {
						/// Import sản phẩm hot
						HotProductEntity hotProductEntity = new HotProductEntity();
						hotProductEntity.setIdsp(idSpInsertHotProduct);
						hotProductEntity.setSellNumber(sldonInsertHotProduct);
						String dataHotProduct = gs.toJson(hotProductEntity);
						String insertSuccess = BaseService.saveHotProduct(dataHotProduct);
						System.out.print(insertSuccess);
					}

					// Tổng tiền
					float tongtien = cart.getSanphamchitiet().getMact().getPrice_new();
					// Lấy lại cái Hóa đơn lấy id ra
					String TIMHOADON = "https://fashion-shop-api.herokuapp.com/rest/api/v1/bill/" + idhoadon;
					WebTarget thoadon = client.target(TIMHOADON);
					String timhoadon = thoadon.request(MediaType.APPLICATION_JSON).get(String.class);
					BillEntity hok = gs.fromJson(timhoadon, BillEntity.class);
					/// Lấy cái id của hóa đơn chi tiết
					String SPCT = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product-detail/" + tb.getMacode();
					WebTarget taspct = client.target(SPCT);
					String dulieuspct = taspct.request(MediaType.APPLICATION_JSON).get(String.class);
					ProductDetailEntity spctthem = gs.fromJson(dulieuspct, ProductDetailEntity.class);

					// sldon

					BillDetailEntity hdct = new BillDetailEntity(hok, spctthem, sldon, tongtien);
					String dulieuhd = gs.toJson(hdct);
					WebTarget tahdct = client.target(HDCT);
					tahdct.request().post(Entity.entity(dulieuhd, MediaType.APPLICATION_JSON));
				}
				// lƯU vào bảng hot product
				session.setAttribute("idkh", listkh.get(i).getId());
				/// remove các list đã mua
				session.removeAttribute("listct");
				session.removeAttribute("dem");
				return new ModelAndView("redirect:" + "/chi-tiet-don-hang");
			}
		}
		// Trường hợp nếu mà không có khách hàng thfi thêm khách hàng
		CustomerEntity khachhang = new CustomerEntity(fname, email, pass, diachi, call, ngay, gioitinh, true);

		String datakh = gs.toJson(khachhang);
		int MAKH = BaseService.InsertKhachHang(datakh);
		// lấy khách hàng
		CustomerEntity KH = BaseService.selectByKhachHang(MAKH);
		// Sau khi thêm khách hàng xong thêm hóa đơn mà khách hàng đã mua
		BillEntity hd = new BillEntity();
		hd.setAddress(diachi);
		hd.setNameKH(fname);
		hd.setMakh(KH);
		Date date = java.util.Calendar.getInstance().getTime();
		hd.setNgayban(date);
		hd.setSdt(call);
		hd.setStatus(true);
		String dlhoadon = gs.toJson(hd);
		int idhoadon = BaseService.InsertHoaDon(dlhoadon);
		// Thêm Hóa đơn chi Tiết
		for (CartDetailEntity cart : lokk) {
			String themok = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product-detail/insert";
			String mausac = "https://fashion-shop-api.herokuapp.com/rest/api/v1/color/"
					+ cart.getSanphamchitiet().getIdms().getName();
			String kichco = "https://fashion-shop-api.herokuapp.com/rest/api/v1/size/"
					+ cart.getSanphamchitiet().getIdkc().getName();
			WebTarget tams = client.target(mausac);
			WebTarget takc = client.target(kichco);
			String datams = tams.request(MediaType.APPLICATION_JSON).get(String.class);
			String datakc = takc.request(MediaType.APPLICATION_JSON).get(String.class);
			ColorEntity ms = gs.fromJson(datams, ColorEntity.class);
			SizeEntity kc = gs.fromJson(datakc, SizeEntity.class);
			ProductEntity spok = cart.getSanphamchitiet().getMact();
			ProductDetailEntity spct = new ProductDetailEntity(cart.getSanphamchitiet().getAmount(), ms, kc, spok);
			String data = gs.toJson(spct);
			WebTarget tarlol = client.target(themok);
			Response response = tarlol.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(data, MediaType.APPLICATION_JSON));
			String trave = response.readEntity(String.class);
			Notifies tb = gs.fromJson(trave, Notifies.class);
			// Sản phẩm chi tiết sẽ thuộc về 1 cái hóa đơn chi tiết
			String HDCT = "https://fashion-shop-api.herokuapp.com/rest/api/v1/bill-detail/";
			// Số lượng đơn
			int sldon = cart.getSanphamchitiet().getAmount();
			// Tổng tiền
			float tongtien = cart.getSanphamchitiet().getMact().getPrice_new();
			// Lấy lại cái Hóa đơn lấy id ra
			String TIMHOADON = "https://fashion-shop-api.herokuapp.com/rest/api/v1/bill/" + idhoadon;
			WebTarget thoadon = client.target(TIMHOADON);
			String timhoadon = thoadon.request(MediaType.APPLICATION_JSON).get(String.class);
			BillEntity hok = gs.fromJson(timhoadon, BillEntity.class);
			/// Lấy cái id của hóa đơn chi tiết
			String SPCT = "https://fashion-shop-api.herokuapp.com/rest/api/v1/product-detail/" + tb.getMacode();
			WebTarget taspct = client.target(SPCT);
			String dulieuspct = taspct.request(MediaType.APPLICATION_JSON).get(String.class);
			ProductDetailEntity spctthem = gs.fromJson(dulieuspct, ProductDetailEntity.class);
			BillDetailEntity hdct = new BillDetailEntity(hok, spctthem, sldon, tongtien);
			String dulieuhd = gs.toJson(hdct);
			WebTarget tahdct = client.target(HDCT);
			tahdct.request().post(Entity.entity(dulieuhd, MediaType.APPLICATION_JSON));
		}
		session.setAttribute("idkh", MAKH);
		session.removeAttribute("listct");
		session.removeAttribute("dem");
		return new ModelAndView("redirect:" + "/chi-tiet-don-hang");
	}

	/// Trang oder
	@GetMapping(value = "/chi-tiet-don-hang")
	public String chiTietDonHang(Model model, HttpServletRequest request) {

		// kHi mà mua sản phẩm xong phải trừ số lượng xủa sản phẩm

		Client client = ClientBuilder.newClient();
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		HttpSession session = request.getSession();
		try {
			int idkh = (int) session.getAttribute("idkh");
			String hoadonl = "https://fashion-shop-api.herokuapp.com/rest/api/v1/bill/search-makh/" + idkh;
			WebTarget thoadon = client.target(hoadonl);
			String sHoaDon = thoadon.request(MediaType.APPLICATION_JSON).get(String.class);
			Type tHoaDon = new TypeToken<List<BillEntity>>() {
			}.getType();
			List<BillEntity> Lhoadon = gs.fromJson(sHoaDon, tHoaDon);
			model.addAttribute("hok", Lhoadon);
			return "cart/oder";
		} catch (Exception e) {
			return "cart/oder";
		}

	}

	@GetMapping(value = "/xoa-session/{sola}")
	public String xoaIndexSession(@PathVariable(value = "sola") int soxoa,
			@RequestParam(value = "id", required = false) int idOk, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
		lokk.remove(soxoa);
		BaseService.deleteCalculateFromProductId(idOk);
		// xoa lun trong bang caculate

		model.addAttribute("lokk", lokk);
		// Mang tổng tiền đi nữa
		tinhTongTien(request, model);
		// Lấy số lượng đơn
		soluongdon(request, model);
		return "cart/cartthu";
	}
}
