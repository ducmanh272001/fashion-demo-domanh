<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="stag" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<stag:url value="/" var="rootpath"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
   <h1>Sửa sản phẩm</h1>
   <hr>
   <c:if test="${tb.macode == 1}">
   <span style="color: green;text-decoration: underline;font-size: 20px">${tb.text}</span>
   </c:if>
   <c:if test="${tb.macode == 0}">
   <span style="color: red;text-decoration: underline;font-size: 20px">${tb.text}</span>
   </c:if>
   <br>
   <span style="color: red;text-decoration: underline;font-size: 20px">${tb2}</span>
   <sform:form action="${rootpath}update-success" modelAttribute="spct" method="post" enctype="multipart/form-data">
         <table border="1">
             <tr>
		       <th>ID là: </th>
		       <td>
		         <sform:input type="number" path="id" readonly="true"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập NAME: </th>
		       <td>
		         <sform:input type="text" path="name" placeholder="Nhập tên sản phẩm..." maxlength="50"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập DESCRIPE:</th>
		       <td>
		       <sform:input type="text" path="descripe"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập INFORMATION: </th>
		       <td>
		       <sform:input type="text" path="information"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập PRICE_IMPORT: </th>
		       <td>
		       <sform:input type="text" path="price_import"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập PRICE_OLD: </th>
		       <td>
		       <sform:input type="number" path="price_old"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập PRICE_NEW: </th>
		       <td>
		       <sform:input type="number" path="price_new"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập SP_VIEW: </th>
		       <td>
		       <sform:input type="number" path="sp_view" step="1"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập UPDATE_DAY: </th>
		       <td>
		       <sform:input type="date" path="day_update"/>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập STATUS: </th>
		       <td>
		       <sform:radiobutton path="status" value="true"/>Đang hiển thị
		       <sform:radiobutton path="status" value="false"/>Đang ẩn
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập IDTYPE:</th>
		       <td>
		        <sform:select path="idtheloai">
		           <sform:options items="${lsp}" itemValue="id" itemLabel="loai_sp"/>
		        </sform:select>
		       </td>
		     </tr>
		     <tr>
		       <th>Nhập IDNH</th>
		       <td>
		       <sform:select path="idnhanhieu">
		          <sform:options items="${list}" itemValue="id" itemLabel="name_brand"/>
		       </sform:select>
		       </td>
		     </tr>
		     <tr>
		       <th>Chọn ảnh</th>
		       <td>
		        <input type="file" name="uploadFile" required="required">
		       </td>
		     </tr>
		     <tr>
		      <td>
                 <input type="reset" value="Làm lại">
		      </td>
		      <td>
		      	 <input type="submit" value="Sửa sản phẩm">
		      </td>
		     </tr>
		   </table>
   </sform:form>
</div>
<hr>
<a href="${rootpath}ql-san-pham">Trở về</a>
</body>
</html>