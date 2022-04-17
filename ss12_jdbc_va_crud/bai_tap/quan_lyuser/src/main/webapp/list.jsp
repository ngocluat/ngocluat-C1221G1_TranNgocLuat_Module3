<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/04/2022
  Time: 10:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello </h1>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>country</th>
        <th>edit</th>
        <th>xóa</th>
    </tr>
    <c:forEach var="item" items="${userlist}">
        <tr>
            <th>${item.getId()}</th>
            <th>${item.getName()}</th>
            <th>${item.getEmail()}</th>
            <th>${item.getCountry()}</th>
            <th><a href="#">edit </a></th>
            <th><a href="#"> xóa </a> </th>
        </tr>
    </c:forEach>
</table>


</body>
</html>
