<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/04/2022
  Time: 2:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello </h1>

<form>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>tên sản phẩm : </td>
                <td>${products.tenSanPham}</td>
            </tr>
            <tr>
                <td>mô tả : </td>
                <td>${products.moTa}</td>
            </tr>
            <tr>
                <td>giá : </td>
                <td>${products.gia}</td>
            </tr>
            <tr>
                <td><a href="/product">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
