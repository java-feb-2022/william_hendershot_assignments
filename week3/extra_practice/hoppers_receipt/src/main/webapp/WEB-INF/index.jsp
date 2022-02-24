<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
</head>
<body>
    <h1>Customer Name: <c:out value="${customer_name}"/></h1>
    <p>Item name: <c:out value="${item_name}"/></p>
    <p>Price: $<c:out value="${item_price}"/></p>
    <p>Description <c:out value="${item_description}"/></p>
    <p>Vendor: <c:out value="${item_vendor}"/></p>
</body>
</head>
