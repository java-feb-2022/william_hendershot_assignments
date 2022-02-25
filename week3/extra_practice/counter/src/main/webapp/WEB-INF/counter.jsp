<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1>You have visited <a href="https://localhost:8080">localhost</a> <c:out value="${counter}"/> times.</h1>
            </div>
        </div>
        <div class="row">
            <div class="col col-sm-12">
                <h1><a href="http://localhost:8080">Test another visit?</a></h1>
            </div>
        </div>
        <div class="row">
            <form action="http://localhost:8080/resetCounter">
                <button type="submit" class="btn btn-primary">Reset Counter</button>
            </form>
        </div>
    </div>
</t:layout>