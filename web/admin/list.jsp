<%@ page import="test.msg.dao.DAOFactory" %>
<%@ page import="test.msg.dao.IUserDao" %>
<%@ page import="test.msg.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="test.msg.model.Pager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/2 0002
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<%
    int pageSize = 60;
    int pageIndex = 1;
    try {
        pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    String con = request.getParameter("con");
    IUserDao userDao = DAOFactory.getUserDao();
    Pager<User> pages = userDao.list(con,pageSize,pageIndex);
    List<User> list = new ArrayList<User>();
    list = pages.getDates();
    User loginUser = (User) session.getAttribute("loginUser");
    if (con==null){
        con="";
    }
%>
<jsp:include page="../inc/user_manager_top.jsp">
    <jsp:param name="op" value="列表"/>
</jsp:include>
<table align="center" border="1">
    <tr>
        <td colspan="7" align="center">
            <form method="post" action="list.jsp">
                输入用户名或者昵称：<input type="text" name="con" value="<%=con%>"/><input type="submit" value="查询"/>
            </form>
        </td>
    </tr>
    <tr><td>编号</td><td>用户名</td><td>密码</td><td>昵称</td>
        <td>用户状态</td><td>用户类型</td>
        <td>操作</td>
    <%
        for (User user:list){
    %>
    <tr>
    <td><%=user.getId()%></td>
    <td><%=user.getUsername()%></td>
    <td><%=user.getPassword()%></td>
    <td><%=user.getNickname()%></td>
    <td>
        <%
            if (user.getStatus()==0){
        %>
        停用
        <%
            if (loginUser.getType()==1){
        %>
        <a href="setStatus.jsp?id=<%=user.getId()%>">启用</a>
        <%
            }
            }else{
        %>
        启用
        <%
            if (loginUser.getType()==1){
        %>
        <a href="setStatus.jsp?id=<%=user.getId()%>"><span style="color:red">停用</span></a>
        <%
            }
            }
        %>
    </td>
    <td>
        <%
            if (user.getType()==0){
        %>
        普通用户&nbsp;
        <%
            if (loginUser.getType()==1){
        %>
        <a href="setType.jsp?id=<%=user.getId()%>">设置为管理员</a>
        <%
            }
            }else{
        %>
        管理员
        <%
            if (loginUser.getType()==1){
        %>
        <a href="setType.jsp?id=<%=user.getId()%>">取消管理员</a>
        <%
            }
            }
        %>
    </td>
        <td><a href="delete.jsp?id=<%=user.getId()%>">删除</a>&nbsp;<a href="updateInput.jsp?id=<%=user.getId()%>">更新</a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="7">
            一共有：<%=pages.getTotalRecord()%>条记录，当前是第<%=pageIndex%>页，每页显示<%=pageSize%>条记录
        </td>
    </tr>
    <tr>
        <td colspan="7">
            <%
                if (pageIndex>1){
            %>
            <a href="list.jsp?pageIndex=<%=pageIndex-1%>">上一页</a>
            <%
                }
                int totalPage = pages.getTotalPage();
                for (int i=1;i<=totalPage;i++){
                    if (i==pageIndex){
            %>
                    <%=i%>
            <%
                    }else{
            %>
            <a href="list.jsp?pageIndex=<%=i%>">[<%=i%>]</a>
            <%
                    }
                }
                if (pageIndex<totalPage){
            %>
            <a href="list.jsp?pageIndex=<%=pageIndex+1%>">下一页</a>
            <%
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>
