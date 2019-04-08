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
    <title>添加用户</title>
</head>
<body>
<jsp:include page="../inc/user_manager_top.jsp">
    <jsp:param name="op" value="添加"/>
</jsp:include>
<%!
   public static String processNull(Object o){
       if (o==null)
           return "";
       return (String)o;
   }
%>
<form action="add.jsp" method="post">
    <table align="center" width="400" border="1">
        <tr>
            <td>用户名</td><td><input type="text" name="username" value="<%=processNull(request.getParameter("username"))%>">
            <%=processNull(ValidateUtil.showError(request,"username"))%></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="password" name="password" value="<%=processNull(request.getParameter("password"))%>">
            <%=processNull(ValidateUtil.showError(request,"password"))%></td>
        </tr>
        <tr>
            <td>昵称</td><td><input type="text" name="nickname" value="<%=processNull(request.getParameter("nickname"))%>">
            <%=processNull(ValidateUtil.showError(request,"nickname"))%></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
