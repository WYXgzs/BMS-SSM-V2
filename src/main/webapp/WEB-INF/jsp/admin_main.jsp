<%--
  Created by IntelliJ IDEA.
  User: ryo
  Date: 2018/10/30
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员主页</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: visible;
            background-color: rgb(240, 242, 245);
        }
    </style>
</head>
<body>
<div>
    <nav style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default"
         role="navigation">
        <div class="container-fluid">
            <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
                <a class="navbar-brand" href="admin_main.action">图书管理系统</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            图书管理
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="allbooks.action">全部图书</a></li>
                            <li class="divider"></li>
                            <li><a href="book_add.action">增加图书</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            读者管理
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="allreaders.action">全部读者</a></li>
                            <li class="divider"></li>
                            <li><a href="reader_add.action">增加读者</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            借还管理
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="lendlist.action">借还日志</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="admin_repasswd.action">
                            密码修改
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="logout.action"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;退出</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="panel panel-default" style="width: 90%;margin-left: 5%">
        <div class="panel-heading" style="background-color: #fff">
            <h3 class="panel-title">
                最受欢迎图书排行
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>借阅次数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td><c:out value="${book.name}"></c:out></td>
                        <td><c:out value="${book.author}"></c:out></td>
                        <td><c:out value="${book.publish}"></c:out></td>
                        <td><c:out value="${book.count}"></c:out></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
