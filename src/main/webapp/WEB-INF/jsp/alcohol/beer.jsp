<%@ page import="tlcm.website.thebrewery.entities.AlcoholEntity" %>
<%@ page import="tlcm.website.thebrewery.entities.product.Beer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(request.getAttribute("alcohol_entity") == null) {
        response.sendRedirect("/");
        return;
    }
    Beer entity = (Beer) request.getAttribute("alcohol_entity");
%>

<html>
<% String title = entity.getName(); %>
<%@ include file="../header.jsp" %>
<body>



</body>
<%@ include file="../footer.jsp" %>
</html>
