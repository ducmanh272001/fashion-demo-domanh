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
.menusanpham li i {
	padding-right: 15px;
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
		
		<div class="thanhtrai dieuhuongan">
			<span><a href=""><i class="fa-solid fa-xmark dongclose"></i></a></span>
			<ul class="leftstyle">
				<li><a class="a1" href=""><i
						class="fa-brands fa-sellcast leftmenu"></i> Pos Bán Hàng</a></li>
				<li><a class="a2" href="${rootpath}Admin"><i
						class="fa-solid fa-house-user leftmenu"></i> Trang Chủ</a></li>
				<li><a class="a3" href="${rootpath}list-hoa-don"><i
						class="fa-solid fa-cart-shopping leftmenu"></i> Đơn hàng</a></li>
				<li><a class="a4" href="${rootpath}ql-san-pham"><i
						class="fa-brands fa-product-hunt leftmenu"></i> Sản phẩm</a></li>
				<li><a class="a5" href="${rootpath}khach-hang"><i
						class="fa-solid fa-user-group leftmenu"></i>Khách hàng</a></li>
				<li><a class="a6" href="${rootpath}tin-tuc"><i
						class="fa-regular fa-newspaper leftmenu"></i> Tin tức</a></li>
				<li><a class="a5" href="${rootpath}danh-muc"><i
						class="fa-solid fa-user-group leftmenu"></i>Danh mục</a></li>
				<li><a href="${rootpath}log-out"><i
						class="fa-solid fa-right-from-bracket leftmenu"></i>Đăng xuất</a></li>
			</ul>
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
				<li><a class="a8" href=""><i
						class="fa-brands fa-salesforce"></i> Doanh số</a></li>
				<li><a class="a9" href=""><i class="fa-solid fa-file-lines"></i>
						Thu chi</a></li>
				<li><a class="a10" href="loinhuan.html"><i
						class="fa-solid fa-dollar-sign"></i> Lợi nhuận</a></li>
				<li><a class="a11" href="thietlap.html"><i
						class="fa-solid fa-list-check"></i> Thiết lập</a></li>
			</ul>
		</div>
		<div class="right-header w80 float">
			<div class="right-headermanh">
				<div class="logo-ok">
					<div class="right-header-danhsachsanpham ">
						<h3>${danhsach}</h3>
					</div>
					<div class="right-header-taosanpham">
						<ul>
							<li><a href="${rootpath}insert-brand"><i
									class="fa-solid fa-plus"></i>${tao}</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="d-flex tbhoadon">
				<span class="">${tb}</span>
			</div>
			<div class="bangsanpham cols">
				<table style="margin: 1em; text-align: center; width: 97%;">
					<tr>
						<th>Id</th>
						<th>Tên nhãn hiệu</th>
						<th>Trạng thái</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
					<c:forEach items="${list}" var="l">
						<tr>
							<td>${l.id}</td>
							<td>${l.name_brand}</td>
							<td>${l.status?'Đang hiển thị' : 'Không hiển thị'}</td>
							<td><a href="${rootpath}find-brand/${l.id}"> <img
									src="${rootpath}public/img/Pencil-icon (1).png">
							</a></td>
							<td><a href="${rootpath}delete-brand/${l.id}"> <img
									src="${rootpath}public/img/close-icon.png">
							</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<ul class="sotrangadmin">
					<c:forEach begin="1" end="${Math.ceil(sl / 8)}" var="i">
						<li><a href="${rootpath}nhan-hieu?page=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="${rootpath}public/js/admin.js"></script>
</body>
</html>