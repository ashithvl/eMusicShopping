<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">

            <div >
                <a href="${pageContext.request.contextPath}/customer/cart/deleteCart/${carts.cart_id}"
                   class="btn btn-danger pull-right" style="margin-bottom: 12px;">
                    <span class="glyphicon glyphicon-remove-sign"></span> Clear Cart </a>
                <a href="<spring:url value="/order/${carts.cart_id}" />" class="btn btn-success pull-left">
                    Check Out <span class="glyphicon glyphicon-usd"></span>
                </a>
            </div>
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>

                <c:forEach items="${carts.cart_items}" var="cart_items">
                    <tr>
                        <td>${cart_items.getproduct().productName}</td>
                        <td>${cart_items.getproduct().productPrice}</td>
                        <td>${cart_items.getquantity()}</td>
                        <td>${cart_items.gettotal_price()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/customer/cart/remove/${cart_items.getproduct().productId}"
                               class="label label-danger">
                                <span class="glyphicon glyphicon-remove"></span> remove </a></td>

                    </tr>
                </c:forEach>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>${grandTotal}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/product/productList"/>" class="btn btn-default pull-right">Continue Shopping</a>

        </section>

    </div>
</div>
<br>

<%@include file="/WEB-INF/views/template/footer.jsp" %>