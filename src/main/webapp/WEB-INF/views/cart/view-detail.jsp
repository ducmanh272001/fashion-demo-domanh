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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<style type="text/css">
.table-borderless table td {
	text-align: center;
	border: 1px solid gray;
}

.table-borderless table tr {
	border: 1px solid gray;
}

.oder-detail {
	padding: 18px;
	padding-bottom: 40px;
}

.bangoder table th {
	text-align: center;
}

thead {
	background: #dddcdc;
}
</style>
</head>
<body>
	<jsp:include page="/PhanTrang/Header/MainMenu.jsp"></jsp:include>
	<div class="oder-detail">
		<div class="container mt-5">
			<div class="d-flex justify-content-center row">
				<div class="col-md-10">
					<div class="rounded">
						<div class="table-responsive table-borderless">
							<table class="table">
								<thead>
									<tr>
										<th class="text-center">Tên Sản Phẩm</th>
										<th>Màu sắc</th>
										<th>Kích cỡ</th>
										<th>Số lượng</th>
										<th>Giá tiền</th>
										<th>Tổng tiền</th>
									</tr>
								</thead>
								<tbody class="table-body">
									<c:forEach items="${list}" var="l">
										<tr class="cell-1">
											<td>${l.id_sp.sanpham_name}</td>
											<td>${l.id_sp.mausac_name}</td>
											<td>${l.id_sp.kichco_name}</td>
											<td>${l.quantity}</td>
											<td><fmt:formatNumber value="${l.price}" type="currency" /></td>
											<td><fmt:formatNumber value="${l.price * l.quantity}"
													type="currency" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/PhanTrang/Footer/footer.jsp"></jsp:include>
</body>
</html>