<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/04/2022
  Time: 4:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h1>Customers</h1>
<p>
    <a href="/product?action=hien-thi">Create new customer</a>
</p>
<table border="1" class="table table-striped">
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">mô tả</th>
        <th scope="col">giá</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach var="item" items="${product}">
    <tr>
        <td>${item.id},${item.tenSanPham}</td>
        <td>${item.mota}</td>
        <td>${item.gia}</td>
        <td>${item.getId()}>edit</td>
        <td>${item.getId()}>delete</td>
    </tr>
    </c:forEach>

</body>
</html>
