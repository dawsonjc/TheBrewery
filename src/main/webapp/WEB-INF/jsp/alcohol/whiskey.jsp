<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tlcm.website.thebrewery.entities.product.Whiskey"%>

<%
    Object temp;
    if((temp = request.getAttribute("alcohol_entity")) == null || !(temp instanceof Whiskey)) {
        response.sendRedirect("/");
        return;
    }

    Whiskey entity = (Whiskey) temp;
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
</body>
</html>
