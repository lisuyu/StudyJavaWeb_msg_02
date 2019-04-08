<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/4 0004
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h2 align="center">用户登录</h2>
    <hr>
</head>
<body>
<form action="login.jsp" method="post">
    <table align="center" border="1">
        <tr><td>用户名称</td><td><input type="text" name="username" style="width: 200px"></td></tr>
        <tr><td>用户密码</td><td><input type="password" name="password" style="width: 200px"></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="登陆"></td></tr>
    </table>
</form>
</body>
</html>
