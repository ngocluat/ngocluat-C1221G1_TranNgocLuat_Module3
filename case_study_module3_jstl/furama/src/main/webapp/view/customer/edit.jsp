<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/04/2022
  Time: 1:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/customer">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/customer?actionCustomer=edit&id_ma_khach_hang=${idMaKhachHang}">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>

            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="ho_ten" size="45"
                           value="${customers.hoVaTen}"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày sinh:</th>
                <td>
                    <input type="text" name="ngay_sinh" size="45"
                           value="${customers.ngaySinh}"
                    />
                </td>
            </tr>
            <tr>
                <th>giới tính :</th>
                <td>
                    <input type="text" name="gioi_tinh" size="15"
                           value="${customers.gioiTinh}"
                    />
                </td>
            </tr>
            <tr>
                <th>số chứng minh:</th>
                <td>
                    <input type="text" name="so_cmnd" size="15"
                           value="${customers.soCMND}"
                    />
                </td>
            </tr>
            <tr>
                <th>email:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="${customers.eMail}"
                    />
                </td>
            </tr>
            <tr>
                <th>số điện thoại:</th>
                <td>
                    <input type="text" name="so_dien_thoai" size="15"
                           value="${customers.soDienThoai}"
                    />
                </td>
            </tr>
            <tr>
                <th>mã khách hàng:</th>
                <td>
                    <input type="text" name="ma_khach_hang" size="15"
                           value="${customers.maKhachHang}"
                    />
                </td>
            </tr>
            <tr>
                <th>mã loại khác hàng:</th>
                <td>
                    <%--                    <input type="text" name="ma_loai_khach" size="15"--%>
                    <%--                           value="${customers.loaiKhachHang}"--%>
                    <%--                    />--%>
                    <select name="ma_loai_khach">
                        <c:forEach items="${customerTypeLists}" var="type">
                            <option value="${type.maLoaiKhach}">
                                    ${type.tenLoaiKhachHang}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>địa chỉ :</th>
                <td>
                    <input type="text" name="dia_chi" size="15"
                           value="${customers.diaChi}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <c:if test="${message != null}">
            ${message}
        </c:if>
    </form>
</div>

</body>
</html>
