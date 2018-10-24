<%--
  Created by IntelliJ IDEA.
  User: ryo
  Date: 2018/10/24
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>

<form action="updateUser.action" method="post">
    <input type="hidden" name="uid" value="${user.uid }"/>
    <table width="100%" border=1>
        <tr>
            <td>学号/工号</td>
            <td>${user.uid }</td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${user.password }"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${user.name }"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${user.phone }"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
