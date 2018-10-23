<%--
  Created by IntelliJ IDEA.
  User: ryo
  Date: 2018/10/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
用户列表
<table width="100%" border=1>
    <tr>
        <td>学号/工号</td>
        <td>姓名</td>
        <td>电话</td>
        <td>类型</td>
        <td>注册时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList }" var="user">
        <tr>
            <td>${user.uid }</td>
            <td>${user.name }</td>
            <td>${user.phone }</td>
            <td>${user.type }</td>
            <td>${user.createtime}</td>
            <td><a href="userEdit.action?uid=${user.uid}">修改</a>
                <a href="userDel.action?uid=${user.uid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
