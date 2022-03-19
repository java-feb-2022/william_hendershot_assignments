<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<general:layout>
    <div class="container">
        <h1>Project: ${project.title}</h1>
        <p>Project Lead: ${project.teamLead.firstName}</p>
    </div>
    <tasks:create/>
    <tasks:list/>
</general:layout>