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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootpath}public/css/admins.css">
<link rel="stylesheet"
	href="plugin/dist/assets/owl.theme.default.min.css">
<link rel="stylesheet" href="plugin/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<style type="text/css">
table th {
	border: 1px solid black !important;
}
</style>
</head>

<body>
	<header>
		<div class="header-admin d-flex">
			<span><a class="oknhan"><i class="fa-solid fa-bars"></i></a></span>
			<div class="dropdown chonngonngu">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					data-toggle="dropdown" aria-expanded="false"
					style="text-transform: capitalize;">Ngôn ngữ</button>
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
		<div class="right-header w80 float">
			<div class="right-headermanh">
				<div class="logo-ok">
					<div class="right-header-danhsachsanpham w66 float">
						<h3>Danh sách hóa đơn</h3>
					</div>
				</div>
			</div>
			<div class="d-flex tbhoadon">
				<span class="">${xoatc}</span>
			</div>
			<div>
				<table class="table"
					style="width: 97%; margin: 0em; text-align: center; border: 1px solid black;">
					<thead>
						<tr>
							<th class="text-center">Tên Sản Phẩm</th>
							<th>Màu sắc</th>
							<th>Kích cỡ</th>
							<th>Số lượng</th>
							<th>Giá tiền</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody class="table-body">
						<c:forEach items="${list}" var="l">
							<tr class="cell-1">
								<td>${l.id_sp.sanpham_name}</td>
								<td>${l.id_sp.mausac_name}</td>
								<td>${l.id_sp.kichco_name}</td>
								<td>${l.quantity}</td>
								<td><fmt:formatNumber value="${l.price}" type="currency" /></td>
								<td><fmt:formatNumber value="${l.price * l.quantity}"
										type="currency" /></td>
							</tr>
						</c:forEach>
						<tr>
							<td style="text-align: end; font-weight: bold;" colspan="6"><span>Tổng
									hóa đơn: </span>
							<fmt:formatNumber value="${tthd}" type="currency" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</header>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="plugin/dist/owl.carousel.min.js"></script>
</body>
</html>