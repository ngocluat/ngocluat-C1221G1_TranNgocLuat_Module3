<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/04/2022
  Time: 10:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css" type="text/css">

</head>
<body>
<h1>Service</h1>
<div class="mx-auto" style="width: 95%;">
    <h2><a href="/service?actionService=create">thêm mới dịch vụ </a></h2>
    <h2><a href="/view/home.jsp">quay về trang chính</a></h2>
    <table class="table table-striped table-dark " border="1" id="tableStudent">
        <thead>
        <tr>
            <th>id dich vụ</th>
            <th>mã dịch vụ</th>
            <th>tên dịch vụ</th>
            <th>diện tích</th>
            <th>chi phí thuê</th>
            <th>số người tối đa</th>
            <th>mã kiểu thuê</th>
            <th>mã loại dịch vụ</th>
            <th>tiêu chuẩn phòng</th>
            <th>mô tả tiện nghi</th>
            <th>S hồ bơi</th>
            <th>Tầng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${serviceLists}">
            <tr>

                <td>${item.idDichVu}</td>
                <td>${item.maDichVu}</td>
                <td> ${item.tenDichVu}</td>
                <td>${item.dienTich}</td>
                <td>
                    <fmt:formatNumber value="${item.chiPhiThue}" type="number"/>
                </td>
                <td>${item.soNguoiToiDa}</td>
                <td>

                    <c:forEach var="type" items="${kieuThue}">
                        <c:if test="${item.maKieuThue== type.maKieuThue}">
                            ${type.tenKieuThue}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="type" items="${maLoaiDichVu}">
                        <c:if test="${item.maLoaiDichVu== type.maLoaiDichVu}">
                            ${type.tenLoaiDichVu}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${item.tieuChuanPhong}</td>
                <td>${item.moTaDienTichKhac}</td>
                <td>${item.dienTichHoBoi}</td>
                <td>${item.soTang}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>--%>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').DataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        );
    });
</script>