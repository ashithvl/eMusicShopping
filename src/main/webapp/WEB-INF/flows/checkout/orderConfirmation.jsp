<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fwt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <div class="col-md-6"></div>
            <br>
            <h1 class="alert alert-success text-center">Purchase receipt</h1>
        </div>

        <div class="container">
            <div class="row">

                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Receipt</h1>
                            <hr>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <b>DShipping</b>
                                    <br>
                                        ${order.cart.customer.shippingAddress.street}
                                    <br>
                                        ${order.cart.customer.shippingAddress.number_apartment}
                                    <br>
                                        ${order.cart.customer.shippingAddress.city}, ${order.cart.customer.shippingAddress.state}
                                    <br>
                                        ${order.cart.customer.shippingAddress.country}, ${order.cart.customer.shippingAddress.zip}
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p><b>Shipping Date: </b><fwt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <b>Billing Address</b>
                                    <br>
                                        ${order.cart.customer.billingAddress.street}
                                    <br>
                                        ${order.cart.customer.billingAddress.number_apartment}
                                    <br>
                                        ${order.cart.customer.billingAddress.city}, ${order.cart.customer.billingAddress.state}
                                    <br>
                                        ${order.cart.customer.billingAddress.country}, ${order.cart.customer.billingAddress.zip}
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hoover table-condensed">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cart_items}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.getproduct().productName}</em></td>
                                        <td class="col-md-1 text-center">${cartItem.getquantity()}</td>
                                        <td class="col-md-1 text-center">
                                            <fmt:formatNumber
                                                    type="currency">${cartItem.getproduct().productPrice}</fmt:formatNumber>
                                        </td>
                                        <td class="col-md-1 text-center">
                                            <fmt:formatNumber
                                                    type="currency">${cartItem.gettotal_price()}</fmt:formatNumber>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>

                                    <td colspan="2" class="text-right">
                                        <h4><strong>Grant Total: </strong></h4>
                                    </td>
                                    <td colspan="2" class="text-right precio">
                                        <h4><strong>$ ${order.cart.gran_total} $</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <input type="hidden" name="_flowExecutionKey"/>

                        <br><br>
                            <%-- BACK/CANCELAR/NEXT  ===========--%>

                        <button class="btn btn-danger" tabindex="13" name="_eventId_cancel">
                            Cancel
                        </button>
                        <input type="submit" value="Submit Order" class="btn btn-success" tabindex="12"
                               name="_eventId_orderConfirmed">
                        <button class="btn btn-default" tabindex="14"
                                name="_eventId_backToCollectShippingDetail"> Back
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>

