<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/04/2022
  Time: 9:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
bootstrap cdn 4.6
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: black;

        }
    </style>
</head>
<body>
<h1 style="color: #ececee"> xin chào </h1>
<br>
<h2 style=" text-align: center ; color: #ececee">List Contract</h2>
<h3 style="color: #ececee"><a href="/contract?actionContract=create">thêm mới họp dồng </a></h3>
<table class="table table-striped table-dark ">
    <tr>
        <th>mã họp đồng</th>
        <th>ngày làm hợp dồng</th>
        <th>ngày kết thúc</th>
        <th>tiền đặt cọc</th>
        <th>id mã nhân viên</th>
        <th>id mã khách hàng</th>
        <th>mã dịch vụ</th>
    </tr>
    <c:forEach var="item" items="${hopDong}">
        <tr>
            <td>${item.getMaHopDong()}</td>
            <td>${item.getNgayLamHopDong()}</td>
            <td>${item.getNgayKetThuc()}</td>
            <td>${item.getTienDatCoc()}</td>
            <td>
                        <c:forEach var="type" items="${employee}">
                            <c:if test="${item.getIdMaNhanVien()== type.idMaNHanVien}">
                                ${type.hoTen}
                            </c:if>
                        </c:forEach>

            </td>
            <td>


                        <c:forEach var="type" items="${customerLists}">
                            <c:if test="${item.getIdMaKhachHang()== type.idMaKhachHang}">
                                ${type.hoVaTen}
                            </c:if>
                        </c:forEach>
            </td>
            <td>
                <c:forEach var="type" items="${serviceLists}">
                    <c:if test="${item.getIdMaDichVu()== type.maDichVu}">
                        ${type.tenDichVu}
                    </c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>


</table>


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
