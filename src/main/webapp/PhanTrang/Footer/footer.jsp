<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags" %>

<stag:url value="/" var="rootpath"/>
<fmt:setLocale value="${lag}"/>
<fmt:setBundle basename="language.mess_lag"/>
  <!-- Footer -->
  <div class="footer-big">
    <footer class="footer-one">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-12 col-sm-12 col-12">
                    <div class="footer-one-widget">
                        <a href=""><img src="${rootpath}public/img/logo.png" alt=""></a>
                        <p>
                          <fmt:message key="ketnoi"/>
                        </p>
                        <div class="footer-icon">
                            <ul>
                                <li><a href=""><i class="fa-brands fa-facebook-f"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-twitter"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-linkedin"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-instagram"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-google-plus-g"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="footer-one-widget">
                        <h3><fmt:message key="thongtin"/></h3>
                        <ul>
                            <li><a href=""><fmt:message key="mainmenu"/></a></li>
                            <li><a href=""><fmt:message key="about"/></a></li>
                            <li><a href=""><fmt:message key="brandok"/></a></li>
                            <li><a href=""><fmt:message key="chinhsach"/></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 col-sm-12 col-12">
                    <div class="footer-one-widget">
                        <h3><fmt:message key="hotro"/></h3>
                        <ul>
                            <li><a href=""><fmt:message key="giaohang"/></a></li>
                            <li><a href=""><fmt:message key="hd"/></a></li>
                            <li><a href=""><fmt:message key="hd1"/></a></li>
                            <li><a href=""><fmt:message key="hd2"/></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="footer-one-widget">
                        <h3><fmt:message key="dk"/></h3>
                        <div class="subscribe-form">
                            <form action="">
                                <div class="mc-form">
                                    <input type="email" class="form-control" placeholder="Your Mail*" name="EMAIL">
                                </div>
                                <div class="clear">
                                    <button>
                                       <fmt:message key="dk2"/>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- coppy-right-one -->
    <div class="coppy-right-one">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="coppy-left">
                        <h6>
                            © CopyRight 2022
                            <span>AndShop</span>
                        </h6>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="coppy-right">
                        <img src="${rootpath}public/img/payment.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
   </div>