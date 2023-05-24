<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootpath}public/css/user.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<style type="text/css">
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.mycart {
	padding: 10px;
	margin: 10px;
	border-radius: 5px;
	box-shadow: 3px 5px 5px 1px grey;
}
h6.my-0 {
    border: 2px solid black;
    border-top: none;
    border-left: none;
    border-right: none;
    padding-bottom: 4px;
}
</style>
</head>
<body class="bg-light">
	<jsp:include page="/PhanTrang/Header/MainMenu.jsp"></jsp:include>
	<div class="thanhtoangh" style="background: #dcd9d9; padding: 50px;">
		<div class="container">
			<div class="row">
				<div class="col-md-4 order-md-2 col-sm-12">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Your cart</span> <span
							class="badge badge-secondary badge-pill">${sl}</span>
					</h4>
					<ul class="list-group mb-3">
						<li class="list-group-item"><c:forEach items="${list}"
								var="lp">
								<div class="mycart">
									<h6 class="my-0">${lp.sanphamchitiet.mact.name}</h6>
									<small class="text-muted">Đơn giá : <b><fmt:formatNumber
												value="${lp.sanphamchitiet.mact.price_new * lp.sanphamchitiet.amount}"
												type="currency" /></b></small> <br> <small class="text-muted">Số
										lượng : <b>${lp.sanphamchitiet.amount}</b>
									</small> <br> <small class="text-muted">Màu sắc : <b>${lp.sanphamchitiet.idms.name}</b></small>
									<br> <small class="text-muted">Size : <b>${lp.sanphamchitiet.idkc.name}</b></small>
								</div>
							</c:forEach></li>
						<li class="list-group-item d-flex justify-content-between"><span>Total
								(USD)</span> <strong><fmt:formatNumber value="${tt}"
									type="currency" /></strong></li>
					</ul>

					<form class="card p-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Promo code">
							<div class="input-group-append">
								<button type="submit" class="btn btn-secondary">Redeem</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-8 order-md-1">
					<h4 class="mb-3" style="text-decoration: underline;">Thông tin
						đặt hàng</h4>
					<form class="needs-validation" action="${rootpath}thanh-toan-gh-tc"
						method="post">
						<div class="row">
							<div class="col-md-12">
								<label for="firstName" style="text-decoration: underline;">Full
									name</label> <input name="tenkh" type="text" class="form-control"
									id="firstName" readonly="readonly" value="${nd.fullName}">
							</div>
						</div>

						<div class="mb-3" style="display: none;">
							<label for="username" style="text-decoration: underline;">Username</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">@</span>
								</div>
								<input name="usname" type="text" class="form-control"
									id="username" readonly="readonly" value="${nd.name}" required>
							</div>
						</div>

						<div class="mb-3">
							<label for="email" style="text-decoration: underline;">Email
								<span class="text-muted">(Optional)</span>
							</label> <input name="email" type="email" class="form-control" id="email"
								placeholder="Nhập mail của bạn" value="${nd.name}" required="required">
						</div>

						<div class="mb-3">
							<label for="address" style="text-decoration: underline;">Address</label>
							<input name="address" type="text" class="form-control"
								id="address" placeholder="1234 Main St" required>
						</div>

						<div class="mb-3">
							<label for="address2" style="text-decoration: underline;">Call</label>
							<input name="call" type="text" class="form-control" id="address2"
								placeholder="Apartment or suite" required="required">
						</div>

						<div class="row">
							<div class="col-md-5 mb-3">
								<label for="country" style="text-decoration: underline;">Giới
									tính</label> <br> <input type="radio" required="required"
									name="gender" value="true">Nam <input type="radio"
									required="required" name="gender" value="false">Nữ
							</div>
							<div class="col-md-4 mb-3">
								<label for="state" style="text-decoration: underline;">Birthday<span>(Opitional)</span></label>
								<input name="ngaysinh" type="date" required="required">
							</div>
							<div class="col-md-3 mb-3" style="display: none;">
								<label for="zip">passwword</label> <input name="pass"
									type="text" readonly="readonly" value="${nd.password}">
							</div>
						</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
							to checkout</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/PhanTrang/Footer/footer.jsp"></jsp:include>
	<script
		src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>