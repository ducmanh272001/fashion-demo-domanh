<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						// Lấy thẻ div có id "okla"
						var divElement = document.getElementById("okla");

						// Định nghĩa thời gian bắt đầu và thời gian kết thúc
						var startTime = new Date().getTime();
						var endTime = startTime + 30 * 1000; // 30 giây (30 * 1000 milliseconds)

						// Cập nhật thời gian còn lại và hiển thị thông báo khi đếm ngược kết thúc
						var countdown = setInterval(
								function() {
									var now = new Date().getTime();
									var timeLeft = endTime - now;

									// Tính toán phút và giây còn lại
									var seconds = Math
											.floor((timeLeft % (1000 * 60)) / 1000);

									if (timeLeft <= 0) {
										// Đếm ngược kết thúc, hiển thị thông báo "OK"
										clearInterval(countdown);
										divElement.innerHTML = "Vui lòng lấy lại mã";
										document.getElementById("resendButton").style.display = "block";
										
									} else {
										// Cập nhật thời gian còn lại
										divElement.innerHTML = seconds + "s";
									}
								}, 1000); // Cập nhật mỗi giây (1000 milliseconds)


						var errorCode = "${errorCode}";
						if (errorCode === "Mã hết hạn") {
							var resendButton = document
									.getElementById("resendButton");
							resendButton.style.display = "block";
							
							var oklaElement = document.getElementById("okla");
						    oklaElement.style.display = "none";
						}

						var resendButton = document
								.getElementById('resendButton');
						var myForm = document.getElementById('myForm');

						resendButton.addEventListener('click', function() {
							myForm.setAttribute('action', '${rootpath}confirm/send/code');
						    myForm.setAttribute('method', 'post');
						    myForm.submit();
						});
					});
</script>
<stag:url value="/" var="rootpath" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
.login-page {
	text-align: center;
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 9px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

.error {
	color: red;
	font-size: 9px;
	font-weight: bold;
	text-transform: uppercase;
	text-align: center;
	text-decoration: underline;
	display: flex;
	justify-content: center;
}

.success {
	color: green;
	font-size: 10px;
	font-weight: bold;;
	text-transform: uppercase;
}
</style>
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${rootpath}public/plugin/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
	<div class="login-page">
		<div class="form" style="border-radius: 40px;">
			<div class="error" style="display: flex;">
				<a style="">${errorCode}</a>
			</div>
			<div style="display: flex;">
				<h1>Nhập mã xác thực của bạn</h1>
			</div>
			<div>
				<p id="okla" style="color: red;"></p>
			</div>
			<sform:form cssStyle="margin-top: 10px" id="myForm"
				action="${rootpath}forget/confirm-success" method="post"
				class="login-form" modelAttribute="entity">
				<sform:input cssStyle="display: none" path="id" type="number"
					placeholder="Nhập mã xác thực của bạn" />
				<sform:input path="passwordGenerated" type="text"
					placeholder="Nhập mã xác thực của bạn" />
				<sform:errors path="passwordGenerated" class="error" />
				<div
					style="display: flex; gap: 10px; justify-content: space-between;">
					<button id="confirmButton">Xác nhận</button>
					<button id="resendButton" style="display: none;">Gửi lại</button>
				</div>
			</sform:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script
		src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="${rootpath}public/plugin/dist/owl.carousel.min.js"></script>
</body>
</html>