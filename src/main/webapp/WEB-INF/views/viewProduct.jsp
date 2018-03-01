<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 17-02-18
  Time: 02:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 17-02-18
  Time: 02:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>

<div class="container container-wrapper ">
    <div class="page-header">
        <h1>Product Details</h1>
        <p class="lead">Here is the total information about the Product!</p>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${product.productId}.png" />" class="img-thumbnail"
                     alt="image" style="width: 100%; height: auto;">
            </div>
            <div class="col-md-5">
                <h3>${product.productName}</h3>
                <p>${product.productDescription}</p>
                <p>
                    <strong>Manufacturer</strong> : ${product.productManufacturer}
                </p>
                <p>
                    <strong>Category</strong> : ${product.productCategory}
                </p>
                <p>
                    <strong>Condition</strong> : ${product.productCondition}
                </p>
                <p>
                    <strong>Price</strong> : ${product.productPrice} USD
                </p>
                <br>
                <p>
                    <a href="<c:url value="/product/productList" />" class="btn btn-default">Back</a>
                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <a href="<c:url value="/customer/cart/add/${product.productId}"/>"
                           class="btn btn-warning btn-large">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Order Now
                        </a>
                        <a href="<spring:url value="/customer/cart"/>"
                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </c:if>
                </p>

            </div>
        </div>
    </div>

</div>

<%@include file="template/footer.jsp" %>

