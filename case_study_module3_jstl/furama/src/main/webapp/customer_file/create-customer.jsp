<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 18/04/2022
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        input {

        }
    </style>
</head>
<body>
<div class="mx-auto" style="width: 50%;" >
    <form action="/customer?actionCustomer=create" method="post">
        <c:if test="${message!= null}">
            <p>${message} </p>
        </c:if>

        Họ tên <input type="text" class="form-control form-control-lg is-valid" name="name" id="validationServer01" required>
        Ngày Sinh <input type="date" class="form-control form-control-lg is-valid" name="ngaySinh" id="validationServer01" required>
        Giới Tính <input type="number" class="form-control form-control-lg is-valid" name="gioiTinh" id="validationServer01" required>
        số chứng minh nhân dấn <input type="number" class="form-control form-control-lg is-valid" name="soCMND" id="validationServer01"
                                      required>
        Số diện thoại <input type="number" class="form-control form-control-lg is-valid" name="soDienThoai" id="validationServer01"
                             required>
        Loại khách hàng <input type="number" class="form-control form-control-lg is-valid" name="loaiKhachHang" id="validationServer01"
                               required>
        email <input type="text" class="form-control form-control-lg is-valid" name="email" id="validationServer01" required>
        địa chỉ <input type="text" class="form-control form-control-lg is-valid" name="diaChi" id="validationServer01" required>

        <button type="submit"> LƯU</button>
        <a href="/customer?actionCustomer">quay về</a>
    </form>
</div>
</body>
</html>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
