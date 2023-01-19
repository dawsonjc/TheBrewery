<!DOCTYPE html>
<html>
<% String title = "The Brewery"; %>
<%@ include file="header.jsp"%>
<body>

<script>
    $(document).ready(function() {
        $.getJSON("${pageContext.request.contextPath}/getAll", function(data) {

        });
    });
</script>
<p id="RESULTS">solid bruh moment fr</p>
</body>
</html>