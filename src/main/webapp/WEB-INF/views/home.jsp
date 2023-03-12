<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath"/>
<fmt:setLocale value="${lag}"/>
<fmt:setBundle basename="language.mess_lag"/>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${rootpath}public/css/user.css">
    <link rel="stylesheet" href="${rootpath}public/plugin/dist/assets/owl.theme.default.min.css">
    <link rel="stylesheet" href="${rootpath}public/plugin/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
    <!-- nenmoseacrch -->
    <div class="nenmosearch">
        <span>&times;</span>
        <div class="search-mo">
         <form action="${rootpath}ket-qua-tim-kiem" method="get">
            <input value="${ten}" type="text" placeholder="Search here" name="name">
            <button><i class="fa-solid fa-magnifying-glass"></i></button>
         </form>
        </div>
    </div>
    <!-- cart -->
    <div class="cart-max">
        <div class="cart-small">
            <div class="cart-small-content">
                <button><span>&times;</span></button>
                <div class="cart-small-body">
                    <h3 class="h31">My Cart (3)</h3>
                    <div class="products-cart-content">
                        <div class="products-cart">
                            <div class="products-cart-img">
                                <a href=""><img src="${rootpath}public/img/product14.png" alt=""></a>
                            </div>
                            <div class="products-cart-content">
                                <h3><a href="">Coronavirus Face Mask</a></h3>
                                <div class="products-cart-price">
                                    <span>1</span>
                                    <span>x</span>
                                    <span>80.000đ</span>
                                </div>
                            </div>
                            <a class="delete-produt" href=""><i class="fa-solid fa-trash-can"></i></a>
                        </div>
                        <div class="products-cart">
                            <div class="products-cart-img">
                                <a href=""><img src="${rootpath}public/img/product10.png" alt=""></a>
                            </div>
                            <div class="products-cart-content">
                                <h3><a href="">Coronavirus Face Mask</a></h3>
                                <div class="products-cart-price">
                                    <span>1</span>
                                    <span>x</span>
                                    <span>80.000đ</span>
                                </div>
                            </div>
                            <a class="delete-produt" href=""><i class="fa-solid fa-trash-can"></i></a>
                        </div>
                        <div class="products-cart">
                            <div class="products-cart-img">
                                <a href=""><img src="${rootpath}public/img/product12.png" alt=""></a>
                            </div>
                            <div class="products-cart-content">
                                <h3><a href="">Coronavirus Face Mask</a></h3>
                                <div class="products-cart-price">
                                    <span>1</span>
                                    <span>x</span>
                                    <span>80.000đ</span>
                                </div>
                            </div>
                            <a class="delete-produt" href=""><i class="fa-solid fa-trash-can"></i></a>
                        </div>
                    </div>
                    <div class="products-cart-subtotal">
                        <span>subtotal</span>
                        <span>$228.000</span>
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
            <button id="closequick"><i class="fa-solid fa-xmark"></i></button>
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
                                        <img src="${rootpath}public/img/product-20.png" alt="First slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${rootpath}public/img/product-moi3.png" alt="Second slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${rootpath}public/img/product-20.png" alt="Third slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${rootpath}public/img/product-moi3.png" alt="Second slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${rootpath}public/img/product-moi3.png" alt="Second slide">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-6 col-sm-12 col-12">
                        <div class="modal-quick-view-text">
                            <h3>Black fashion handbag JI9023</h3>
                            <div class="review-ratting">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <span>(2 Customer Review)</span>
                            </div>
                            <h4>$317.76</h4>
                            <p>
                                Standard dummy text ever since the 1500s, when an unknown printer took a galley of
                                type and scrambled it to make a type specimen.
                            </p>
                            <div class="color">
                                <span>Color</span>
                                <div class="chon-color">
                                 <label for="color-red">
                                     <input class="input-red" name="gender" type="radio" checked>
                                     <span class="product-cl-red"></span>
                                 </label>
                                 <label for="color-red">
                                      <input class="input-red" name="gender" type="radio">
                                      <span class="product-cl-red"></span>
                                 </label>
                                 <label for="color-red">
                                      <input class="input-red" name="gender" type="radio">
                                      <span class="product-cl-red"></span>
                                 </label>
                                </div>
                         </div>
                            <form class="form-quickview" action="">
                                <div class="product-dem">
                                    <div class="btn-buttonone">
                                         <button>
                                            <i class="fa-solid fa-minus"></i>
                                         </button>
                                    </div>
                                    <input type="number" value="0" name="quantity">
                                    <div class="btn-buttonone">
                                        <button>
                                            <i class="fa-solid fa-plus"></i>
                                         </button>
                                    </div>
                                </div>
                                <div class="product-count-one">
                                    <a href="${roopath}cart">View product details</a>
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
    <!-- banner -->
    <div class="banner-index">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="banner-index-text">
                        <h1>
                            <fmt:message key="banner"/>
                            <span><fmt:message key="banner2"/></span>
                        </h1>
                        <h3>
                           <fmt:message key="banner3"/>
                        </h3>
                        <a href="">
                            <fmt:message key="banner4"/>
                        </a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="banner-index-img">
                        <img src="${rootpath}public/img/man.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="product-one">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 product-ones">
                    <div class="product-one-boxed">
                        <img src="${rootpath}public/img/duyen-dang-den-cong-so-cung-vaydam-voan.webp" alt="" width="100%">               
                    </div>
                    <div class="product-one-boxed">
                        <img src="${rootpath}public/img/banner nho 2.png" alt="" width="100%">
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 product-ones">
                    <div class="product-one-boxed">
                        <img style="height: 433px" src="${rootpath}public/img/ZT180049GN-1.jpg" alt="" width="100%">                 
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 product-ones">
                    <div class="product-one-boxed">
                        <img src="${rootpath}public/img/banner nho 1_2.png" alt="" width="100%">
                    </div>
                    <div class="product-one-boxed">
                        <img src="${rootpath}public/img/banner2a.jpg" alt="" width="100%">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="hot-product col-lg-12">
            <h2><fmt:message key="newsp"/></h2>
            <p><fmt:message key="hottrend"/></p>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
               <li class="nav-item">
                    <a class="nav-link" href="${rootpath}"  aria-selected="false"><fmt:message key="all"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${rootpath}product/ban-chay/dam"  aria-selected="false"><fmt:message key="dress"/></a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="${rootpath}product/ban-chay/ca-bo"  aria-selected="false"><fmt:message key="set"/></a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="${rootpath}product/ban-chay/ao-dai"  aria-selected="false"><fmt:message key="aodai"/></a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="${rootpath}product/ban-chay/quan"  aria-selected="false"><fmt:message key="trousers"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${rootpath}product/ban-chay/ao"  aria-selected="false"><fmt:message key="shirt"/></a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="newarrival" role="tabpanel" aria-labelledby="home-tab">
                 <div class="row">
                        <div class="col-lg-12">
                            <div class="container">
                                <div class="hot-product-img">
                                    <div class="row">
                                    <c:forEach items="${lst}" var="l" begin="0" end="7">
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one sanphamoi">
                                                <div class="thump">
                                                    <span>Mã <b>${l.id}</b></span>
                                                    <div class="image-zoom">
                                                    <c:forEach items="${l.listHinhAnh}" var="p" begin="1" end="1">
                                                        <img src="${rootpath}public/img/${p.name}" alt="">
                                                     </c:forEach>
                                                     <c:forEach items="${l.listHinhAnh}" var="p" begin="2" end="2">
                                                        <img class="zooom-product" src="${rootpath}public/img/${p.name}" alt="">
                                                     </c:forEach>
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a class="open-quick" href=""><i
                                                                class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <form action="${roopath}ao-nu/${l.id}" method="get">
                                                      <button>View Product Detail</button>
                                                    </form>
                                                </div>
                                                <div class="content">
                                                    <a href="${rootpath}ao-nu/${l.id}">${l.name}</a>
                                                    <p><fmt:formatNumber value="${l.price_new}" type="currency"/></p>
                                                </div>
                                            </div>
                                        </div>
                                     </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="trendding" role="tabpanel" aria-labelledby="profile-tab">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="container">
                                <div class="hot-product-img">
                                     <div class="row">
                                    <c:forEach items="${listdam}" var="ld">
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one sanphamoi">
                                                <div class="thump">
                                                    <span>Mã <b>${ld.id}</b></span>
                                                    <div class="image-zoom">
                                                    <c:forEach items="${ld.listHinhAnh}" var="p" begin="1" end="1"> 
                                                        <img src="${rootpath}public/img/${p.name}" alt="">
                                                     </c:forEach>
                                                     <c:forEach items="${ld.listHinhAnh}" var="p" begin="2" end="2">              
                                                        <img class="zooom-product" src="${rootpath}public/img/${p.name}" alt="">
                                                      </c:forEach>
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a class="open-quick" href=""><i
                                                                class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <form action="${roopath}ao-nu/${ld.id}" method="get">
                                                      <button>View Product Detail</button>
                                                    </form>
                                                </div>
                                                <div class="content">
                                                    <a href="${rootpath}ao-nu/${ld.id}">${ld.name}</a>
                                                    <p><fmt:formatNumber value="${ld.price_new}" type="currency"/></p>
                                                </div>
                                            </div>
                                        </div>
                                     </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="seller" role="tabpanel" aria-labelledby="contact-tab">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="container">
                                <div class="hot-product-img">
                                    <div class="row">
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product10.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product4.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product12.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product14.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product14.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product6.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product18.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product10.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="featured" role="tabpanel" aria-labelledby="contact-tab">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="container">
                                <div class="hot-product-img">
                                    <div class="row">
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product2.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product6.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product4.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product8.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product10.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product4.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product12.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product14.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="onsall" role="tabpanel" aria-labelledby="contact-tab">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="container">
                                <div class="hot-product-img">
                                    <div class="row">
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product2.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product6.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                            <div class="hot-product-img-one">
                                                <div class="thump">
                                                    <span>New</span>
                                                    <div class="image-zoom">
                                                        <img src="${rootpath}public/img/product4.png" alt="">
                                                        <img class="zooom-product" src="${rootpath}public/img/product8.png" alt="">
                                                    </div>
                                                    <div class="icon-hot-product">
                                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                                        <a href=""><i class="fa-solid fa-expand"></i></a>
                                                        <a href=""><i
                                                                class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                                    </div>
                                                    <button>add to cart</button>
                                                </div>
                                                <div class="content">
                                                    <a href="">Blur dress for woman</a>
                                                    <p>$38.50</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </ul>
        </div>
    </div>
    <div class="offer_timer_one">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-12">
                </div>
                <div class="col-lg-8 col-md-4 col-sm-12 col-12">
                    <div class="offer-time">
                        <div class="clock">
                            <ul>
                                <li>
                                    <span id="day"></span>
                                    <p>days</p>
                                </li>
                                <li>
                                    <span id="hours"></span>
                                    <p>hours</p>
                                </li>
                                <li>
                                    <span id="minutes"></span>
                                    <p>minutes</p>
                                </li>
                                <li>
                                    <span id="seconds"></span>
                                    <p>Seconds</p>
                                </li>
                            </ul>
                        </div>
                        <div class="offer-time-text">
                            <h2><fmt:message key="khuyenmai"/></h2>
                            <p>
                              <fmt:message key="khuyenmai1"/>
                            </p>
                            <a href=""><fmt:message key="xemthem"/> </a>
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
                         <fmt:message key="sale"/>
                        </h2>
                    </div>
                </div>
            </div>
            <div class="product-two">
                <div class="row">
                    <div class="owl-carousel owl-theme" id="manhca">
                    <c:forEach items="${lspmt}" var="sp" begin="1" end="8">
                        <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                            <div class="hot-product-img-one item">
                                <div class="thump">
                                    <span> Mã: <b>${sp.id}</b></span>
                                    <div class="image-zoom">
                                    <c:forEach items="${sp.listHinhAnh}" var="p" begin="1" end="1">
                                        <img src="${rootpath}public/img/${p.name}" alt="">
                                    </c:forEach>
                                    <c:forEach items="${sp.listHinhAnh}" var="p" begin="2" end="2">
                                        <img class="zooom-product" src="${rootpath}public/img/${p.name}" alt="">
                                     </c:forEach>
                                    </div>
                                    <div class="icon-hot-product">
                                        <a href=""><i class="fa-regular fa-heart"></i></a>
                                        <a class="open-quick" href=""><i class="fa-solid fa-expand"></i></a>
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
    <div class="special_offer_one">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 offset-lg-4 col-md-12 col-sm-12 col-12">
                    <div class="banner-one text-center">
                        <h2>
                         <fmt:message key="trending"/>
                        </h2>
                        <p><fmt:message key="tieude"/>
                        </p>
                        <a href="">
                         <fmt:message key="banner4"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="blog-area-one">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="center-heading text-center">
                        <h2>
                          <fmt:message key="tintuc"/>
                        </h2>
                    </div>
                </div>
            </div>
            <div class="row">
             <c:forEach items="${ltintuc}" var="o">
                <div class="col-lg-4 col-md-4 col-sm-6 col-12">
                    <div class="khoi">
                        <div class="blog-one-zoom wow bounceInUp" data-wow-delay="0.2s">
                            <div class="blog-one-img">
                                <!-- dẫn đến link -->
                                <a href="${rootpath}xem-tin-tuc/${o.id}">
                                    <img src="${rootpath}public/img/${o.img}" alt="">
                                </a>
                            </div>
                            <div class="blog-one-text">
                                <!-- dẫn đến link -->
                                <h5><a href="">
                                  <fmt:formatDate value="${o.day_tin}" dateStyle="short" />
                                </a></h5>
                                <h4>
                                    <a href="${rootpath}xem-tin-tuc/${o.id}">
                                        ${o.descripe}
                                    </a>
                                </h4>
                                <a href="${rootpath}xem-tin-tuc/${o.id}" class="button">
                                    <fmt:message key="doc"/>
                                    <i class="fa-solid fa-arrow-right"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>   
              </c:forEach> 
            </div>
        </div>
    </div>
    <div class="instagram">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="center-heading text-center">
                        <h2><fmt:message key="instagram"/></h2>
                        <p><fmt:message key="thank"/><span><i class="fa-solid fa-heart"></i></span></p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="card-group">
                        <div class="owl-carousel owl-theme" id="cardxoay">
                            <div class="item">
                                <div class="card">
                                    <a href="">
                                        <span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post11.png" alt="Card image cap">
                                    </a>
                                </div>
                            </div>
                            <div class="item">
                                <div class="card">
                                    <a href="">
                                        <span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post10.png" alt="Card image cap">
                                    </a>
                                </div>
                            </div>
                            <div class="item">
                                <div class="card">
                                    <a href=""><span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post12.png" alt="Card image cap"></a>
                                </div>
                            </div>
                            <div class="item">
                                <div class="card">
                                    <a href="">
                                        <span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post6.png" alt="Card image cap">
                                    </a>
                                </div>
                            </div>
                            <div class="item">
                                <div class="card">
                                    <a href="">
                                        <span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post8.png" alt="Card image cap">
                                    </a>
                                </div>
                            </div>
                            <div class="item">
                                <div class="card">
                                    <a href="">
                                        <span><i class="fa-brands fa-instagram"></i></span>
                                        <img class="card-img-top" src="${rootpath}public/img/post9.png" alt="Card image cap">
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
    <script src="${rootpath}public/plugin/wow.min.js"></script>
    <script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${rootpath}public/plugin/dist/owl.carousel.min.js"></script>
    <script type="text/javascript" src="${rootpath}public/js/jquery.js"></script>
</body>

</html>