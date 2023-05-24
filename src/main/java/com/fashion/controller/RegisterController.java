package com.fashion.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fashion.base.BaseService;
import com.fashion.entity.EmaiConfirm;
import com.fashion.entity.ProductEntity;
import com.fashion.entity.ReviewForgetPassword;
import com.fashion.entity.RoleEntity;
import com.fashion.entity.UserEntity;
import com.fashion.entity.UserRoleEntity;
import com.fashion.notify.Notifies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class RegisterController {

	@GetMapping(value = "/dang-ky")
	public String dangKy(Model model) {
		UserEntity user = new UserEntity();
		model.addAttribute("luser", user);
		return "login/sign-up";
	}

	@GetMapping(value = "/forget-passord")
	public String forgetPassword(Model model) {
		EmaiConfirm email = new EmaiConfirm();
		model.addAttribute("email", email);

		return "login/forget-password";
	}

	@PostMapping(value = "/forget/confirm/send/code")
	public String forgetConfirmSendCode(@ModelAttribute(value = "entity") @Valid ReviewForgetPassword forgetPass,
			BindingResult result, Model model, HttpServletRequest request) {

		HttpSession sessionId = request.getSession();
		// Nếu mà người dung mà khác null thì sẽ gửi mật khẩu email lại cho người dùng
		String passGenerated = RandomStringUtils.randomAlphanumeric(10);
		ReviewForgetPassword reviewForgetPassword = new ReviewForgetPassword();
		reviewForgetPassword.setId(forgetPass.getId());
		reviewForgetPassword.setPasswordGenerated(passGenerated);

		sessionId.setAttribute("passGenerated", reviewForgetPassword);
		sessionId.setMaxInactiveInterval(30);

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(465);
		mailSender.setUsername("manh.doduc@apuscorp.com");
		mailSender.setPassword("Doducmanh2001@");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // Thay đổi giá trị thành "true"
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("manh.doduc@apuscorp.com");
		message.setTo("anhcubom1402@gmail.com");
		message.setSubject("Test Simple Email");
		message.setText(passGenerated);
		mailSender.send(message);
		///
		ReviewForgetPassword passwordSend = new ReviewForgetPassword();
		passwordSend.setId(forgetPass.getId());
		passwordSend.setPasswordGenerated(null);
		model.addAttribute("errorCode", "Mật khẩu đã được gửi đến mail của bạn!");
		model.addAttribute("entity", passwordSend);
		return "login/confirm-password";
	}

	@PostMapping(value = "/forget/confirm")
	public String forgetConfirm(@ModelAttribute(value = "email") @Valid EmaiConfirm emaiConfirm, BindingResult result,
			Model model, HttpServletRequest request) {
		EmaiConfirm email = new EmaiConfirm();
		if (result.hasErrors()) {
			model.addAttribute("email", email);
			return "login/forget-password";
		}

		// Kiểm tra thông tin người dùng
		UserEntity userEntity = BaseService.selectUserFromEmail(emaiConfirm.getEmail());
		if (userEntity != null) {
			// Nếu mà người dung mà khác null thì sẽ gửi mật khẩu email lại cho người dùng
			String passGenerated = RandomStringUtils.randomAlphanumeric(10);
			ReviewForgetPassword password = new ReviewForgetPassword();
			password.setId(userEntity.getId());
			password.setPasswordGenerated(passGenerated);

			HttpSession session = request.getSession(true);
			session.setAttribute("passGenerated", password);
			System.out.println(password);
			session.setMaxInactiveInterval(30);

			// Lập 1 session mới lưu id của người dùng
			//////

			ReviewForgetPassword passwordSend = new ReviewForgetPassword();
			passwordSend.setId(userEntity.getId());
			passwordSend.setPasswordGenerated(null);

			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(465);
			mailSender.setUsername("manh.doduc@apuscorp.com");
			mailSender.setPassword("Doducmanh2001@");

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true"); // Thay đổi giá trị thành "true"
			props.put("mail.smtp.starttls.required", "true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.debug", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("manh.doduc@apuscorp.com");
			message.setTo("anhcubom1402@gmail.com");
			message.setSubject("Test Simple Email");
			message.setText(passGenerated);

			// Send Message!
			mailSender.send(message);

			model.addAttribute("entity", passwordSend);
			return "login/confirm-password";

		}
		model.addAttribute("notfound", "Không tìm thấy thông tin tài khoản và mật khẩu ");
		model.addAttribute("email", email);
		return "login/forget-password";

	}

	/// confirm-success
	@PostMapping(value = { "forget/confirm-success" })
	public String confirmSuccess(@ModelAttribute(value = "entity") @Valid ReviewForgetPassword emaiConfirm,
			@RequestParam(name = "khongkhop", required = false) String khongkhop, BindingResult result, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		

		if (result.hasErrors()) {
			ReviewForgetPassword passwordSend = new ReviewForgetPassword();
			passwordSend.setId(emaiConfirm.getId());
			passwordSend.setPasswordGenerated(null);
			model.addAttribute("entity", passwordSend);
			model.addAttribute("errorCode", "Xin vui lòng điền mã của bạn");
			return "login/forget-password";
		}
		// Kiểm tra thông tin người dùng
		ReviewForgetPassword emailsession = (ReviewForgetPassword) session.getAttribute("passGenerated");
		if (emailsession == null) {
			ReviewForgetPassword passwordSend = new ReviewForgetPassword();
			passwordSend.setId(emaiConfirm.getId());
			passwordSend.setPasswordGenerated(null);
			model.addAttribute("errorCode", "Mã hết hạn");
			model.addAttribute("entity", passwordSend);
			return "login/confirm-password";
		}
		if (emailsession.getPasswordGenerated().equals(emaiConfirm.getPasswordGenerated())) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(emaiConfirm.getId());
			model.addAttribute("entity", userEntity);

			return "login/chance-pass";
		}
		model.addAttribute("errorCode", "Số bạn đã nhập không khớp với mã. Vui lòng thử lại.");
		return "login/confirm-password";
	}

	
	@GetMapping(value = { "forget/confirm-success" })
	public String confirmSuccessError(@RequestParam(name = "khongkhop")String khongKhop,Model model,@RequestParam(name = "idok")Integer id) {
		if (khongKhop != null) {
			if(khongKhop.equals("passwordInCorrect")) {
				khongKhop = "Mật khâủ không khớp nhau vui lòng nhập lại";
			}
			model.addAttribute("errorCode", khongKhop);
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		model.addAttribute("entity", userEntity);
		return "login/chance-pass";
	}
	/// confirm-success
	@PostMapping(value = "/success/password/chance")
	public ModelAndView successPasswordChance(@ModelAttribute(value = "entity") @Valid UserEntity userEntity,
			BindingResult result, Model model, HttpServletRequest request,
			@RequestParam(name = "nhappass", required = false) String pass) {
		// nếu mật khẩu không khớp với mật khẩu vừa nhập thì thông báo
		if (!userEntity.getPassword().equals(pass)) {
            model.addAttribute("idok", userEntity.getId());
			String redirectUrl = "redirect:/forget/confirm-success?khongkhop=passwordInCorrect";
			return new ModelAndView(redirectUrl);
		}

		// Lưu lại mật khẩu đã được thay đổi
		UserEntity userChange = BaseService.timUser(userEntity.getId());
		userChange.setPassword(userEntity.getPassword());
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(userChange);
		BaseService.updateUser(data);
		return new ModelAndView("redirect:/");
	}

	@PostMapping(value = "/dang-ky/success")
	public String dangKySuccess(@ModelAttribute(value = "luser") @Valid UserEntity userok, BindingResult result,
			Model model, @RequestParam(value = "laipass") String laipass) {
		if (result.hasErrors()) {
			return "login/sign-up";
		}

		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user/insert";
		// Thêm vào api
		userok.setEnabled(1);

		// tìm xem tên đăng nhập đã có hay chưa nếu có rồi thì cút
		Client client = ClientBuilder.newClient();
		String URLLIST = "http://localhost:8080/Fashion-Shop-Api/rest/api/v1/user";
		Gson gs = new Gson();
		WebTarget target = client.target(URLLIST);
		String listUser = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<UserEntity>>() {
		}.getType();
		List<UserEntity> listok = gs.fromJson(listUser, typeOfT);
		for (int i = 0; i < listok.size(); i++) {
			if (listok.get(i).getName().equals(userok.getName())) {
				model.addAttribute("tb", "Email không hợp lệ");
				model.addAttribute("pass", laipass);
				return "login/sign-up";
			}
		}
		if (userok.getPassword().equals(laipass)) {
			// Nếu mà 2 cái khớp nhau thì sẽ cho đi đăng ký tiếp
			WebTarget target2 = client.target(URL);
			// Thêm thôi không cần lấy về
			// Truyền dữ liệu dưới dang chuỗi
			String data = gs.toJson(userok);
			Response response = target2.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
			String layve = response.readEntity(String.class);
			Notifies soUser = gs.fromJson(layve, Notifies.class);
			UserEntity userThem = BaseService.timUser(soUser.getMacode());
			// Thêm id là user trước
			int idrole = 3;
			RoleEntity roleok = BaseService.timRole(idrole);
//			roleok.set
			UserRoleEntity userRole = new UserRoleEntity(userThem, roleok);
			String dulieu = gs.toJson(userRole);
			Notifies tb = BaseService.InsertUserRole(dulieu);
			if (tb.getMacode() == 1) {
				return "redirect:/dang-nhap";
			}
			// Còn nếu mà không thành công thì vẩn ở lại trang đăng ký
			model.addAttribute("pass", laipass);
			model.addAttribute("tbok", tb);
			return "login/sign-up";
		} else {
			model.addAttribute("pass", laipass);
			model.addAttribute("tb", "Mật khẩu không khớp nhau");
		}
		return "login/sign-up";

	}

}
