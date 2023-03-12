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
input.nutbutton {
	padding: 4px 8px;
	background-color: black;
	color: white;
	font-size: 16px;
	font-weight: 600;
	offset: 1px inherit;
	outline: 2px solid black;
	outline-offset: 2px;
	box-shadow: -3px 2px 9px 5px #42414196;
	transition: 0.5s;
}
input.nutbutton:hover {
   transform: rotate(360deg);
   background-color: #eec958;
   color: black;
}
</style>
</head>

<body>
	<!-- nenmoseacrch -->
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
	<!-- style-product -->
	<div class="product-single-one">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="product-single-one-img">
				<c:forEach items="${sp.listHinhAnh}" var="p" begin="0" end="0">
					<img src="${rootpath}public/img/${p.name}" class="x-zoom" xoriginal="${rootpath}public/img/${p.name}">
				</c:forEach>	
					</div>
				<div class="product-img-zoom">
					<c:forEach items="${sp.listHinhAnh}" var="p" begin="0" end="0">
						<div class="product-img-zoom-one"><a href="${rootpath}public/img/${p.name}"><img class="xzoom-smale" src="${rootpath}public/img/${p.name}"></a></div>
					</c:forEach>
					<c:forEach items="${sp.listHinhAnh}" var="p" begin="1" end="1">
					    <div class="product-img-zoom-one"><a href="${rootpath}public/img/${p.name}"><img class="xzoom-smale" src="${rootpath}public/img/${p.name}"></a></div>
					</c:forEach>
					<c:forEach items="${sp.listHinhAnh}" var="p" begin="2" end="2">
                        <div class="product-img-zoom-one"><a href="${rootpath}public/img/${p.name}"><img class="xzoom-smale" src="${rootpath}public/img/${p.name}"></a></div>
                    </c:forEach>
                    <c:forEach items="${sp.listHinhAnh}" var="p" begin="3" end="3">
                        <div class="product-img-zoom-one"><a href="${rootpath}public/img/${p.name}"><img class="xzoom-smale" src="${rootpath}public/img/${p.name}"></a></div>
					</c:forEach>
				</div>
				</div>
				<div class="col-lg-8">
					<div class="product-single-one-text">
						<div class="modal-product-single-one">
							<h3>${sp.name}</h3>
							<div class="review-star">
								<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
								<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
								<i class="fa-solid fa-star"></i> <span>(2 Customer
									Review, <b>View: ${sp.sp_view}</b>)
								</span>
							</div>
							<h4>
								<fmt:formatNumber value="${sp.price_new}" type="currency"/>
								<del><fmt:formatNumber value="${sp.price_old}" type="currency"/></del>
							</h4>
							<b>Nội dung:</b>
							<p>${sp.descripe}</p>
							<b>Mô tả sản phẩm:</b>
							  ${sp.information}
							<form action="${rootpath}thanh-toan-gio" method="get">
								<div class="size">
									<select name="product" class="customers">
										<c:forEach items="${lsize}" var="lsz">
											<option value="${lsz.name}">${lsz.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="color">
									<span>Color</span>
									<div class="chon-color">
										<c:forEach items="${lms}" var="lss">
											<c:if test="${lss.id == 1}">
												<label for="color-red"> <input class="input-red"
													name="gender" type="radio" checked value="${lss.name}">
													<span class="product-cl-red"
													style="background-color: pink;"></span>
												</label>
											</c:if>
											<c:if test="${lss.id == 2}">
												<label for="color-red"> <input class="input-red"
													name="gender" type="radio" value="${lss.name}"> <span
													class="product-cl-red" style="background-color: gray;"></span>
												</label>
											</c:if>
											<c:if test="${lss.id == 3}">
												<label for="color-red"> <input class="input-red"
													name="gender" type="radio" value="${lss.name}"> <span
													class="product-cl-red" style="background-color: yellow;"></span>
												</label>
											</c:if>
										</c:forEach>
									</div>
								</div>
								<div class="tangkichthuoc">
									<div class="product-dem">
										<div class="btn-buttonone">
											<button>
												<i class="fa-solid fa-minus"></i>
											</button>
										</div>
										<input type="number" min="1" value="1" name="quantity">
										<div class="btn-buttonone">
											<button>
												<i class="fa-solid fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="link-product-area">
									<ul>
										<li class="d-inline-flex"><a href=""> <i
												class="fa-solid fa-heart"></i> Add To Wishlist
										</a></li>
										<li class="d-inline-flex"><a href=""> <i
												class="fa-solid fa-arrow-right-arrow-left"></i> Add To
												Compare
										</a></li>
									</ul>
									<div class="idsanpham">
										<input style="display: none;" type="number" value="${sp.id}"
											name="idsp">
									</div>
									<span style="color: red; text-decoration: underline;">${nl}</span>
									<br> <input class="nutbutton" type="submit"
										value="ADD TO CART">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- style-coment -->
	<div class="product-coment">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="product-coment-tab">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-home-tab"
									data-toggle="tab" href="#nav-home" role="tab"
									aria-controls="nav-home" aria-selected="true">Description</a> <a
									class="nav-item nav-link" id="nav-profile-tab"
									data-toggle="tab" href="#nav-profile" role="tab"
									aria-controls="nav-profile" aria-selected="false">Additional
									Information</a> <a class="nav-item nav-link" id="nav-contact-tab"
									data-toggle="tab" href="#nav-contact" role="tab"
									aria-controls="nav-contact" aria-selected="false">Review</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-home"
								role="tabpanel" aria-labelledby="nav-home-tab">
								<p>${sp.descripe}</p>
							</div>
							<div class="tab-pane fade" id="nav-profile" role="tabpanel"
								aria-labelledby="nav-profile-tab">
								<div class="product-aditional">${sp.information}</div>
							</div>
							<div class="tab-pane fade" id="nav-contact" role="tabpanel"
								aria-labelledby="nav-contact-tab">
								<div class="product-previews">
									<ul>
										<li class="d-flex medias">
											<div class="icon-user-coment">
												<img src="${rootpath}public/img/icon-user.png" alt="">
											</div>
											<div class="user-text">
												<div class="user-text-media-header">
													<div class="media-name">
														<h4>Do Duc Manh</h4>
														<p>5 days ago</p>
													</div>
													<div class="media-share">
														<a href="">Replay</a> <a href="">Report</a>
													</div>
												</div>
												<div class="user-text-bottom">
													<div class="user-text-bottom-star">
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
													</div>
													<p>Cras sit amet nibh libero, in gravida nulla. Nulla
														vel metus scelerisque Praesent sapien massa, convallis a
														pellentesque nec, egestas non nisi. Cras ultricies ligula
														sed magna dictum porta. Vestibulum ac diam sit amet quam
														vehicula elementum sed sit amet dui. Vivamus magna justo.
													</p>
												</div>
											</div>
										</li>
										<li class="d-flex medias">
											<div class="icon-user-coment">
												<img src="${rootpath}public/img/user2.png" alt="">
											</div>
											<div class="user-text">
												<div class="user-text-media-header">
													<div class="media-name">
														<h4>Do Duc Manh</h4>
														<p>5 days ago</p>
													</div>
													<div class="media-share">
														<a href="">Replay</a> <a href="">Report</a>
													</div>
												</div>
												<div class="user-text-bottom">
													<div class="user-text-bottom-star">
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
													</div>
													<p>Cras sit amet nibh libero, in gravida nulla. Nulla
														vel metus scelerisque Praesent sapien massa, convallis a
														pellentesque nec, egestas non nisi. Cras ultricies ligula
														sed magna dictum porta. Vestibulum ac diam sit amet quam
														vehicula elementum sed sit amet dui. Vivamus magna justo.
													</p>
												</div>
											</div>
										</li>
										<li class="d-flex medias">
											<div class="icon-user-coment">
												<img src="${rootpath}public/img/user3.png" alt="">
											</div>
											<div class="user-text">
												<div class="user-text-media-header">
													<div class="media-name">
														<h4>Do Duc Manh</h4>
														<p>5 days ago</p>
													</div>
													<div class="media-share">
														<a href="">Replay</a> <a href="">Report</a>
													</div>
												</div>
												<div class="user-text-bottom">
													<div class="user-text-bottom-star">
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
													</div>
													<p>Cras sit amet nibh libero, in gravida nulla. Nulla
														vel metus scelerisque Praesent sapien massa, convallis a
														pellentesque nec, egestas non nisi. Cras ultricies ligula
														sed magna dictum porta. Vestibulum ac diam sit amet quam
														vehicula elementum sed sit amet dui. Vivamus magna justo.
													</p>
												</div>
											</div>
										</li>
										<li class="d-flex medias">
											<div class="icon-user-coment">
												<img src="${rootpath}public/img/icon-user.png" alt="">
											</div>
											<div class="user-text">
												<div class="user-text-media-header">
													<div class="media-name">
														<h4>Do Duc Manh</h4>
														<p>5 days ago</p>
													</div>
													<div class="media-share">
														<a href="">Replay</a> <a href="">Report</a>
													</div>
												</div>
												<div class="user-text-bottom">
													<div class="user-text-bottom-star">
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
														<span><a href=""><i class="fa-solid fa-star"></i></a></span>
													</div>
													<p>Cras sit amet nibh libero, in gravida nulla. Nulla
														vel metus scelerisque Praesent sapien massa, convallis a
														pellentesque nec, egestas non nisi. Cras ultricies ligula
														sed magna dictum porta. Vestibulum ac diam sit amet quam
														vehicula elementum sed sit amet dui. Vivamus magna justo.
													</p>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="to-day-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="center-heading">
						<h2>
							<fmt:message key="sale" />
						</h2>
					</div>
				</div>
			</div>
			<div class="product-two">
				<div class="row">
					<div class="owl-carousel owl-theme" id="manhca">
						<c:forEach items="${lspmt}" var="spct" begin="0" end="7">
							<div class="col-lg-3 col-md-4 col-sm-6 col-12">
								<div class="hot-product-img-one item">
									<div class="thump">
										<span> Mã: <b>${spct.id}</b></span>
										<div class="image-zoom">
										<c:forEach items="${spct.listHinhAnh}" var="p" begin="0" end="0">
											<img src="${rootpath}public/img/${p.name}" alt=""> 
										</c:forEach>
										<c:forEach items="${spct.listHinhAnh}" var="p" begin="1" end="1">
											<img class="zooom-product"src="${rootpath}public/img/${p.name}" >
									    </c:forEach>
										</div>
										<div class="icon-hot-product">
											<a href=""><i class="fa-regular fa-heart"></i></a> <a
												class="open-quick" href=""><i class="fa-solid fa-expand"></i></a>
											<a href=""><i class="fa-solid fa-arrow-right-arrow-left"></i></a>
										</div>
										<form action="${roopath}ao-nu/${spct.id}" method="get">
											<button>View Product Detail</button>
										</form>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="instagram">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="center-heading text-center">
						<h2>
							<fmt:message key="instagram" />
						</h2>
						<p>
							<fmt:message key="thank" />
							<span><i class="fa-solid fa-heart"></i></span>
						</p>
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
	<script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
	<script src="${rootpath}public/plugin/cloundzoom/jquery.js"></script>
	<script src="${rootpath}public/plugin/cloundzoom/zoom.js"></script>
	<script src="${rootpath}public/plugin/cloundzoom/script.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="${rootpath}public/plugin/dist/owl.carousel.min.js"></script>
	<script src="${rootpath}public/js/sanphamdetail.js"></script>
</body>

</html>