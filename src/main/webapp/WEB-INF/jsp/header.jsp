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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <nav>
        <% if(request.getSession().getAttribute("current_user") == null) { %>
        <a href="${pageContext.request.contextPath}/account/login">Login | Register</a>
        <% } else { %>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="accountMenu" data-toggle="dropdown">Account</button>
            <ul class="dropdown-menu" aria-labelledby="accountMenu">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/account">Information</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}?logout=true">Logout</a></li>
            </ul>
        </div>
        <% } %>

    </nav>
</body>
