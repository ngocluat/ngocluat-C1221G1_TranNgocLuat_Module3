<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/04/2022
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>tên sản phẩm : </td>
                <td>${product.tenSanPham}</td>
            </tr>
            <tr>
                <td>mô tả : </td>
                <td>${product.moTa}</td>
            </tr>
            <tr>
                <td>giá : </td>
                <td>${product.gia}</td>
            </tr>
            <tr>
                <td><a href="/product">Back to customer list</a></td>
            </tr>

            <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                delete
            </button>
        </table>
    </fieldset>
</form>
</body>
</html>
