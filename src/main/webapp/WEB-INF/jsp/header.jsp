<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    if(request.getParameter("logout") != null) {
        boolean isLogout = Boolean.parseBoolean(request.getParameter("logout"));
        if(isLogout) {
            request.getSession().setAttribute("current_user", null);
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
            return;
        }
    }
%>

<html>
<head>
    <title><%= title %></title>
</head>
<body>
    <nav>
        <% if(request.getSession().getAttribute("current_user") == null) { %>
        <a href="${pageContext.request.contextPath}/account/login">Login | Register</a>
        <% } else { %>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="accountMenu" data-toggle="dropdown">Account</button>
        </div>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/account">Information</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}?logout=true">Logout</a>
        </div>
        <% } %>
    </nav>
</body>
