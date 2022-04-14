<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/04/2022
  Time: 8:53 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <welcome-file-list>
        <welcome-file>welcome.html</welcome-file>
    </welcome-file-list>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customer?actionTest=create">Create new customer</a>
</p>
<table border="1"  class="table table-striped">
    <tr>
        <th  scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach var="item" items="${customer}">
        <tr>
            <td>${item.id},${item.name}</td>
            <td>${item.mail}</td>
            <td>${item.address}</td>
            <td>${item.getId()}>edit</td>
            <td>${item.getId()}>delete</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>