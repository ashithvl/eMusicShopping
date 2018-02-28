<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 21-02-18
  Time: 02:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 17-02-18
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>eMusicShopping</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/"/> ">My Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="${home}"><a href="<c:url value="/"/> ">Home</a></li>
                        <li class="${productClass}"><a href="<c:url value="/product/productList"/> ">Products</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/logout"/> ">Logout</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin"/> ">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="<c:url value="/login"/> ">Login</a></li>
                            <li><a href="<c:url value="/register"/> ">Register</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>

</div>

<div class="container-wrapper">
    <div class="container">
        <h2 style="text-align: center;">Login with Pin And Algorithm</h2>
        <div class="col-md-offset-3 col-md-6">
            <form name="loginForm" action="<c:url value="/loginPin" />" method="post">

                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <div class="form-group">
                <label for="pin">Pin: </label>
                <input type="password" id="pin" name="pin" class="form-control" maxlength="4"/>
            </div>
                <p>Please Choose the Algorithm:</p>
                <div class="form-group">
                    <label class="radio-inline">
                        <input type="radio" name="alg" value="1">MD5
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="alg" value="2">SHA-512
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="alg" value="3">PBKDF2
                    </label>
                </div>
                <input type="submit" value="Login" class="btn btn-default"/>

                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>

            </form>
        </div>
    </div>
</div>

<%@include file="template/footer.jsp" %>