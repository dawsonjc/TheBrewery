<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boolean result = false;
    if(request.getParameter("result") != null) {
         result = !Boolean.parseBoolean(request.getParameter("result"));
    }
%>


<html>
<% String title = "Login"; %>
<%@ include file="header.jsp" %>
<body>
    <script type="text/javascript">
        if(<%= result %>) {
            alert("Fuckin' moron")
        }
    </script>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3>Login</h3>
                <form:form action="${pageContext.request.contextPath}/account/login/verify" method="post" modelAttribute="current_user">
                    <form:label path="username">Username</form:label>
                    <form:input path="username" type="text" placeholder="username" />
                    <br/>
                    <form:label path="password">Password</form:label>
                    <form:input path="password" type="password" />
                    <br/>
                    <form:button>submit</form:button>
                </form:form>
            </div>
            <div class="col-md-6">
                <h3>Register</h3>
                <form:form action="${pageContext.request.contextPath}/account/register" method="post" modelAttribute="new_user">
                    <form:label path="firstName">First Name</form:label>
                    <form:input path="firstName" type="text" placeholder="First Name" />
                    <br/>
                    <form:label path="lastName">Last Name</form:label>
                    <form:input path="lastName" type="text" placeholder="Last Name" />
                    <br/>
                    <form:label path="username">Username</form:label>
                    <form:input path="username" type="text" placeholder="username" />
                    <br/>
                    <form:label path="password">Password</form:label>
                    <form:input path="password" type="password" />
                    <br/>
                    <form:button>submit</form:button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
