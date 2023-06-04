<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath" />
<fmt:setLocale value="${lag}" />
<fmt:setBundle basename="language.mess_lag" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootpath}public/css/admins.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="${rootpath}public/css/fontawesome-free-6.1.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.menusanpham li i {
	padding-right: 15px;
}

.chinhinput {
	width: 100%;
	padding: 9px 20px;
	text-align: left;
	border: 0;
	outline: 0;
	border-radius: 6px;
	background-color: #fff;
	font-size: 15px;
	font-weight: 300;
	color: #8D8D8D;
	-webkit-transition: all 0.3s ease;
	transition: all 0.3s ease;
	margin-top: 16px;
}

.selectcss {
	margin-top: 0px !important;
}
</style>
</head>
<body>
	<header>
		<div class="header-admin d-flex">
			<div class="dropdown chonngonngu">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					data-toggle="dropdown" aria-expanded="false"
					style="text-transform: capitalize;">Lựa chọn ngôn ngữ</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${rootpath}Admin?lag=vi">Vietnamese</a>
					<a class="dropdown-item" href="${rootpath}Admin?lag=en">English</a>
					<a class="dropdown-item" href="${rootpath}Admin?lag=ja">Japan</a> <a
						class="dropdown-item" href="${rootpath}Admin?lag=ko">Korean</a> <a
						class="dropdown-item" href="${rootpath}Admin?lag=lo">Lào</a>
				</div>
			</div>
			<div class="top-headerdanhmuc">
				<a style="color: black;">Xin chào <b>${sessionScope.acc.fullName}</b>
				</a>
			</div>
			<div class="dangxuat">
				<a href="${rootpath}log-out">Đăng xuất</a>
			</div>
		</div>
		<div class="left-header w20 float">
			<ul class="menusanpham">
				<li><a class="a1" href=""><i class="fa-brands fa-sellcast"></i>
						Pos Bán Hàng</a></li>
				<li><a class="a2" href="${rootpath}Admin"><i
						class="fa-solid fa-house-user"></i> Trang Chủ</a></li>
				<li><a class="a3" href="${rootpath}list-hoa-don"><i
						class="fa-solid fa-cart-shopping"></i> Đơn hàng</a></li>
				<li><a class="a4" href="${rootpath}ql-san-pham"><i
						class="fa-brands fa-product-hunt"></i> Sản phẩm</a></li>
				<li><a class="a5" href="${rootpath}khach-hang"><i
						class="fa-solid fa-user-group"></i>Khách hàng</a></li>
				<li><a class="a6" href="${rootpath}tin-tuc"><i
						class="fa-regular fa-newspaper"></i> Tin tức</a></li>
				<li><a class="a7" href="${rootpath}danh-muc"><i
						class="fa-solid fa-boxes-stacked"></i>Danh mục</a></li>
				<li><a class="a8" href="${rootpath}nhan-hieu"><i
						class="fa-brands fa-salesforce"></i>Nhãn hiệu</a></li>
				<li><a class="a10" href="${rootpath}payment/list"><i
						class="fa-solid fa-dollar-sign"></i> Thanh toán vnpay</a></li>
				<li><a class="a7" href="${rootpath}color"><i
						class="fa-solid fa-boxes-stacked"></i>Màu sắc</a></li>
			</ul>
		</div>
		<div class="right-header"
			style="background-color: #d5e7e0; width: 100%;">
			<div class="form-body">
				<div class="form-holder" style="min-height: 50vh">
					<div class="form-content">
						<div class="form-items" style="min-width: 0px; border: none;">
							<h3>Sửa hóa đơn</h3>
							<p style="text-decoration: underline; color: red;">${tb.text}</p>
							<sform:form style="padding: 0px 90px;  padding-bottom: 46px;"
								modelAttribute="hd" action="${rootpath}sua-hd-tc" method="post">
								<div class="col-md-12">
									<sform:input cssClass="col-s-12" path="id" type="number"
										cssStyle="width:150%; border: none; padding: 9px 20px; border-radius: 8px; color: gray;"
										readonly="true" />
								</div>
								<div class="col-md-12">
									<sform:input type="text" path="nameKH" cssClass="col-s-12"
										cssStyle="width:150%;" placeholder="Nhập tên người nhận..."
										maxlength="50" />
								</div>
								<div class="col-md-12 mt-3">
									<sform:input type="text" cssStyle="width:150%;" path="address"
										cssClass="col-s-12" />
								</div>
								<div class="col-md-12">
									<sform:input type="text" cssStyle="width:150%;" path="sdt"
										cssClass="col-s-12" />
								</div>
								<div class="col-md-12">
									<sform:select cssClass="col-s-12" path="status"
										cssStyle="width:150%;">
										<sform:option value="true">Đang chờ xử lý</sform:option>
										<sform:option value="false">Đã xử lý</sform:option>
									</sform:select>
								</div>
								<div class="col-md-12">
									<sform:input path="idmakh" type="hidden" readonly="true" />
								</div>
								<div class="col-md-12">
									<sform:input cssClass="chinhinput col-s-12"
										cssStyle="width:150%;" type="date" path="ngayban" />
								</div>
								<div class="form-button mt-3">
									<button type="submit" class="btn btn-primary btnhoadon"
										style="width: 134%; margin-left: 15px;">Sửa hóa đơn</button>
								</div>
							</sform:form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>