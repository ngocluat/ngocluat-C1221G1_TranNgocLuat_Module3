<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/04/2022
  Time: 9:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>


<h1> thêm mới employee </h1>
<h3><a href="/">quay về </a></h3>
<form action="/         ?action=create" method="post">
    <table>
        <tr>
            <td>  </td>
            <td><input class="form-control" placeholder="Username" type="text" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="text" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="date" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="number" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="number" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="number" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="text" name=""></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="text" name=""></td>
        </tr>
        <%--        <tr>--%>
        <%--            <td> vị trí</td>--%>
        <%--            <td><select name="">--%>
        <%--                <c:forEach items="${viTri}" var="type">--%>
        <%--                    <option value="${type.maViTri}">--%>
        <%--                            ${type.tenViTri}--%>
        <%--                    </option>--%>
        <%--                </c:forEach>--%>
        <%--            </select>--%>
        <%--            </td>--%>
        <%--        </tr>--%>
    </table>
    <button class="btn btn-outline-info" type="submit"> Thêm Mới</button>
</form>
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
