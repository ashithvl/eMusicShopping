<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success">Delivery data <small>Enter the desired location information for delivery.</small></h1>
        </div>
        <form:form commandName="order" class="form-horizontal">
            <h3>Shipping Address: </h3>


            <div class="form-group">
                <label for="street"> Street Name </label>
                <form:errors path="cart.customer.shippingAddress.street" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.street" id="street" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="number_apartment"> Apartment Number </label>
                <form:errors path="cart.customer.shippingAddress.number_apartment" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.number_apartment" id="number_apartment" class="form-control"
                            tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="city"> City </label>
                <form:errors path="cart.customer.shippingAddress.city" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.city" id="city" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="state"> State </label>
                <form:errors path="cart.customer.shippingAddress.state" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.state" id="state" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="country"> Country </label>
                <form:errors path="cart.customer.shippingAddress.country" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.country" id="country" class="form-control" tabindex="4"/>
            </div>

            <div class="form-group">
                <label for="zip"> ZipCode </label>
                <form:errors path="cart.customer.shippingAddress.country" cssStyle="color: red"/>
                <form:input path="cart.customer.shippingAddress.zip" id="zip" class="form-control" tabindex="4"/>
            </div>

            <input type="hidden" name="_flowExecutionKey"/>
            <br>
            <%-- BACK/CANCELAR/NEXT  ===========--%>

            <button class="btn btn-danger" tabindex="9" name="_eventId_cancel"> Cancel</button>
            <input type="submit" value="Continue" class="btn btn-primary" tabindex="8"
                   name="_eventId_shippingDetailCollected">
            <button class="btn btn-default" tabindex="10"
                    name="_eventId_backToCollectCustomerInfo"> Back
            </button>
            <br>

        </form:form>

    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>

