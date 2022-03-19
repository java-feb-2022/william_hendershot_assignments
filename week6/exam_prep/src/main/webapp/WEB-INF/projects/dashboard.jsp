<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<general:layout>
    <div class="container">
        <h1>Welcome, ${user.firstName}!</h1>
    </div>
    <div class="container">
        <p>All Projects</p>
    </div>
    <projects:joinable_projects/>
    <div class="container">
        <p>Your Projects</p>
    </div>
    <projects:joined_projects/>
</general:layout>