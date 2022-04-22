<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/04/2022
  Time: 8:48 CH
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
    <style>
        body {
            background-color: black;
        }
    </style>
</head>
<body>
<h1 style=" color: red ; text-align: center">Employee</h1>
<h3><a href="/view/home.jsp">back to home </a></h3>
<h3><a href="/employee?actionEmployee=create">thêm mới Employe </a></h3>
<div class="mx-auto" style="width: 95%;">

    <form action="/employee">
        <input type="hidden" name="actionEmployee" value="search">
        <input type="text" name="hoTen" placeholder="họ tên">

        <select name="maBoPhan">
            <c:forEach items="${boPhan}" var="type">
                <option value="${type.maBoPhan}">
                        ${type.tenBoPhan}
                </option>
            </c:forEach>
        </select>

        <input type="text" name="mail" placeholder="email">

        <button type="submit"> tìm kiếm</button>
    </form>

    <table class="table table-striped table-dark " border="1" id="tableStudent">
        <thead>
        <tr>
            <th>Id</th>
            <th>Mã NHân Viên</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Số Chứng Minh</th>
            <th>Lương</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>địa chỉ</th>
            <th> mã vị trí</th>
            <th>mã Trình độ</th>
            <th>Mã Bộ Phận</th>
            <th>sữa</th>
            <th>xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${employee}">
            <tr>
                <td>${item.idMaNHanVien}</td>
                <td>${item.maNHanVien}</td>
                <td>${item.hoTen}</td>
                <td>${item.ngaySinh}</td>
                <td>${item.soCmnd}</td>
                <td>
                        <%--                        ${item.luong}--%>
                    <fmt:formatNumber value="${item.luong}" type="number"/>
                </td>

                <td>${item.soDienThoai}</td>
                <td>${item.email}</td>
                <td>${item.diaChi}</td>
                <td>
                    <c:forEach var="type" items="${viTri}">
                        <c:if test="${item.maViTri== type.maViTri}">
                            ${type.tenViTri}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="type" items="${trinhDo}">
                        <c:if test="${item.maTrinhDo== type.maTrinhDo}">
                            ${type.tenTrinhDo}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="type" items="${boPhan}">
                        <c:if test="${item.maBoPhan == type.maBoPhan}">
                            ${type.tenBoPhan}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="/employee?actionEmployee=edit&idMaNhanVien=${item.idMaNHanVien}">sữa</a>
                </td>
                <td>
                    <button type="submit" class=" text-light  btn btn-outline-danger" data-toggle="modal"
                            data-target="#exampleModal"
                            onclick="deleteUser(
                                ${item.idMaNHanVien},
                                <c:out value="\'${item.hoTen}\'"/>)">
                        xóa
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <form action="employee?actionEmployee=delete" method="post">
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


<%--%--bootrap 4.6 + 3.5  + phân trang&ndash;%&gt;--%>
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