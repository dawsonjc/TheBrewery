<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    if(request.getParameter("logout") != null) {
        boolean isLogout = Boolean.parseBoolean(request.getParameter("logout"));
        if(isLogout) {
            request.getSession().setAttribute("current_user", null);
            response.sendRedirect(request.getContextPath());
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
        }
        return;
    }
%>


<html>
<head>
    <title><%= title %></title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="  crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href=""/>
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript">
        const contextPath = "${pageContext.request.contextPath}/";
    </script>
    <%
        {
            String fileName = this.getClass().getSimpleName().replace("_jsp", "");

            switch(fileName) {
                case "index": // js files for index page
    %>
    <script src="<%= request.getContextPath() %>/static/js/index.js"></script>
    <%
                    break;
                case "account": // js files for account page
    %>
    <script src="<%= request.getContextPath() %>/static/js/account.js"></script>
    <%
                    break;
                default:
                    break;
            }
        }
    %>

</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Partners
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown1">
                        <a class="dropdown-item" href="#">Bakeries</a>
                        <a class="dropdown-item" href="#">Farms</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Forum
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown2">
                        <a class="dropdown-item" href="#">Action 1</a>
                        <a class="dropdown-item" href="#">Action 2</a>
                        <a class="dropdown-item" href="#">Action 3</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <% if(request.getSession().getAttribute("current_user") == null) { %>
                    <a class="nav-link" href="${pageContext.request.contextPath}/account/login" id="dropdown3" role="button">Login | Register</a>
                    <% } else { %>
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Account
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown3">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/account">Information</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}?logout=true">Logout</a>
                    </div>
                    <% } %>
                </li>

            </ul>
        </div>
    </nav>
</body>
