<%@ page import="tlcm.website.thebrewery.entities.users.Users" %>

<%
    Users user;
    { // do not persist temp
        Object temp;

        // if the request is not there or the request is there but it is not an instance of Users
        // send back home
        // TODO: error page
        if((temp = request.getSession().getAttribute("current_user")) == null || !(temp instanceof Users)) {
            response.sendRedirect("/");
            return;
        }
        user = (Users) temp;
    }

%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String title = "Account Information"; %>
<%@ include file="header.jsp"%>
<body>


<table>
    <tr></tr>
    <tr></tr>
</table>
</body>
</html>
