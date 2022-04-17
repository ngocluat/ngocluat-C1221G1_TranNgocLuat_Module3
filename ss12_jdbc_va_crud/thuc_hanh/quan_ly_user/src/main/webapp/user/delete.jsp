<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/04/2022
  Time: 9:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h1>delete</h1>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                Edit User
            </h2>
        </caption>
        <c:if test="$${user != null}">
            <input type="hidden" name="id" value="${user.id}"/>
        </c:if>
        <tr>
            <th>User Name:</th>
            <td>
                <input type="text" name="name" size="45"
                       value="${user.name}"
                />
            </td>
        </tr>
        <tr>
            <th>User Email:</th>
            <td>
                <input type="text" name="email" size="45"
                       value="${user.email}"
                />
            </td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <input type="text" name="country" size="15"
                       value="${user.country}"
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
</body>
</html>
