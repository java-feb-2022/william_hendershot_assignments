<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<general:layout>
    <div class="container">
        <h1>Welcome, ${user.name}</h1>
        <p>Books from everyone's shelves:</p>
    </div>
    <books:list/>
</general:layout>