<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.MsgException" %>
<%@ page import="test.msg.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/4 0004
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    IUserDao userDao = DAOFactory.getUserDao();
    User user = new User();
    try {
        user = userDao.Login(username,password);
        session.setAttribute("loginUser",user);
        response.sendRedirect(request.getContextPath()+"/admin/list.jsp");
    } catch (MsgException e) {
%>
    <h2 style="color:red;">
        发生错误：<%=e.getMessage()%>
    </h2>
<%
        e.printStackTrace();
    }
%>
