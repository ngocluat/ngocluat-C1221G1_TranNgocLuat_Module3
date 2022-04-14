<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/04/2022
  Time: 4:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>

</head>
<body>
<form method="post">
<label>tên sản phẩm </label>

    <label>
        <input type="text" name="tenSanPham">
    </label>
    <label>mô tả </label>

    <label>
        <input type="text" name="moTa">
    </label>
    <label> giá </label>

    <label>
        <input type="number" name="gia">
    </label>


    <button type="submit">thêm mới </button>
</form>
</body>
</html>
