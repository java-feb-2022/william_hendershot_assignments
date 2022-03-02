<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <div class="container card">
        <h1><c:out value="${book_title}"/></h1>
        <p>Description: <c:out value="${book_description}"/></p>
        <p>Language: <c:out value="${book_language}"/></p>
        <p>Number of Pages: <c:out value="${book_num_of_pages}"/></p>
    </div>
</t:layout>