<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<%@ page isErrorPage="true" %>
<general:layout>
    <div class="container">
        <h1 class="text-center">Project Manager</h1>
        <p class="text-center">A place for teams to manage projects.</p>
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