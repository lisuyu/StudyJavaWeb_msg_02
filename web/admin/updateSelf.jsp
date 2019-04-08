<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.User" %>
<%@ page import="test.msg.util.ValidateUtil" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String password = request.getParameter("password");
    String nickname = request.getParameter("nickname");
    System.out.println("password:"+password+"nickname:"+nickname);
    boolean validate = ValidateUtil.validateNull(request,new String[]{"password","nickname"});
    System.out.println(validate);
    if (!validate){
%>
<jsp:forward page="updateInput.jsp"></jsp:forward>
<%
    }
    IUserDao userDao = DAOFactory.getUserDao();
    User user = userDao.load(id);
    user.setPassword(password);
    user.setNickname(nickname);
    try {
        userDao.update(user);
        response.sendRedirect("list.jsp");
        return;
    } catch (IOException e) {
%>
<h2 style="color:red">发生错误:<%=e.getMessage()%></h2>
<%
        e.printStackTrace();
    }
%>
