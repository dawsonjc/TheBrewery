<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tlcm.website.thebrewery.entities.product.alcohol.Beer" %>

<%
    Beer entity = null;
    { // destroy temp
        Object temp;
        if((temp = request.getAttribute("alcohol_entity")) == null || !(temp instanceof Beer)) {
            response.sendRedirect("/");
            return;
        }

        entity = (Beer) temp;
    }
    String createdBy = (String) request.getAttribute("created-by");

%>

<html>
<% String title = entity.getName(); %>
<%@ include file="../header.jsp" %>
<body>

<table></table>

<table></table>
</body>
<%@ include file="../footer.jsp" %>
</html>
