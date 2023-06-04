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
</style>
</head>
<body>

	<header>
		<div class="header-admin d-flex">
			<span class="annutx" style="cursor: pointer;display: none;"><a class="oknhan"><i class="fa-solid fa-bars"></i></a></span>
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
				<li><a class="a8" href="${rootpath}nhan-hieu"><i
						class="fa-brands fa-salesforce"></i>Nhãn hiệu</a></li>
				<li><a class="a10" href="${rootpath}payment/list"><i
						class="fa-solid fa-dollar-sign"></i> Thanh toán vnpay</a></li>
			  <li><a class="a7" href="${rootpath}color"><i
						class="fa-solid fa-boxes-stacked"></i>Màu sắc</a></li>
			</ul>
		</div>
		<div class="cangiua">
			<div class="right-header w80 float">
				<div class="right-header-chu">
					<p>
						<a href=""><i class="fa-solid fa-square-check"></i></a> Hoạt động
						hôm nay
					</p>
				</div>
				<div class="right-headerr w25 float col-s-12">
					<div style="background-color: #9abc32;" class="right-headerrv">
						<div class="right-headerrv-icon float">
							<a href=""><i class="fa-solid fa-file-invoice-dollar"></i></a>
						</div>
						<div class="right-headerrv-chu float">
							<p>Tổng tiền nhập hàng</p>
							<p>
								<fmt:formatNumber value="${tt}" type="currency" />
							</p>
						</div>
					</div>
				</div>
				<div class="right-headerr w25 float col-s-12">
					<div style="background-color: #6fb3e0;" class="right-headerrv">
						<div class="right-headerrv-icon float">
							<a href=""><i class="fa-solid fa-cart-shopping"></i></a>
						</div>
						<div class="right-headerrv-chu float">
							<p>Tổng giá sản phẩm</p>
							<p>
								<fmt:formatNumber value="${ttn}" type="currency" />
							</p>
						</div>
					</div>
				</div>
				<div class="right-headerr w25 float col-s-12">
					<div style="background-color: #d53f40;" class="right-headerrv">
						<div class="right-headerrv-icon float">
							<a href=""><i class="fa-solid fa-circle-left"></i></a>
						</div>
						<div class="right-headerrv-chu float">
							<p>Khách hàng</p>
							<p>${sl}</p>
						</div>
					</div>
				</div>
				<div class="right-headerr w25 float col-s-12">
					<div style="background-color: #e8b110;" class="right-headerrv">
						<div class="right-headerrv-icon float">
							<a href=""><i class="fa-brands fa-sellsy"></i></a>
						</div>
						<div class="right-headerrv-chu float">
							<p>Đơn hàng</p>
							<p>${shd}</p>
						</div>
					</div>
				</div>
				<div class="hoatdong cols">
					<div class="hoatdong1 w33 float col-s-12">
						<div class="hoatdong1-v">
							<div class="hoatdong1-vdau">
								<p>
									<i class="fa-brands fa-creative-commons-nd"></i> Hoạt động
								</p>
							</div>
							<div class="hoatdong1-vleft w50 float">
								<p>Tiền bán hàng</p>
								<p>Số đơn hàng</p>
								<p>Số sản phẩm</p>
								<p>Khách hàng trả</p>
							</div>
							<div class="hoatdong1-vright w50 float">
								<p>0</p>
								<p>0</p>
								<p>0</p>
								<p>0</p>
							</div>
						</div>
					</div>
					<div class="hoatdong1 w33 float col-s-12">
						<div class="hoatdong1-v">
							<div class="hoatdong1-vdau">
								<p>
									<i class="fa-brands fa-ioxhost"></i> Thông tin kho
								</p>
							</div>
							<div class="hoatdong1-vleft w50 float">
								<p>Tồn kho</p>
								<p>Hết hàng</p>
								<p>Sắp hết hàng</p>
								<p>Vượt định mức</p>
							</div>
							<div class="hoatdong1-vright w50 float">
								<p>0</p>
								<p>0</p>
								<p>0</p>
								<p>0</p>
							</div>
						</div>
					</div>
					<div class="hoatdong1 w33 float col-s-12">
						<div class="hoatdong1-v">
							<div class="hoatdong1-vdau">
								<p>
									<i class="fa fa-barcode"></i> Thông tin sản phẩm
								</p>
							</div>
							<div class="hoatdong1-vleft w50 float">
								<p>Sản phẩm</p>
								<p>Chưa làm giá bán</p>
								<p>Chưa nhập giá mua</p>
								<p>Chưa phân loại</p>
							</div>
							<div class="hoatdong1-vright w50 float">
								<p>0</p>
								<p>0</p>
								<p>0</p>
								<p>0</p>
							</div>
						</div>
					</div>
				</div>
				<div class="bieudodoanhso cols">
					<div class="bieudodoanhso1 w33 float hide">
						<div class="bieudodoanhso1-v">
							<p>
								<i class="fa-regular fa-chart-bar"></i> Biểu đồ doanh số tuần
							</p>
							<p>Loading...</p>
						</div>
					</div>
					<div class="bieudodoanhso1 w33 float hide">
						<div class="bieudodoanhso1-v">
							<p>
								<i class="fa fa-globe"></i> Thông tin từ web
							</p>
							<p>Loading...</p>
						</div>
					</div>
					<div class="bieudodoanhso1 w33 float hide">
						<div class="bieudodoanhso1-v">
							<p>
								<i class="fa fa-wifi"></i> Tin chuyên ngành
							</p>
							<p>Loading...</p>
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
	<script type="text/javascript" src="${rootpath}public/js/admin.js"></script>
</body>
</html>