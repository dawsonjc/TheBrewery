<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tlcm.website.thebrewery.entities.product.alcohol.Wine"%>

<%
    Object temp;
    if((temp = request.getAttribute("alcohol_entity")) == null || !(temp instanceof Wine)) {
        response.sendRedirect(request.getContextPath());
        return;
    }

    Wine entity = (Wine) temp;
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

</body>
</html>
