<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.User" %>
<%@ page import="test.msg.util.ValidateUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/2 0002
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户更新</title>
    <%
        int userId = Integer.parseInt(request.getParameter("id"));
        IUserDao userDao = DAOFactory.getUserDao();
        User user = userDao.load(userId);

    %>
</head>
<body>
<jsp:include page="../inc/user_manager_top.jsp">
    <jsp:param name="op" value="更新"/>
</jsp:include>
<%!
    public static String processNull(Object o){
        if (o==null)
            return "";
        return (String)o;
    }
%>
<form action="update.jsp" method="post">
    <table align="center" width="400" border="1">
        <input type="hidden" name="id" value="<%=user.getId()%>">
        <tr>
            <td>用户名</td><td><%=user.getUsername()%></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="password" name="password" value="<%=user.getPassword()%>">
            <%=processNull(ValidateUtil.showError(request,"password"))%></td>
        </tr>
        <tr>
            <td>昵称</td><td><input type="text" name="nickname" value="<%=user.getNickname()%>">
            <%=processNull(ValidateUtil.showError(request,"nickname"))%></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="用户更新">&nbsp;<input type="reset"></td></tr>
    </table>
</form>
</body>
</html>
