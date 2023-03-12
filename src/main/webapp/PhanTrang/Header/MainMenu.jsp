<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<stag:url value="/" var="rootpath"/>
<fmt:setLocale value="${lag}"/>
<fmt:setBundle basename="language.mess_lag"/>
  <!-- Main Menu -->
  <div class="main-menu-ok">
    <div class="top-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-sm-12 col-12">
                    <ul class="top-header-contact">
                        <li>
                            <i class="fa-solid fa-phone-volume"></i>
                            <a href="">(+123) 456-7898</a>
                        </li>
                        <li>
                            <i class="fa-solid fa-street-view"></i>
                            <a href="">6890, The Bronx, NY 1058, USA</a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6 col-md-5 col-sm-12 col-12">
                    <nav class="navbar navbar-expand-sm top-header-menu">
                        <ul class="navbar-nav mr-auto mt-2 mt-lg-0 styleli">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"><fmt:message key="ngonngu"/>
                                    <span><i class="fa-solid fa-language"></i></span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="dropdownId">
                                    <a class="dropdown-item" href="${rootpath}?lag=vi_VN">
                                        Vietnamese
                                    </a>
                                     <a class="dropdown-item" href="${rootpath}?lag=en_US">
                                        English
                                    </a>
                                    <a class="dropdown-item" href="${rootpath}?lag=ko_KR">
                                        Korean
                                    </a>
                                    <a class="dropdown-item" href="${rootpath}?lag=lo_LA">
                                       Lào
                                    </a>
                                    <a class="dropdown-item" href="${rootpath}?lag=ja_JP">
                                        Japan
                                    </a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"><fmt:message key="admin"/></a>
                                <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <c:if test="${urid == 2}">
                                    <a class="dropdown-item" href="#">User</a>
                                </c:if>
                                <c:if test="${urid == 1}">
                                    <a class="dropdown-item" href="#">Admin</a>
                                </c:if>
                                <c:if test="${urid == 3}">
                                    <a class="dropdown-item" href="#">Editor</a>
                                </c:if>
                                </div>
                            </li>
                            <c:if test="${sessionScope.acc == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="${rootpath}dang-nhap"><fmt:message key="login"/></a>
                            </li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item" style="display: flex;">
                                <span>Xin chào: </span><b>${sessionScope.acc.fullName}</b>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${rootpath}log-out">Logout</a>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- nav-bar -->
    <div class="nav-area">
        <div class="drodo-nav">
            <div class="container">
                <nav class="navbar navbar-expand-md navbar-light">
                    <a class="navbar-brand" href="${rootpath}">
                        <img src="${rootpath}public/img/logo.png" alt="">
                    </a>
                    <!-- thanhmenu -->
                    <div class="barsindex">
                        <ul>
                            <li><a class="openbars" href=""><i class="fa-solid fa-bars"></i></a></li>
                            <li><a class="closebars" href=""><i class="fa-solid fa-x"></i></a></li>
                        </ul>
                    </div>
                    <div class="collapse navbar-collapse mean-menu" style="display: block">
                        <ul class="navbar-nav maindm">
                            <li class="nav-item">
                                <a href="${rootpath}"><fmt:message key="mainmenu"/></a>
                            </li>
                            <li class="nav-item">
                                <div class="dropdown">
                                 <form action="${rootpath}product/all" method="get">
                                    <button class="dropbtn"><fmt:message key="product"/><i class="fa-solid fa-chevron-down"></i></button>
                                  </form>
                                    <div class="dropdown-content">
                                        <a href="${rootpath}product/ao"><fmt:message key="shirt"/></a>
                                        <a href="${rootpath}product/all-dam"><fmt:message key="dress"/></a>
                                        <a href="${rootpath}product/all-quan"><fmt:message key="trousers"/></a>
                                        <a href="${rootpath}product/all-ca-bo"><fmt:message key="set"/></a>
                                        <a href="${rootpath}product/all-ao-dai"><fmt:message key="aodai"/></a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a href="about.html"><fmt:message key="about"/></a>
                            </li>
                            <li class="nav-item">
                                <div class="dropdown">
                                    <button class="dropbtn"><fmt:message key="pages"/><i class="fa-solid fa-chevron-down"></i></button>
                                    <div class="dropdown-content">
                                        <a href="${rootpath}chi-tiet-don-hang"><fmt:message key="history"/></a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a href="about.html"><fmt:message key="contacts"/></a>
                            </li>
                        </ul>
                    </div>
                    <!-- icon -->
                    <div class="icon-index">
                        <div class="opition-item">
                            <div class="wishlist-btn">
                                <a href="${rootpath}thanh-toan-tc">
                         <i class="fa-solid fa-cart-shopping"></i>
                          <span>${sessionScope.dem}</span>
                                </a>
                            </div>
                        </div>
                        <div class="opition-item">
                            <div class="card-btn">
                                <a href="#">
                                <i class="fa-regular fa-heart"></i>
                                </a>
                            </div>
                        </div>
                        <div class="opition-item">
                            <div class="search-btn">
                                <a href="">
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
  </div>