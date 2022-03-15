<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<general:layout>
    <div class="container">
        <h1>Showing ${book.title}</h1>
    </div>
    <books:details/>
</general:layout>