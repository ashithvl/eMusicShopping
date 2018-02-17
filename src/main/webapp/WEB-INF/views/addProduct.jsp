<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 17-02-18
  Time: 02:56 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <h1>Add Product</h1>
        <p class="lead">Fill the below information to add a Product!</p>

        <form:form action="#" method="post" commandName="product">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="productName" id="name" cssClass="form-control"/>
            </div>

            <label class="input-type">Category</label>
            <div class="radio">
                <label class="radio-inline">
                    <form:radiobutton path="productCategory" id="category" value="Instrument"/>Instrument
                </label>
                <label class="radio-inline">
                    <form:radiobutton path="productCategory" id="category" value="Record"/>Record
                </label>
                <label class="radio-inline">
                    <form:radiobutton path="productCategory" id="category" value="Accessory"/>Accessory
                </label>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea class="form-control" rows="5" id="description" path="productDescription"/>
            </div>

            <div class="form-group">
                <label for="price">Price:</label>
                <form:input class="form-control" id="price" autocomplete="off" placeholder="Price" path="productPrice"/>
            </div>

            <label class="input-type">Condition</label>
            <div class="radio">
                <label class="radio-inline">
                    <form:radiobutton name="optionsRadios" id="condition1" value="New"
                                      path="productCondition"/>New
                </label>
                <label class="radio-inline">
                    <form:radiobutton name="optionsRadios" id="condition1" value="New"
                                      path="productCondition"/>Used
                </label>
            </div>

            <label class="input-type">Status</label>
            <div class="radio">
                <label class="radio-inline">
                        <form:radiobutton name="optionsRadios" id="status1" value="Active"
                                          path="productStatus"/>Active
                    <label class="radio-inline">
                        <form:radiobutton name="optionsRadios" id="status1" value="InActive"
                                          path="productStatus"/>InActive
                    </label>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock:</label>
                <form:input class="form-control" id="unitInStock" autocomplete="off" path="unitInStock"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer:</label>
                <form:input class="form-control" id="manufacturer" autocomplete="off" path="productManufacturer"/>
            </div>

            <%--<div class="form-group">--%>
            <%--<label for="productImage">Product Image:</label>--%>
            <%--<div class="btn btn-default btn-file">--%>
            <%--<form:input type="file" name="productImage" id="productImage" path="file"/>--%>
            <%--</div>--%>
            <%--</div>--%>

            <p><input type="submit" value="Submit" class="btn btn-success"/>
                <a href="<c:url value="/admin/productInventory"/> ">
                    <input type="button" value="Cancel" class="btn btn-danger"/></a></p>
        </form:form>


    </div>


</div>

<%@include file="template/footer.jsp" %>


