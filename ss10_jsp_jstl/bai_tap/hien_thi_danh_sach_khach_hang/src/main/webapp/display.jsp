<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/04/2022
  Time: 9:07 SA
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div>
<table class="table">
    <tr>
        <th scope="col">Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">DỊa Chỉ</th>
        <th scope="col">Thông Tin</th>
    </tr>
    <c:forEach var="customer" items="${khachHang}">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDayOfBirth()}</td>
            <td>${customer.getAddress()}</td>
            <td><img style="width: 80px; height: 70px" src="${customer.getImg()}" alt=""></td>
        </tr>
    </c:forEach>

</table>
</div>

</body>
</html>
