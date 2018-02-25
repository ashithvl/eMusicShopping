<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <h3>Please fill the in your Information below:</h3>
            <br>
            <h1>User register</h1>
        </div>
        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="customer">
            <h3>User Information: </h3>

            <div class="form-group">
                <label for="name"> Full name </label> <form:errors path="customer_name" cssStyle="color: red"/>
                <form:input path="customer_name" id="name" class="form-control" tabindex="1"/>
            </div>

            <div class="form-group">
                <label for="email"> Email </label>  <form:errors path="customer_name" cssStyle="color: red"/>
                <form:input path="customer_email" id="email" class="form-control" tabindex="2"/>
            </div>

            <div class="form-group">
                <label for="phone"> Telephone (10 digits) </label>
                <form:errors path="customer_phone" cssStyle="color: red"/>
                <form:input path="customer_phone" id="phone" class="form-control" tabindex="3"/>
            </div>

            <div class="form-group">
                <label for="username"> Username </label>  <form:errors path="customer_name" cssStyle="color: red"/>
                <form:input path="customer_username" id="username" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="password"> Password </label>
                <form:errors path="customer_password" cssStyle="color: red"/>
                <form:password path="customer_password" id="password" class="form-control" tabindex="5"/>
            </div>


            <h3>Billing Address: </h3>


            <div class="form-group">
                <label for="street"> Street Name </label>
                <form:errors path="billingAddress.street" cssStyle="color: red"/>
                <form:input path="billingAddress.street" id="street" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="number_apartment"> Apartment Number </label>
                <form:errors path="billingAddress.number_apartment" cssStyle="color: red"/>
                <form:input path="billingAddress.number_apartment" id="number_apartment" class="form-control"
                            tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="city"> City </label>
                <form:errors path="billingAddress.city" cssStyle="color: red"/>
                <form:input path="billingAddress.city" id="city" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="state"> State </label>
                <form:errors path="billingAddress.state" cssStyle="color: red"/>
                <form:input path="billingAddress.state" id="state" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="country"> Country </label>
                <form:errors path="billingAddress.country" cssStyle="color: red"/>
                <form:input path="billingAddress.country" id="country" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="zip"> ZipCode </label>
                <form:errors path="billingAddress.country" cssStyle="color: red"/>
                <form:input path="billingAddress.zip" id="zip" class="form-control" tabindex="4"/>
            </div>

            <br>

            <h3>Shipping Address: </h3>


            <div class="form-group">
                <label for="street"> Street Name </label>
                <form:errors path="shippingAddress.street" cssStyle="color: red"/>
                <form:input path="shippingAddress.street" id="street" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="number_apartment"> Apartment Number </label>
                <form:errors path="shippingAddress.number_apartment" cssStyle="color: red"/>
                <form:input path="shippingAddress.number_apartment" id="number_apartment" class="form-control"
                            tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="city"> City </label>
                <form:errors path="shippingAddress.city" cssStyle="color: red"/>
                <form:input path="shippingAddress.city" id="city" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="state"> State </label>
                <form:errors path="shippingAddress.state" cssStyle="color: red"/>
                <form:input path="shippingAddress.state" id="state" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="country"> Country </label>
                <form:errors path="shippingAddress.country" cssStyle="color: red"/>
                <form:input path="shippingAddress.country" id="country" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="zip"> ZipCode </label>
                <form:errors path="shippingAddress.country" cssStyle="color: red"/>
                <form:input path="shippingAddress.zip" id="zip" class="form-control" tabindex="4"/>
            </div>

            <br>
            <%-- SUBMIT/CANCEL BUTTON  ===========--%>
            <a href="<c:url value="/" />" class="btn btn-default" tabindex="19"> Cancel </a>
            <input type="submit" value="Register" class="btn btn-primary" tabindex="18">
        </form:form>

    </div>
</div>


<%@include file="template/footer.jsp" %>
