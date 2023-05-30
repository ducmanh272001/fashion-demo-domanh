<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<fmt:setLocale value="${lag}" />
<stag:url value="/" var="rootpath" />
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
</head>

<body>
	<!-- cart -->
	<div class="cart-max">
		<div class="cart-small">
			<div class="cart-small-content">
				<button>
					<span>&times;</span>
				</button>
				<div class="cart-small-body">
					<h3 class="h31">My Cart (3)</h3>
					<div class="products-cart-content">
						<div class="products-cart">
							<div class="products-cart-img">
								<a href=""><img
									src="${rootpath}public/${rootpath}public/img/product14.png"
									alt=""></a>
							</div>
							<div class="products-cart-content">
								<h3>
									<a href="">Coronavirus Face Mask</a>
								</h3>
								<div class="products-cart-price">
									<span>1</span> <span>x</span> <span>80.000đ</span>
								</div>
							</div>
							<a class="delete-produt" href=""><i
								class="fa-solid fa-trash-can"></i></a>
						</div>
						<div class="products-cart">
							<div class="products-cart-img">
								<a href=""><img src="${rootpath}public/img/product10.png"
									alt=""></a>
							</div>
							<div class="products-cart-content">
								<h3>
									<a href="">Coronavirus Face Mask</a>
								</h3>
								<div class="products-cart-price">
									<span>1</span> <span>x</span> <span>80.000đ</span>
								</div>
							</div>
							<a class="delete-produt" href=""><i
								class="fa-solid fa-trash-can"></i></a>
						</div>
						<div class="products-cart">
							<div class="products-cart-img">
								<a href=""><img src="${rootpath}public/img/product12.png"
									alt=""></a>
							</div>
							<div class="products-cart-content">
								<h3>
									<a href="">Coronavirus Face Mask</a>
								</h3>
								<div class="products-cart-price">
									<span>1</span> <span>x</span> <span>80.000đ</span>
								</div>
							</div>
							<a class="delete-produt" href=""><i
								class="fa-solid fa-trash-can"></i></a>
						</div>
					</div>
					<div class="products-cart-subtotal">
						<span>subtotal</span> <span>$228.000</span>
					</div>
					<div class="products-cart-btn">
						<a href="">checkout</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- modal-quickview -->
	<div class="modal-quick-view">
		<div class="modal-quickview-one">
			<button>
				<i class="fa-solid fa-xmark"></i>
			</button>
			<div class="modal-quick-view-body">
				<div class="row">
					<div class="col-lg-5 col-md-6 col-sm-12 col-12">
						<div class="modal-quick-view-img">
							<div id="carouselId" class="carousel slide" data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carouselId" data-slide-to="0" class="active"></li>
									<li data-target="#carouselId" data-slide-to="1"></li>
									<li data-target="#carouselId" data-slide-to="2"></li>
									<li data-target="#carouselId" data-slide-to="3"></li>
									<li data-target="#carouselId" data-slide-to="4"></li>
								</ol>
								<div class="carousel-inner" role="listbox">
									<div class="carousel-item active">
										<img src="${rootpath}public/img/product-20.png"
											alt="First slide">
									</div>
									<div class="carousel-item">
										<img src="${rootpath}public/img/product-moi3.png"
											alt="Second slide">
									</div>
									<div class="carousel-item">
										<img src="${rootpath}public/img/product-20.png"
											alt="Third slide">
									</div>
									<div class="carousel-item">
										<img src="${rootpath}public/img/product-moi3.png"
											alt="Second slide">
									</div>
									<div class="carousel-item">
										<img src="${rootpath}public/img/product-moi3.png"
											alt="Second slide">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-7 col-md-6 col-sm-12 col-12">
						<div class="modal-quick-view-text">
							<h3>Black fashion handbag JI9023</h3>
							<div class="review-ratting">
								<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
								<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
								<i class="fa-solid fa-star"></i> <span>(2 Customer
									Review)</span>
							</div>
							<h4>$317.76</h4>
							<p>Standard dummy text ever since the 1500s, when an unknown
								printer took a galley of type and scrambled it to make a type
								specimen.</p>
							<div class="color">
								<span>Color</span>

								<div class="chon-color">
									<label for="color-red"> <input class="input-red"
										name="gender" type="radio" checked> <span
										class="product-cl-red"></span>
									</label> <label for="color-red"> <input class="input-red"
										name="gender" type="radio"> <span
										class="product-cl-red"></span>
									</label> <label for="color-red"> <input class="input-red"
										name="gender" type="radio"> <span
										class="product-cl-red"></span>
									</label>
								</div>
							</div>
							<form class="form-quickview" action="">
								<div class="product-count-one">
									<a href="cart.html">Add To Cart</a>
								</div>
							</form>
							<div class="modal-product-icon">
								<h4>SHARE THIS PRODUCT</h4>
								<ul class="icon-quickview">
									<li><a href=""><i class="fa-brands fa-facebook-f"></i></a></li>
									<li><a href=""><i class="fa-brands fa-instagram"></i></a></li>
									<li><a href=""><i class="fa-brands fa-twitter"></i></a></li>
									<li><a href=""><i class="fa-brands fa-linkedin-in"></i></a></li>
									<li><a href=""><i class="fa-brands fa-google-plus-g"></i></a></li>
									<li><a href=""><i class="fa-brands fa-pinterest-p"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/PhanTrang/Header/MainMenu.jsp"></jsp:include>
	<!-- bannerproduct -->
	<div class="banner-product">
		<div class="row">
			<div class="col-lg-12">
				<div class="banner-product-text">
					<h2>Shop</h2>
					<ul class="">
						<li><a href="">Home</a></li>
						<li><i class="fa-solid fa-slash"></i></li>
						<li>Product single</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- style-product-detail -->
	<section class="product-detail">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<div class="product-filter">
						<select name="product" class="luachon-product">
							<option value="Filter">Filter</option>
							<option value="Most Popular">Most Popular</option>
							<option value="Best Seller">Best Seller</option>
							<option value="Tranding">Tranding</option>
							<option value="Featured">Featured</option>
						</select>
					</div>
				</div>
				<div class="col-lg-6 col-md-12">
					<div class="product-sort-right">
						<div class="product-sort-right-title">
							<p>SORT BY:</p>
						</div>
						<div class="customselect">
							<form action="${rootpath}product/all" method="get">
							<select name="show" onchange="this.form.submit()">
									<option label="${tangdan}" value="">Lựa chọn</option>
									<option value="ascending">Tăng dần</option>
									<option value="decrease">Giảm dần</option>
									<option value="default">Mặc định</option>
								</select>
							</form>
						</div>
						<div class="product-sortview">
							<ul class="d-flex">
								<li><a href=""> <i class="fa-solid fa-list"></i>
								</a></li>
								<li><a href=""> <i
										class="fa-solid fa-table-cells-large"></i>
								</a></li>
								<li><a href=""> <i class="fa-solid fa-table-cells"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">
						<c:forEach items="${list}" var="l">
							<div class="col-lg-3 col-md-4 col-sm-6 col-12">
								<div class="product2-img-one">
									<div class="hot-product-img-one">
										<div class="thump">
											<span>Mã <b>${l.id}</b></span>
											<div class="image-zoom">
											<c:forEach items="${l.listHinhAnh}" var="p" begin="0" end="0">
												<img src="${rootpath}public/img/${p.name}"> 
											</c:forEach>
											<c:forEach items="${l.listHinhAnh}" var="p" begin="1" end="1">
												<img class="zooom-product" src="${rootpath}public/img/${p.name}">
											</c:forEach>
											</div>
											<div class="icon-hot-product">
												<a href=""><i class="fa-regular fa-heart"></i></a> <a
													href=""><i class="fa-solid fa-expand"></i></a> <a href=""><i
													class="fa-solid fa-arrow-right-arrow-left"></i></a>
											</div>
											<form action="${rootpath}product/ao-nu/${l.id}" method="get">
												<button>View Product Detail</button>
											</form>
										</div>
										<div class="content">
											<a href="${rootpath}product/ao-nu/${l.id}">${l.name}</a>
											<p>
												<fmt:formatNumber value="${l.price_new}" type="currency" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="phan-trang">
						<div class="row">
							<div class="col-lg-12">
								<ul class="danh-muc-pt">
									<c:if test="${trang > 1}">
										<c:if test="${tangdan != null}">
											<li><a
												href="${rootpath}product/${ten}?page=${trang - 1}&show=${tangdan}"><span><<</span></a></li>
										</c:if>
										<c:if test="${tangdan == null}">
											<li><a
												href="${rootpath}product/${ten}?page=${trang - 1}"><span><<</span></a></li>
										</c:if>
									</c:if>
									<c:if test="${tangdan != null}">
										<c:forEach begin="1" end="${Math.ceil(sl/8)}" var="i">
											<li><a
												href="${rootpath}product/all?page=${i}&show=${tangdan}">${i}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${ten == 'all'}">
										<c:forEach begin="1" end="${Math.ceil(sl/8)}" var="i">
											<li><a href="${rootpath}product/${ten}?page=${i}">${i}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${timbrand != null}">
										<c:forEach begin="1" end="${Math.ceil(sl/8)}" var="i">
											<li><a
												href="${rootpath}product/${timbrand}?page=${i}&nhanhieu=${idla}">${i}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${timlsp != null}">
										<c:forEach begin="1" end="${Math.ceil(sl/8)}" var="i">
											<li><a
												href="${rootpath}product/${timlsp}?page=${i}&loaisp=${idla}">${i}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${size >= 8}">
										<c:if test="${tangdan != null}">
											<li><a
												href="${rootpath}product/${ten}?page=${trang + 1}&show=${tangdan}"><span>>></span></a></li>
										</c:if>
										<c:if test="${tangdan == null}">
											<li><a
												href="${rootpath}product/${ten}?page=${trang + 1}"><span>>></span></a></li>
										</c:if>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- sylecolg-3 -->
				<div class="col-lg-3">
					<div class="product-categories">
						<form class="input-search" action="${rootpath}tim-kiem-product"
							method="get">
							<div class="product-categories-search">
								<input type="text" value="${tenla}" name="tensp">
							</div>
						</form>
						<div class="shop_sidebar_boxed">
							<h4>Product Categories</h4>
							<form method="get" action="${rootpath}product/timLoaiSanPham">
								<c:forEach items="${loaisp}" var="lsp">
									<label class="custom_boxed">${lsp.loai_sp}<input
										checked="checked" name="loaisp" type="radio" value="${lsp.id}"
										onclick="this.form.submit();"><span class="checkmark"></span>
									</label>
								</c:forEach>
							</form>
						</div>
						<div class="shop_sidebar_boxed">
							<h4>Brand</h4>
							<form action="${rootpath}product/timBrand" method="get">
								<c:forEach items="${lnh}" var="l">
									<label class="custom_boxed"> ${l.name_brand} <input
										checked="checked" name="nhanhieu" type="radio" value="${l.id}"
										onclick="this.form.submit();"> <span class="checkmark"></span>
									</label>
								</c:forEach>
							</form>
						</div>
						<div class="shop_sidebar_boxed">
							<h4>Chọn mức giá</h4>
							<div class="thanh-price_filter">
								<span class="thanh-price_filter-one"></span> <span
									class="thanh-price_filter-one"></span>
							</div>
							<form method="get" action="${rootpath}timKiemTheoGia">
								<label class="custom_boxed">100.000đ — 200.000đ<input
									checked="checked" name="gia" type="radio" value="100"
									onclick="this.form.submit();"> <span class="checkmark"></span>
								</label> <label class="custom_boxed">200.000đ — 300.000đ<input
									checked="checked" name="gia" type="radio" value="200"
									onclick="this.form.submit();"> <span class="checkmark"></span>
								</label> <label class="custom_boxed">300.000đ — 500.000đ<input
									checked="checked" name="gia" type="radio" value="300"
									onclick="this.form.submit();"> <span class="checkmark"></span>
								</label> <label class="custom_boxed">Trên 500.000đ<input
									checked="checked" name="gia" type="radio" value="500"
									onclick="this.form.submit();"> <span class="checkmark"></span>
								</label>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="instagram">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="center-heading text-center">
						<h2>follow us instagram</h2>
						<p>Mauris luctus nisi sapien tristique dignissim ornare</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="card-group">
						<div class="owl-carousel owl-theme" id="cardxoay">
							<div class="item">
								<div class="card">
									<a href=""> <span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post11.png" alt="Card image cap">
									</a>
								</div>
							</div>
							<div class="item">
								<div class="card">
									<a href=""> <span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post10.png" alt="Card image cap">
									</a>
								</div>
							</div>
							<div class="item">
								<div class="card">
									<a href=""><span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post12.png" alt="Card image cap"></a>
								</div>
							</div>
							<div class="item">
								<div class="card">
									<a href=""> <span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post6.png" alt="Card image cap">
									</a>
								</div>
							</div>
							<div class="item">
								<div class="card">
									<a href=""> <span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post8.png" alt="Card image cap">
									</a>
								</div>
							</div>
							<div class="item">
								<div class="card">
									<a href=""> <span><i class="fa-brands fa-instagram"></i></span>
										<img class="card-img-top"
										src="${rootpath}public/img/post9.png" alt="Card image cap">
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/PhanTrang/Footer/footer.jsp"></jsp:include>
	<div class="back-top">
		<a href=""><i class="fa-solid fa-angles-up"></i></a>
	</div>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script
		src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="${rootpath}public/plugin/dist/owl.carousel.min.js"></script>
	<script src="${rootpath}public/js/jquery.js"></script>
</body>
</html>