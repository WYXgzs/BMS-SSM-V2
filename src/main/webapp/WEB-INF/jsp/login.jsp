<%--
  Created by IntelliJ IDEA.
  User: ryo
  Date: 2018/10/19
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login.action" method="post">
    学号：<input type="number" name="uid" min="1"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
