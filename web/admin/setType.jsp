<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    IUserDao userDao = DAOFactory.getUserDao();
    User user = userDao.load(id);
    if (user.getType()==0){
        user.setType(1);
    }else{
        user.setType(0);
    }
    userDao.update(user);
    response.sendRedirect("list.jsp");
%>