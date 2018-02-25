<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success"> Customer's information <small>  (confirm that your information is correct)</small></h1>
            <hr>
            <form:form commandName="order" class="form-horizontal">
                <h3>User Information: </h3>
                <div class="form-group">
                    <label for="name"> Full name </label>
                    <form:errors path="cart.customer.customer_name" cssStyle="color: red"/>
                    <form:input path="cart.customer.customer_name" id="name" class="form-control" tabindex="1"/>
                </div>

                <div class="form-group">
                    <label for="email"> Email </label>  <form:errors path="cart.customer.customer_name" cssStyle="color: red"/>
                    <form:input path="cart.customer.customer_email" id="email" class="form-control" tabindex="2"/>
                </div>

                <div class="form-group">
                    <label for="phone"> Telephone (10 digits) </label>
                    <form:errors path="cart.customer.customer_phone" cssStyle="color: red"/>
                    <form:input path="cart.customer.customer_phone" id="phone" class="form-control" tabindex="3"/>
                </div>

                <div class="form-group">
                    <label for="username"> Username </label>  <form:errors path="cart.customer.customer_name" cssStyle="color: red"/>
                    <form:input path="cart.customer.customer_username" id="username" class="form-control" tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="password"> Password </label>
                    <form:errors path="cart.customer.customer_password" cssStyle="color: red"/>
                    <form:password path="cart.customer.customer_password" id="password" class="form-control" tabindex="5"/>
                </div>


                <h3>Billing Address: </h3>


                <div class="form-group">
                    <label for="street"> Street Name </label>
                    <form:errors path="cart.customer.billingAddress.street" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.street" id="street" class="form-control" tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="number_apartment"> Apartment Number </label>
                    <form:errors path="cart.customer.billingAddress.number_apartment" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.number_apartment" id="number_apartment" class="form-control"
                                tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="city"> City </label>
                    <form:errors path="cart.customer.billingAddress.city" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.city" id="city" class="form-control" tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="state"> State </label>
                    <form:errors path="cart.customer.billingAddress.state" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.state" id="state" class="form-control" tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="country"> Country </label>
                    <form:errors path="cart.customer.billingAddress.country" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.country" id="country" class="form-control" tabindex="4"/>
                </div>

                <div class="form-group">
                    <label for="zip"> ZipCode </label>
                    <form:errors path="cart.customer.billingAddress.country" cssStyle="color: red"/>
                    <form:input path="cart.customer.billingAddress.zip" id="zip" class="form-control" tabindex="4"/>
                </div>

                <input type="hidden" name="_flowExecutionKey"/>
                <br>

                <%-- CANCEL/NEXT  ===========--%>
                <button class="btn btn-danger" tabindex="9" name="_eventId_cancel"> Cancel </button>
                <input type="submit" value="Continue" class="btn btn-primary" tabindex="8"
                       name="_eventId_customerInfoCollected">


            </form:form>


        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>

