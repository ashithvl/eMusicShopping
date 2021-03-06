<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>

<div class="container container-wrapper ">
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">CheckOut all the awesome products available now!</p>
        </div>

    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Product Image</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Condition</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><img src="<c:url value="/resources/images/${product.productId}.png" />"
                         style="width: 300px; height: 150px;" class="img-thumbnail" alt="image"/></td>
                <td>${product.productName}</td>
                <td>${product.productCategory}</td>
                <td>${product.productCondition}</td>
                <td>${product.productPrice} USD</td>
                <td>
                    <a href="<spring:url value="/product/productList/viewProduct/${product.productId}"/>">
                        <span class="glyphicon glyphicon-info-sign"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="template/footer.jsp" %>
