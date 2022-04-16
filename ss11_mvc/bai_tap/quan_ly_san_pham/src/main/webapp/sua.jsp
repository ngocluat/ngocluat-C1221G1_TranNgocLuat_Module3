<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/04/2022
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>đã vào</h1>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/product">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>tên sản phẩm:</td>
                <td><input type="text" name="tenSanPham" id="name" value="${products.tenSanPham}"></td>
            </tr>
            <tr>
                <td>mô tả :</td>
                <td><input type="text" name="moTa" id="email" value="${products.moTa}"></td>
            </tr>
            <tr>
                <td>giá :</td>
                <td><input type="number" name="gia" id="address" value="${products.gia}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
