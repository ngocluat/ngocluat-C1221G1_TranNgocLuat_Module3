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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css" type="text/css">
    <style>
        body {
            background: #000000;
        }

        table {
            height: 20px;
        }
    </style>
</head>
<body>
<h1 class="btn btn-outline-secondary"><a href="view/home.jsp"> Back To Home</a></h1>

<div>
    <label> tìm kiếm</label>
    <form action="/customer">
        <input type="hidden" name="actionCustomer" value="search">
        <input type="text"  placeholder="họ tên" name="name">
        <input type="text"  placeholder="dịa chỉ " name="diaChi">
        <input type="text"  placeholder="email  " name="mail">
        <button type="submit">tìm kiếm</button>
    </form>
</div>
<h4><a href="/customer">loading</a></h4>
<h4 class="btn btn-outline-primary"><a href="/customer?actionCustomer=create"> Thêm Mới Customer</a></h4>
<div>

    <h2 class="text-center" style=" color: #85b694"> list Customer </h2>
    <div class="mx-auto" style="width: 95%;">
        <table class="table table-striped table-dark " border="1" id="tableStudent">
            <thead>
            <tr>
                <th>Id Mã Khách Hàng</th>
                <th>Họ Và Tên</th>
                <th>Ngày Sinh</th>
                <th>Giới Tính</th>
                <th>Số Chứng Minh</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Mã Khách Hàng</th>
                <th>Loại Khách Hàng</th>
                <th> Địa Chỉ</th>
                <th>Chức Năng sửa</th>
                <th>Chức Năng xóa</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${customerLists}">
                <tr>
                    <td>${item.idMaKhachHang}</td>
                    <td>${item.hoVaTen}</td>
                    <td>${item.ngaySinh}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.gioiTinh == 0}">Nam</c:when>
                            <c:when test="${item.gioiTinh == 1}"> Nữ</c:when>
                            <c:when test="${item.gioiTinh != 0 && item.gioiTinh != 1}"> Bê Đê </c:when>
                        </c:choose>
                    </td>
                    <td>${item.soCMND}</td>
                    <td>${item.soDienThoai}</td>
                    <td>${item.eMail}</td>
                    <td>${item.maKhachHang}</td>
                    <td>
                        <c:forEach var="type" items="${customerTypeLists}">
                            <c:if test="${type.maLoaiKhach== item.loaiKhachHang}">
                                ${type.tenLoaiKhachHang}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${item.diaChi}</td>

                    <td class="btn btn-outline-warning"><a
                            href="/customer?actionCustomer=edit&id_ma_khach_hang=${item.idMaKhachHang}">edit</a></td>
                    <td>
                        <button  type="submit" class=" text-light  btn btn-outline-danger" data-toggle="modal"
                                data-target="#exampleModal"
                                onclick="deleteUser(
                                    ${item.idMaKhachHang},
                                    <c:out value="\'${item.hoVaTen}\'"/>)">
                            xóa
                        </button>
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
    <form action="customer?actionCustomer=delete" method="post">
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
                        <input type="hidden" name="id" id="idDelete">
                        <input type="hidden" name="actionCustomer" value="delete">
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
<%--bootrap 4.6 + 3.5  + phân trang--%>
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
<script>
    function deleteUser(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;


    }
</script>
