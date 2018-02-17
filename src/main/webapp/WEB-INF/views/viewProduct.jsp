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

<div class="container">
    <div class="page-header">
        <h1>Product Details</h1>
        <p class="lead">Here is the total information about the Product!</p>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="#" alt="image" style="width: 100%; height: 300px;">
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
            </div>
        </div>
    </div>

</div>

<%@include file="template/footer.jsp" %>

