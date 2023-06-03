<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function xoaTc(tenXoa) {
		var xoaOk = confirm("Bạn có muốn xóa " + tenXoa
				+ " ra khỏi danh sách không")
		if (xoaOk) {
			return true;
		} else {
			return false;
		}
	}
</script>
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
				<li><a class="a8" href="${rootpath}nhan-hieu"><i
						class="fa-brands fa-salesforce"></i>Nhãn hiệu</a></li>
				<li><a class="a10" href="${rootpath}payment/list"><i
						class="fa-solid fa-dollar-sign"></i> Thanh toán vnpay</a></li>
			</ul>
		</div>
		<div class="right-header w80 float">
			<div class="right-headermanh">
				<div class="logo-ok">
					<div class="right-header-danhsachsanpham w66 float ">
						<h3>
							<fmt:message key="labelok"></fmt:message>
						</h3>
					</div>
					<div>
					 <a class="taosp" href="${rootpath}trang-them-san-pham"><i
									class="fa-solid fa-plus"></i> Tạo SP</a>
					</div>
				</div>
			</div>
			<form action="${rootpath}tim-kiem-sp"
				class="nhapmasanpham cols" method="get">
				<input type="text" name="tentim" value="${ltim.name}"
					placeholder="Nhập tên sản phẩm cần tìm...">
				<select name="nhanhieu">
				<option value="">Nhãn hiệu</option>
					<c:forEach items="${lnh}" var="ln">
						<option value="${ln.id}">${ln.name_brand}</option>
					</c:forEach>
				</select> <select name="loaisanpham">
				   <option value="">Loại sản phẩm</option>
					<c:forEach items="${lsp}" var="ls">
						<option value="${ls.id}">${ls.loai_sp}</option>
					</c:forEach>
				</select>
				<button>
					<i class="fa-solid fa-magnifying-glass"></i> Tìm kiếm
				</button>
			</form>
			<hr>
			<span class="okclass">${oco}</span>
			<c:if test="${tb.macode == 1}">
				<span
					style="display: flex; justify-content: center; text-decoration: underline; color: green; font-size: 20px; font-weight: bold;">${tb.text}</span>
			</c:if>
			<c:if test="${tb.macode == 0}">
				<span
					style="display: flex; justify-content: center; text-decoration: underline; color: red; font-size: 20px; font-weight: bold;">${tb.text}</span>
			</c:if>
			<div class="bangsanpham cols">
				<table class="sanphamadmin">
					<tr>
						<th>Id</th>
						<th>Tên</th>
						<th>Thông tin</th>
						<th>Gía nhập</th>
						<th>Giá tiền</th>
						<th>Số lượng</th>
						<th>Ngày</th>
						<th>Trạng thái</th>
						<th>Chất lượng</th>
						<th>Nhãn hiệu</th>
						<th>Sửa SP</th>
						<th>Xóa SP</th>
					</tr>
					<c:if test="${ltim != null}">
						<tr>
							<td>${ltim.id}</td>
							<td title="${ltim.name}">${ltim.name}</td>
							<td title="${ltim.information}">${ltim.information}</td>
							<td><fmt:formatNumber value="${ltim.price_import}"
									type="currency" /></td>
							<td><fmt:formatNumber value="${ltim.price_new}"
									type="currency" /></td>
							<td>${ltim.sp_view}</td>
							<td><fmt:formatDate value="${ltim.day_update}"
									dateStyle="short" /></td>
							<td title="${ltim.status ? 'Đang hiển thị' : 'Đang ẩn'}">${l.status ? 'Đang hiển thị' : 'Đang ẩn'}</td>
							<td title="${ltim.tennh}">${ltim.tennh}</td>
							<td title="${ltim.tenloai}">${ltim.tenloai}</td>
							<td><a href="${rootpath}update-san-pham/${ltim.id}"> <img
									src="${rootpath}public/img/edit-validated-icon.png">
							</a></td>
							<td><a href="${rootpath}delete-san-pham/${ltim.id}"> <img
									src="${rootpath}public/img/Close-2-icon.png">
							</a></td>
						</tr>
					</c:if>
					<c:if test="${ltim == null}">
						<c:forEach items="${list}" var="l">
							<tr>
								<td>${l.id}</td>
								<td title="${l.name}">${l.name}</td>
								<td title="${l.information}">${l.information}</td>
								<td><fmt:formatNumber value="${l.price_import}"
										type="currency" /></td>
								<td><fmt:formatNumber value="${l.price_new}"
										type="currency" /></td>	
								<td>${l.sp_view}</td>
								<td><fmt:formatDate value="${l.day_update}"
										dateStyle="short" /></td>
								<td title="${l.status ? 'Đang hiển thị' : 'Đang ẩn'}">${l.status ? 'Đang hiển thị' : 'Đang ẩn'}</td>
								<td title="${l.tennh}">${l.tennh}</td>
								<td title="${l.tenloai}">${l.tenloai}</td>
								<td><a href="${rootpath}update-san-pham/${l.id}"> <img
										src="${rootpath}public/img/edit-validated-icon.png">
								</a></td>
								<td><a
									href="${rootpath}delete-san-pham/${l.id}?page=${sotrang}"
									onclick="return xoaTc('${l.name}');"> <img
										src="${rootpath}public/img/Close-2-icon.png">
								</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<div>
				<ul class="sotrangadmin">
					<c:forEach begin="1" end="${Math.ceil(sl / 8)}" var="i">
						<li><a href="${rootpath}ql-san-pham?page=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="footersanpham cols">
				<p>
					SL sản phẩm: <span style="font-size: 15px; font-weight: bold;">${sl}</span>
				</p>
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