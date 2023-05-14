<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tlcm.website.thebrewery.entities.product.alcohol.Beer" %>

<%
    Beer entity = null;
    { // destroy temp
        Object temp;
        if((temp = request.getAttribute("alcohol-entity")) == null || !(temp instanceof Beer)) {
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <table>
                    <thead>
                        <tr>
                            <%= entity.getName() %>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>FUCK</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</body>
<%@ include file="../footer.jsp" %>
</html>
