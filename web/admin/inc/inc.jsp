<%@ page import="test.msg.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/4 0004
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = (User) session.getAttribute("loginUser");
%>
<div style="text-align: right;border-botton:1px solid #000;">
    欢迎[<%=u.getUsername()%>]使用本系统&nbsp&nbsp&nbsp<a href="<%=request.getContextPath()%>/admin/list.jsp">用户管理</a>&nbsp;&nbsp
    &nbsp<a href="<%=request.getContextPath()%>/logout.jsp">退出系统</a>
</div>
