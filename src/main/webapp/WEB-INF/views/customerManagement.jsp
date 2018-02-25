<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer management Page</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customer_name}</td>
                    <td>${customer.customer_email}</td>
                    <td>${customer.customer_phone}</td>
                    <td>${customer.customer_username}</td>
                    <c:if test="${customer.enabled == true}">
                        <td>active</td>
                    </c:if>
                    <c:if test="${customer.enabled == false}">
                        <td>inactive</td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>
        <div class="pager">
            <br>
            <li>
                <a href="<c:url value="/admin"/>">
                    <span class="glyphicon glyphicon-backward"></span> Back
                </a>
            </li>
        </div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>