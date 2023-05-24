package com.fashion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashion.base.BaseService;
import com.fashion.entity.CartEntity;
import com.fashion.entity.CustomerEntity;
import com.fashion.entity.ProductEntity;
import com.fashion.entity.UserEntity;
import com.fashion.entity.UserRoleEntity;

@Controller
public class SignInController {

	@RequestMapping(value = "/dang-nhap")
	public String dangNhap(Model model) {
		UserEntity user = new UserEntity();
		model.addAttribute("uok", user);
		return "login/login";
	}

	@RequestMapping(value = "/dang-nhap/success", method = RequestMethod.POST)
	public String loginSucces(@Valid @ModelAttribute(value = "uok") UserEntity user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "login/login";
		}
		String username = user.getName();
		String password = user.getPassword();
		// Kiểm tra ở đây
		// Lấy cái pass ra so sánh với lại tên đăng nhập và mật khẩu
		//
		// Phải đem so sánh mật khẩu
		List<UserEntity> lUser = BaseService.listUser();
		for (int i = 0; i < lUser.size(); i++) {
			if (lUser.get(i).getName().equals(username) && lUser.get(i).getPassword().equals(password)) {
				UserEntity dangNhap = BaseService.kiemTraDangNhap(username, password);
				HttpSession session = request.getSession();
				session.setAttribute("acc", dangNhap);
				System.out.println(dangNhap.getId());
				int idla = dangNhap.getId();
				///////////////////////// Tìm id người dùng
				UserRoleEntity ur = BaseService.timIdNguoiDung(idla);
				if (ur.getName_Role_ID().equals("EDITOR")) {
					session.setAttribute("role", "EDITOR");
					return "admin/editor";
				} else if (ur.getName_Role_ID().equals("ADMIN")) {
					session.setAttribute("role", "ADMIN");
					return "redirect:/Admin";
				} else if (ur.getName_Role_ID().equals("USER")) {
					// Nạp lại cái dữ liệu của list vào đây
					session.setAttribute("role", "USER");
					///////////////
					BaseService.ListSanPham(model);
					BaseService.ListDamSanPham(model);
					// Lấy ra tên
					String namedn = dangNhap.getFullName();
					String accountdn = dangNhap.getName();
					String passdn = dangNhap.getPassword();
					List<CustomerEntity> listkh = BaseService.listKhachHang();
					
					for (int j = 0; j < listkh.size(); j++) {
						if (listkh.get(j).getName().equals(namedn) && listkh.get(j).getEmail().equals(accountdn)
								&& listkh.get(j).getPasswword().equals(passdn)) {
							session.setAttribute("idkh", listkh.get(j).getId());
						}
					}
					return "redirect:/";
				}
			}
		}
		model.addAttribute("warning", "Tên người dùng hoặc mật khẩu không chính xác");
		return "login/login";
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

	// Trang admin
	@GetMapping(value = "/Admin")
	public String Admin(HttpServletRequest request, Model model) {

		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute("acc");
			int idla = user.getId();
			UserRoleEntity ur = BaseService.timUserRole(idla);
			if (ur.getName_Role_ID().equals("ADMIN")) {
				List<ProductEntity> listok = BaseService.ListSanPham(model);
				float tongtien = 0;
				float tongtienno = 0;
				for (int i = 0; i < listok.size(); i++) {
					tongtien += listok.get(i).getPrice_import();
					tongtienno += listok.get(i).getPrice_new();
				}
				// Lấy dữ liệu về
				model.addAttribute("ttn", tongtienno);
				model.addAttribute("tt", tongtien);
				long SLKH = BaseService.CountKhachHang();
				model.addAttribute("sl", SLKH);
				// Lấy số lượng hóa đơn
				int sohd = BaseService.CountHoaDon();
				model.addAttribute("shd", sohd);
				// Để giá trị
				String lag = request.getParameter("lag");
				if (lag == null) {
					return "admin/admin";
				}
				// Nếu có thì duyệt cây
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
					break;
				}
				return "admin/admin";
			}
		} catch (Exception e) {
			UserEntity user = new UserEntity();
			model.addAttribute("uok", user);
			model.addAttribute("warning", "Xin vui lòng đăng nhập");
			return "login/login";
		}
		return "login/login";
	}

}
