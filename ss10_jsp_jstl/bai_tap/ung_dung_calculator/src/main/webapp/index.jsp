<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/04/2022
  Time: 1:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="form-signin mx-auto p-1 bg-secondary text-white text-center">
<form action="/tinh-toan" method="post">
<p>số đầu tiên</p>
<label>
  <input class="form-control" type="number" name="numberFirst">
</label>
<p>phép tính </p>
<label>
 <select name="phepTinh">
   <option value="+">cộng</option>
   <option value="-">trừ</option>
   <option value="*">nhân</option>
   <option value="/">chia</option>
 </select>
</label>
<p>số thứ hai </p>
<label>
  <input class="form-control" type="number" name="numberSeconse">
</label>
    <button type="submit">tính</button>
</form>
</div>
</body>
</html>
