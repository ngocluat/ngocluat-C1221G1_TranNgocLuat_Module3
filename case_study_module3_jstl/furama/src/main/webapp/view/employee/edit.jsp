<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/04/2022
  Time: 4:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post" action="/employee?actionEmployee=edit">
        <table border="1" cellpadding="5">
            <tr>
                <th>id mã nhân viên :</th>
                <td>
                    <input type="hidden" name="id_ma_nhan_vien" size="45"
                           value="${employee.getIdMaNHanVien()}"
                    />
                </td>
            </tr>
            <tr>
                <th>mã nhân viên</th>
                <td>
                    <input type="text" name="ma_nhan_vien" size="45"
                           value="${employee.getMaNHanVien()}"
                           readonly />
                </td>
            </tr>
            <tr>
                <th>họ tên :</th>
                <td>
                    <input type="text" name="ho_ten" size="15"
                           value="${employee.getHoTen()}"
                    />
                </td>
            </tr>
            <tr>
                <th>ngày sinh :</th>
                <td>
                    <input type="text" name="ngay_sinh" size="15"
                           value="${employee.getNgaySinh()}"
                    />
                </td>
            </tr>
            <tr>
                <th>số chứng minhn nhân dân:</th>
                <td>
                    <input type="text" name="so_cmnd" size="15"
                           value="${employee.getSoCmnd()}"
                    />
                </td>
            </tr>
            <tr>
                <th>lương:</th>
                <td>
                    <input type="text" name="luong" size="15"
                           value="${employee.getLuong()}"
                    />
                </td>
            </tr>
            <tr>
                <th>số điện thoại:</th>
                <td>
                    <input type="text" name="so_dien_thoai" size="15"
                           value="${employee.getSoDienThoai()}"
                    />
                </td>
            </tr>
            <tr>
                <th>email:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="${employee.getEmail()}"/>
                </td>
            </tr>
            <tr>
                <th>địa chỉ:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="${employee.getDiaChi()}"/>
                </td>
            </tr>
            <tr>
                <th>mã vị trí :</th>
                <td>
                    <input type="text" name="ma_vi_tri" size="15"
                           value="${employee.getMaViTri()}"
                    />
                </td>
            <tr>
                <th>địa chỉ:</th>
                <td>
                    <input type="text" name="dia_chi" size="15"
                           value="${employee.getDiaChi()}"
                    />
                </td>


            </tr>
            <tr>
                <th>mã trình độ :</th>
                <td>
                    <input type="text" name="ma_trinh_do" size="15"
                           value="${employee.getMaTrinhDo()}"
                    />
                </td>
            </tr>
            <tr>
                <th>mã bộ phận :</th>
                <td>
                    <input type="text" name="ma_bo_phan" size="15"
                           value="${employee.getMaBoPhan()}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
