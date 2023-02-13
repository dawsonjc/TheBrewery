<%--
  Created by IntelliJ IDEA.
  User: Dawson
  Date: 12/6/2022
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RuntimeException exception = null;
    if(request.getAttribute("error") != null) {
        exception = (RuntimeException) request.getAttribute("error");
    } else {
        response.sendRedirect("/");
        return;
    }
    assert exception != null;
%>
<html>
<head>
    <title><%= exception %></title>
</head>
<body>

<%= exception.toString() %>

</body>
</html>
