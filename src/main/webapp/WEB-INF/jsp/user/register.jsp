<%--
  Created by IntelliJ IDEA.
  User: ryo
  Date: 2018/10/22
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="register.action" method="post">
    学号/工号<br>
    <input type="number" name="uid" min="1"><br>
    密码<br>
    <input type="password" name="password"><br>
    姓名<br>
    <input type="text" name="name"><br>
    电话<br>
    <input type="text" name="phone"><br>
    类型<br>
    <input id="type1" type="radio" value="教师" name="type">教师</input>
    <input id="type2" type="radio" value="学生" name="type">学生</input><br>
    <input type="submit">
</form>
</body>
</html>
