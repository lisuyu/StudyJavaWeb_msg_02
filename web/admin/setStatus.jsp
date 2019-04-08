<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    IUserDao userDao = DAOFactory.getUserDao();
    int id = Integer.parseInt(request.getParameter("id"));
    User user = new User();
    user = userDao.load(id);
    if (user.getStatus()==0){
        user.setStatus(1);
    }else{
        user.setStatus(0);
    }
    userDao.update(user);
    response.sendRedirect("list.jsp");
%>
