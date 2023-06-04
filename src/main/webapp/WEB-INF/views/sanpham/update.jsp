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

.aok {
	margin-left: 7px;
	font-weight: bold;
	font-size: 16px;
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

.error {
	color: red;
	font-size: 13px;
	font-weight: bold;
	text-transform: uppercase;
	text-align: center;
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<header>
		<div class="header-admin d-flex sanphamsua">
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
			<div class="form-body">
				<div class="row">
					<div class="form-holder">
						<div class="form-content">
							<div class="form-items" style="border: none;">
								<h3>Sửa sản phẩm</h3>
								<p style="text-decoration: underline; color: red;">${tb.text}</p>
								<p style="text-decoration: underline; color: red;">${loinl}</p>
								<sform:form id="sanphamsubmit" style="padding: 0px 133px"
									modelAttribute="spct" action="${rootpath}update-success"
									method="post" enctype="multipart/form-data"
									class="requires-validation them-san-pham">
									<div class="col-md-12">
										<sform:input cssClass="chinhinput" type="number" path="id"
											readonly="true" />
									</div>
									<div class="col-md-12">
										<a class="aok">Tên sản phẩm</a>
										<sform:input type="text" path="name"
											placeholder="Nhập tên sản phẩm..." maxlength="50" />
										<sform:errors path="name" cssClass="error"></sform:errors>
									</div>
									<a class="aok" style="margin-left: 22px">Nội dung</a>
									<div class="col-md-12" style="padding-bottom: 16px;">
										<sform:input type="text" path="descripe" />
										<sform:errors cssClass="error" path="descripe"></sform:errors>
									</div>
									<div class="col-md-12">
										<a class="aok">Mô tả</a>
										<sform:textarea path="information" rows="3" id="information" />
										<sform:errors cssClass="error" path="information"></sform:errors>
									</div>
									<div class="col-md-12">
										<a class="aok">Giá nhập sản phẩm</a>
										<sform:input cssClass="chinhinput" type="number"
											path="price_import" />
										<sform:errors cssClass="error" path="price_import"></sform:errors>
									</div>
									<div class="col-md-12">
										<a class="aok">Giá sản phẩm</a>
										<sform:input cssClass="chinhinput" type="number"
											path="price_new" />
										<sform:errors cssClass="error" path="price_new"></sform:errors>
									</div>
									<div class="col-md-12">
										<a class="aok">Số lượng</a>
										<sform:input cssClass="chinhinput" type="number"
											path="sp_view" step="1" />
									</div>
									<div class="col-md-12 mt-3">
										<a class="aok">Loại sản phẩm</a>
										<sform:select path="idtheloai" cssClass="selectcss">
											<sform:options items="${lsp}" itemValue="id"
												itemLabel="loai_sp" />
										</sform:select>
									</div>
									<div class="col-md-12" style="padding-top: 16px">
										<a class="aok">Nhãn hiệu</a>
										<sform:select path="idnhanhieu" cssClass="selectcss">
											<sform:options items="${list}" itemValue="id"
												itemLabel="name_brand" />
										</sform:select>
									</div>
									<div class="col-md-12" style="padding-top: 16px">
										<sform:radiobutton path="status" value="true" />
										<span style="margin-left: 6px">Đang hiển thị</span>
										<sform:radiobutton path="status" value="false" />
										<span style="margin-left: 6px">Đang ẩn</span>
									</div>
									<div class="col-md-12">
										<c:forEach items="${spct.listHinhAnh}" var="p" begin="0"
											end="0">
											<img style="width: 100%; height: 300px; border-radius: 6px;"
												src="${rootpath}public/img/${p.name}" />
										</c:forEach>
									</div>
									<div class="col-md-12" style="padding-top: 16px">
										<input type="file" name="uploadFile" id="image"
											multiple="multiple" min="4">
									</div>
									<div class="col-md-12" style="padding-top: 16px">
										<c:forEach items="${spct.listHinhAnh}" var="p">
											<input type="hidden" value="${p.name}">
										</c:forEach>
									</div>
									<div class="form-button mt-3">
										<button onclick="submitDetailsForm()" type="submit"
											class="btn btn-primary suathemsp" style="width: 100%;">Sửa
											sản phẩm</button>
									</div>
								</sform:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script type="text/javascript"
		src="${rootpath}public/library/ckeditor/ckeditor.js"></script>
	<script type="text/javascript"
		src="${rootpath}public/library/ckfinder/ckfinder.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		var ckeditor = CKEDITOR.replace('information');
		CKFinder.setupCKEditor(ckeditor, '${rootpath}public/library/ckfinder/')
	</script>
</body>
</html>