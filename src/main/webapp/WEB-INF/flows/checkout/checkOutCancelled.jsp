<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div>
            <br>
            <section>
                <div class="row text">
                    <div class="col-md-8">
                        <h1 class="alert alert-danger"><strong>Buy Canceled!</strong></h1>
                        <p>You can continue buying if you wish.</p>
                    </div>
                </div>
            </section>
            <section>
                <p>
                    <a href="<spring:url value="/product/productList"/>" class="btn btn-primary">View Product</a>
                </p>
            </section>
        </div>
    </div>
</div>
<br>
<br>
<br>
<%@include file="/WEB-INF/views/template/footer.jsp" %>