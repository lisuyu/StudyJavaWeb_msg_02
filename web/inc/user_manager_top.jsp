<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/3 0003
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../admin/inc/inc.jsp"%>
<hr/>
<h2 align="center">用户<%=request.getParameter("op")%>功能</h2>
<a href="../admin/addInput.jsp">添加用户</a>&nbsp;<a href="../admin/list.jsp">用户列表</a>
<hr/>