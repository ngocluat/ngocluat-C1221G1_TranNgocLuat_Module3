<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 18/04/2022
  Time: 10:43 SA
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

        body {
            background: #000000;
        }
    </style>
</head>
<body>
<h1 class="btn btn-outline-secondary"><a href="../home.jsp"> Back To Home</a></h1>

<div>
    <label> tìm kiếm </label>
    <form action="/customer">
        <input type="hidden" name="actionCustomer" value="search">
        <input type="text" name="name">
        <button type="submit">tìm tên Customer</button>
    </form>
</div>
<h4 class="btn btn-outline-primary"><a href="/customer?actionCustomer=create"> Thêm Mới Customer</a></h4>
<div>

    <h2 class="text-center" style=" color: #85b694"> list Customer </h2>
    <div class="mx-auto" style="width: 95%;">
        <table class="table table-striped table-dark" border="1">
            <tr>
                <th>Họ Và Tên</th>
                <th>Ngày Sinh</th>
                <th>Giới Tính</th>
                <th>Số Chứng Minh</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Mã Khách Hàng</th>
                <th>Loại Khách Hàng</th>
                <th> Địa Chỉ</th>
                <th colspan="2">Chức Năng</th>


                <c:forEach var="item" items="${customerLists}">
            <tr>
                <td>${item.hoVaTen}</td>
                <td>${item.ngaySinh}</td>
                <td>
                    <c:if test="${item.gioiTinh == 0}">Nam</c:if>
                    <c:if test="${item.gioiTinh == 1}">Nữ </c:if>
                </td>
                <td>${item.soCMND}</td>
                <td>${item.soDienThoai}</td>
                <td>${item.eMail}</td>
                <td>${item.maKhachHang}</td>
                <td>
                    <c:if test="${item.loaiKhachHang == 5}">Diamond</c:if>
                    <c:if test="${item.loaiKhachHang == 4}">Platinium</c:if>
                    <c:if test="${item.loaiKhachHang == 3}">Gold</c:if>
                    <c:if test="${item.loaiKhachHang == 2}">Silver</c:if>
                    <c:if test="${item.loaiKhachHang == 1}">Member</c:if>
                </td>
                <td>${item.diaChi}</td>
                <td class="btn btn-outline-warning">${item.maKhachHang} <a href="/customer?actionCustomer=edit&ma_khach_hang${item.maKhachHang}">edit</a></td>

                <td>
                    <button type="submit" class="btn btn-primary btn btn-outline-danger" data-toggle="modal"
                            data-target="#exampleModal"
                            onclick="deleteUser(
                                ${item.maKhachHang},
                                <c:out value="\'${item.hoVaTen}\'"/>)">
                        xóa
                    </button>
                </td>
            </tr>
            </c:forEach>

        </table>
    </div>
    <form action="/customer?actionCustomer=delete" method="post">
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <input type="text" name="id" id="idDelete">
                        <input type="text" name="actionCustomer" value="delete">
                        <p style="color: red">Bạn có chắc muốn xóa <span id="nameDelete"></span></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Xóa</button>
                    </div>
                </div>
            </div>
        </div>
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

<script>
    function deleteUser(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;
    }
</script>
