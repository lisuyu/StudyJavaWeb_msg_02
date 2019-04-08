<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/3 0003
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        IUserDao userDao = DAOFactory.getUserDao();
        System.out.println(id);
        userDao.delete(id);
        response.sendRedirect("list.jsp");
    } catch (Exception e) {
%>
<h2 style="color:red">
    出现异常：<%=e.getMessage()%>
</h2>
<%
    }
%>