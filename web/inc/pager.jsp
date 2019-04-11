<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/10 0010
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%
    int items = Integer.parseInt(request.getParameter("items"));
    String params = request.getParameter("params");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<pg:pager items="<%=items%>"  maxIndexPages="15" export="curPage=pageNumber">
<pg:last>
    一共有：<%=items%>条记录，共<%=pageNumber%>页,
</pg:last>
    当前是第<%=curPage%>页
<pg:param name="<%=params%>"/>
    <pg:first export="pageUrl,firstItem">
        <a href="<%=pageUrl%>">首页</a>
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