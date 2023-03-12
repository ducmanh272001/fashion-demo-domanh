<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath" />
<fmt:setLocale value="${lag}"/>
<fmt:setBundle basename="language.mess_lag"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootpath}public/css/user.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<style type="text/css">
.table-borderless table td{
    text-align: center;
    border: 1px solid gray;
}
.table-borderless table tr{
    border: 1px solid gray;
}
.oder-detail {
    padding: 18px;
    padding-bottom: 40px;
}

.bangoder table th{
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
						<div class="table-responsive table-borderless bangoder">
							<table class="table">
								<thead>
									<tr>
										<th class="text-center">Mã hóa đơn</th>
										<th>Ngày bán</th>
										<th>Người nhận</th>
										<th>Địa chỉ</th>
										<th>Trạng thái</th>
										<th>Xem chi tiết</th>
									</tr>
								</thead>
								<tbody class="table-body">
									<c:forEach items="${hok}" var="h">
										<tr class="cell-1">
											<td>${h.id}</td>
											<td><fmt:formatDate value="${h.ngayban}" pattern="dd-MM-yyyy"/></td>
											<td>${h.nameKH}</td>
											<td>${h.address}</td>
											<td>${h.status ? 'Đang xử lý' : 'Đã xử lý'}</td>
											<td><a href="${rootpath}xem-chi-tiet/${h.id}">View</a></td>
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