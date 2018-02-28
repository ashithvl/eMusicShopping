<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 21-02-18
  Time: 02:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <h2 style="text-align: center;">Login with Username And Password</h2>
        <div class="col-md-offset-3 col-md-6">
            <c:if test="${not empty msg}">
                <div class="alert alert-success alert-dismissable">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/login" />" method="post">

                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>

                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" id="username" autocomplete="off" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="username">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label for="username">Pin: </label>--%>
                    <%--<input type="password" id="pin" name="pin" class="form-control"/>--%>
                <%--</div>--%>
                <%--<p>Please Choose the Algorithm:</p>--%>
                <%--<div class="form-group">--%>
                    <%--<label class="radio-inline">--%>
                        <%--<input type="radio" name="alg">Option 1--%>
                    <%--</label>--%>
                    <%--<label class="radio-inline">--%>
                        <%--<input type="radio" name="alg">Option 2--%>
                    <%--</label>--%>
                    <%--<label class="radio-inline">--%>
                        <%--<input type="radio" name="alg">Option 3--%>
                    <%--</label>--%>
                <%--</div>--%>
                <input type="submit" value="Login" class="btn btn-default"/>

                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>

            </form>
        </div>
    </div>
</div>

<%@include file="template/footer.jsp" %>