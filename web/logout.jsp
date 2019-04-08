<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/4 0004
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出系统</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath()+"/loginInput.jsp");
%>
</body>
</html>
