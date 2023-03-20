<%@ page import="tlcm.website.thebrewery.entities.users.Users" %>
<%@ page import="tlcm.website.thebrewery.entities.users.UserType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Users user;
    { // drop temp
        Object temp;

        if((temp = request.getSession().getAttribute("current_user")) == null || !(temp instanceof Users)) {
            response.sendRedirect("/");
            return;
        }

        user = (Users) temp;
        if(user.getType() != UserType.ADMIN) {
            response.sendRedirect("/");
            return;
        }
    }
%>


<html>
<% final String title = "Admin Page"; %>
<%@ include file ="header.jsp" %>
<body>

</body>
</html>
