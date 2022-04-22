<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/04/2022
  Time: 1:27 CH
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
<h4><a href="/service">quay về trang service</a></h4>
<c:if test="${message!= null}">
    <p>${message} </p>
</c:if>
<form action="service?actionService=create" method="post">
    <table class="table table-striped table-dark">
        <%--        <tr>--%>
        <%--            <td>mã dịch vụ</td>--%>
        <%--            <td><input type="number" name="madichVu"></td>--%>
        <%--        </tr>--%>
        <tr>
            <td>tên dịch vụ</td>
            <td><input type="text" name="tenDichVu"></td>
        </tr>
        <tr>
            <td>diện tích</td>
            <td><input type="text" name="dienTich"></td>
        </tr>
        <tr>
            <td>chi phí thuê</td>
            <td><input type="number" name="chiPhiThue"></td>
        </tr>
        <tr>
            <td>số người tối đa</td>
            <td><input type="number" name="soNguoiToiDa"></td>
        </tr>
        <tr>
            <td>mã kiểu thuê</td>
            <td><input type="number" name="maKieuThue"></td>
        </tr>
        <tr>
            <td>mã loại dịch vụ</td>
            <td><input type="number" name="maLoaiDichVu"></td>
        </tr>
        <tr>
            <td>tiêu chuẩn phòng</td>
            <td><input type="text" name="tieuChuanPhong"></td>
        </tr>
        <tr>
            <td>mô tả tiện nghi khác</td>
            <td><input type="text" name="moTaTienNghiKhac"></td>
        </tr>
        <tr>
            <td>diện tích hồ bơi</td>
            <td><input type="number" name="dienTichHoBoi"></td>
        </tr>
        <tr>
            <td>số tầng</td>
            <td><input type="number" name="soTang">
                <p>${error.get("sotang")}</p>
            </td>
        </tr>
    </table>
    <button type="submit"> thêm mới</button>
</form>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>