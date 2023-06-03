<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootpath}public/css/user.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>

	<div class="hopthoaimodal">
		<div class="hopthoai">
			<span>&times;</span>
			<h4>Bạn có thật sự muốn thoát không !</h4>
			<ul class="nuthopthoai">
				<li><a href="${rootpath}dang-nhap">Có</a></li>
				<li><a href="${rootpath}dang-ky">Không</a></li>
			</ul>
		</div>
	</div>

	<sform:form action="${rootpath}dang-ky/success" method="post"
		modelAttribute="luser" id="dangkyv">
		<div class="formdangky">
			<h2>Đăng Ký ${tbok.text}</h2>
			<div align="center"><span class="error" style="text-align: center;color: red;text-decoration: underline;font-weight: bold;">${tb}</span></div>
			<div class="formdangky-area">
				<div class="formdangky-img hide">
					<img
						src="https://file.hstatic.net/1000116360/collection/8_iphone_ipad_xach_tay_my_tai_hitek_store_cc923c1498344dcaba9b9162f4a1c740_1024x1024.jpg"
						alt="">
				</div>
				<div class="formdangky-text col-dt">
					<a class="nuttat" href="${rootpath}dang-nhap">&times;</a>
					<div class="formdangky-text-one">
						<label for="">Nhập tên</label>
						<div class="formdangky-text-input d-flex">
							<span><i class="fa-solid fa-user-pen"></i></span>
							<sform:input type="text" id="tendn" path="fullName"
								placeholder="Nhập tên đăng ký.." maxlength="50" />
							<sform:errors path="fullName" class="error" />
						</div>
					</div>
					<div class="formdangky-text-one">
						<label for="">Nhập email</label>
						<div class="formdangky-text-input d-flex">
							<span><i class="fa-regular fa-envelope"></i></span>
							<sform:input type="text" id="nhapemail" path="name"
								placeholder="Nhập emai.." maxlength="50" />
							<sform:errors path="name" class="error" />
						</div>
					</div>
					<div class="formdangky-text-one">
						<label for="">Nhập password</label>
						<div class="formdangky-text-input d-flex">
							<span><i class="fa-solid fa-key"></i></span>
							<sform:input cssClass="matnhin" type="password" id="nhappassword"
								path="password" placeholder="Nhập password..." maxlength="50" />
							<sform:errors path="password" class="error" cssStyle="position: absolute;margin-top: 3px;margin-left: 222px;color: red;font-size: 18px;font-weight: bold;border: none;" />
							<span class="matdangky"><i class="fa-solid fa-eye"></i></span>
						</div>
					</div>
					<div class="formdangky-text-one">
						<label for="">Nhập lại password</label>
						<div class="formdangky-text-input d-flex">
							<span><i class="fa-solid fa-key"></i></span> <input
								class="matnhin1" value="${pass}" id="nhaplaipassword"
								type="password" placeholder="Nhập lại password..."
								name="laipass"> <span class="matdangky1"><i
								class="fa-solid fa-eye"></i></span>
						</div>
					</div>
					<button>Register</button>
					<p>Fast Signup With Your Favourite Social Profile</p>
					<ul class="formdangky-icon">
						<li><a href=""><i class="fa-brands fa-facebook-f"></i></a></li>
						<li><a href=""><i class="fa-brands fa-youtube"></i></a></li>
						<li><a href=""><i class="fa-brands fa-twitter"></i></a></li>
						<li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Fashion-Shop/login-google&response_type=code&client_id=659664644286-qqv1oggjqtp4s5bvslm2rvqoofejb2rs.apps.googleusercontent.com&approval_prompt=force"><i class="fa-brands fa-google-plus-g"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</sform:form>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script
		src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${rootpath}public/js/signin.js"></script>
</body>
</html>