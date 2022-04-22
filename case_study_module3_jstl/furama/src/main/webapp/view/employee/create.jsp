<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/04/2022
  Time: 4:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> thêm mới employee </h1>
<c:if test="${message!= null}">
    <p>${message} </p>
</c:if>
<h3><a href="/employee">quay về </a></h3>
<form action="/employee?actionEmployee=create" method="post">
    <table>
        <tr>
            <td>mã nhân viên</td>
            <td><input type="text" name="maNhanVien"></td>
        </tr>
        <tr>
            <td>họ tên</td>
            <td><input type="text" name="hoTen"></td>
        </tr>
        <tr>
            <td>ngày sinh</td>
            <td><input type="date" name="ngaySinh"></td>
        </tr>
        <tr>
            <td>số chứng minh</td>
            <td><input type="number" name="soCmnd">
                <p>${error.get("sochungminh")}</p>

            </td>
        </tr>
        <tr>
            <td>Luong</td>
            <td><input type="number" name="luong">
                <p>${error.get("luong")}</p>
            </td>
        </tr>
        <tr>
            <td>sô điên thoại</td>
            <td><input type="number" name="soDienThoai">
                <p>${error.get("sodienthoai")}</p>
            </td>

        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email">
                <p>${error.get("mail")}</p>
            </td>
        </tr>
        <tr>
            <td>địa chỉ</td>
            <td><input type="text" name="diaChi"></td>
        </tr>
        <tr>
            <td> vị trí</td>
            <td><select name="maViTri">
                <c:forEach items="${viTri}" var="type">
                    <option value="${type.maViTri}">
                            ${type.tenViTri}
                    </option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td> trình độ</td>
            <td><select name="maTrinhDo">
                <c:forEach items="${trinhDo}" var="type">
                    <option value="${type.maTrinhDo}">
                            ${type.tenTrinhDo}
                    </option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td> bộ phận</td>
            <td>
                <select name="maBoPhan">
                    <c:forEach items="${boPhan}" var="type">
                        <option value="${type.maBoPhan}">
                                ${type.tenBoPhan}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit"> thêm mới</button>
</form>
</body>
</html>
