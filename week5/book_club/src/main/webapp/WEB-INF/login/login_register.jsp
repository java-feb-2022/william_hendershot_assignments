<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<%@ page isErrorPage="true" %>
<general:layout>
    <div class="container">
        <h1>Book Club</h1>
        <p>A place for friends to share thoughts on books.</p>
    </div>
    <div class="row ">
        <div class="col col-sm-6">
            <login:register/>
        </div>
        <div class="col col-sm-6">
            <login:login/>
        </div>
    </div>
</general:layout>