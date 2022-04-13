<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String search = request.getParameter("translace");
    PrintWriter outa = response.getWriter();
    String result = dic.get(search);
    if (result != null) {
        outa.println("Word: " + search);
        outa.println("Result: " + result);
    } else {
        outa.println("Not found");
    }

%>

</body>
</html>