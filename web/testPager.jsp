<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/10 0010
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<pg:pager items="1000" maxPageItems="15" maxIndexPages="20" export="curPage=pageNumber">
    <pg:first export="pageUrl,firstItem">
        <a href="<%=pageUrl%>">首页[<%=firstItem%>]</a>
    </pg:first>
    <pg:prev>
        <a href="<%=pageUrl%>">上一页</a>
    </pg:prev>
    <pg:pages>
        <%
            if(curPage==pageNumber){
        %>
        [<%=pageNumber%>]
        <%
            }else{
        %>
        <a href="<%=pageUrl%>"><%=pageNumber%></a>
        <%
            }
        %>
    </pg:pages>
    <pg:next>
        <a href="<%=pageUrl%>">下一页</a>
    </pg:next>
    <pg:last>
        <a href="<%=pageUrl%>">尾页</a>
    </pg:last>
</pg:pager>
</body>
</html>
