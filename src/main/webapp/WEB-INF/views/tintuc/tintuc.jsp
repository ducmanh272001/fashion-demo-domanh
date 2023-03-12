<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath" />
<fmt:setLocale value="${lag}" />
<fmt:setBundle basename="language.mess_lag" />
<meta charset="utf-8">
<style type="text/css">
.mota {
	color: inherit !important;
	text-transform: uppercase;
	font-size: 19px;
	font-weight: bold;
	font-family: auto;
	text-decoration: underline;
}
img{
   width: 100%!important;
   height: 100%!important;
}
.tintucdau {
	margin-top: 60px
}
</style>
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

	<div class="nenmosearch">
		<span>&times;</span>
		<div class="search-mo">
			<form>
				<input type="text" placeholder="Search here">
				<button>
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>
	</div>
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
									src="${rootpath}public/${rootpath}public/img/A280-Ao-kieu-xep-ta-phoi-nut-Den.jpg"
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
							<h3>${sp.name}</h3>
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
					<h2>${tintuc}</h2>
					<ul class="">
						<li><a href="">Home</a></li>
						<li><i class="fa-solid fa-slash"></i></li>
						<li>Product single</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- style-product -->
	<div class="container">
		<div class="tintucdau">
			<a class="mota" href="#"> ${ltt.title}</a>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
			  <h4>Mô tả</h4>
				 <p>${ltt.descripe}</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				 ${ltt.content}
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
	<script src="${rootpath}public/plugin/cloundzoom/jquery.js"></script>
	<script src="${rootpath}public/plugin/cloundzoom/zoom.js"></script>
	<script src="${rootpath}public/plugin/cloundzoom/script.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="${rootpath}public/plugin/dist/owl.carousel.min.js"></script>
	<script src="${rootpath}public/js/product.js"></script>
	<script src="${rootpath}public/js/jquery.js"></script>
</body>

</html>