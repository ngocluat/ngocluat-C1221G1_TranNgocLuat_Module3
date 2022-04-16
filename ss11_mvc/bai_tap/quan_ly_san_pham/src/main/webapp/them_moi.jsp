<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/04/2022
  Time: 4:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class=" container mx-auto p-1 text-white" style="background-color: #d4b2b2; width: 50%">
<h1>Thêm mới sản phẩm  </h1>
    <h2>Product</h2>
    <form method="post">
        <div class="form-group ">
            <label>Tên sản phẩm </label>
            <div class="input-group-prepend">
            </div>
            <input class="form-control" placeholder="têm sản phẩm " type="text" name="tenSanPham">
        </div>
        <div class="form-group ">
            <label>Mô tả </label>
            <div class="input-group-prepend">
            </div>
            <input class="form-control" placeholder="mô tả sản phẩm " type="text" name="moTa">
        </div>
        <div class="form-group ">
        <label> Giá </label>
            <div class="input-group-prepend">
            </div>
            <input class="form-control" placeholder="giá của sản phẩm" type="number" name="gia">
        </div>

            <button type="submit" class="btn btn-info">Thêm mới</button>

    </form>
    <button type="button" class="btn btn-success"><a href="product?action=view">quay lại</a></button>
</div>
</body>
</html>
