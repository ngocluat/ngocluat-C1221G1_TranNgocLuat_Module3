<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/04/2022
  Time: 3:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>kết quả</h1>
<c:if test="${suCo == null}">
    ${ketQua}
</c:if>

<c:if test="${suCo != null}">
    ${suCo}
</c:if>

</body>
</html>
