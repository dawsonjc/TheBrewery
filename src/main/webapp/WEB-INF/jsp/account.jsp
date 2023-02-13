<%@ page import="tlcm.website.thebrewery.entities.users.FrontUser" %><%--
  Created by IntelliJ IDEA.
  User: Dawson
  Date: 12/5/2022
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String title = "Account Information"; %>
<%@ include file="header.jsp"%>
<body>
<%
    FrontUser user = (FrontUser) request.getSession().getAttribute("current_user");
%>

<table>
    <tr></tr>
    <tr></tr>
</table>
</body>
</html>
