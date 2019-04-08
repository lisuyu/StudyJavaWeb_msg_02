<%@ page import="test.msg.model.User" %>
<%@ page import="test.msg.model.MsgException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User loginUser = (User)session.getAttribute("loginUser");
    if (loginUser.getType()!=1){
        throw new MsgException("权限不足！");
    }
%>
