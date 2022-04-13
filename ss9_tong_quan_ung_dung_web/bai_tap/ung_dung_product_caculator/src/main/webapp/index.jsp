<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/04/2022
  Time: 3:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>$Title$</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style>
    .tuy-chinh{
      width: 50%;
      height: 50%;
      border: black;
      text-align: center;
    }
  </style>

</head>
<body>
<div class="tuy-chinh">
<form method="post" action="percent">
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text">productDescription</span>
    </div>
    <input type="text" class="form-control" name="Description"  placeholder="Mô tả của sản phẩm" aria-label="Username" aria-describedby="basic-addon1">
  </div>
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" >listPrice</span>
    </div>
    <input type="text" class="form-control" placeholder="Giá niêm yết của sản phẩm" name="price" aria-label="Username" aria-describedby="basic-addon1">
  </div>
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" >diDscountPercent</span>
    </div>
    <input type="text" class="form-control" placeholder="tỷ lệ chiết khấu %" name="discount" aria-label="Username" aria-describedby="basic-addon1">
  </div>
  <button type="submit">Calculate Discount</button>
</form>
</div>
</body>
</html>
