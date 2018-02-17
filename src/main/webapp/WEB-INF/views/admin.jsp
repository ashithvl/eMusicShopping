<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 17-02-18
  Time: 01:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Administrator Page</h1>
        <p class="lead">This is Administrator Page!</p>
    </div>
    <h3><a href="<c:url value="/admin/productInventory"/> ">Product Inventory</a></h3>
    <p>
        Here you can view, edit and Modify the product Inventory!
    </p>
</div>


<%@include file="template/footer.jsp" %>
