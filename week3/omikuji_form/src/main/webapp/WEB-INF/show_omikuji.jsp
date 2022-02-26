<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <div class="container">
        <div class="row">
            <h1>Here's Your Omikuji!</h1>
            <div class="card bg-info">
                <p>In <c:out value="${pick_number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${hobby}"/> for a living.  The next time you see a <c:out value="${animal}"/>, you will have good luck. Also, <c:out value="${say_something_nice}"/>.</p>
            </div>
        </div>
    </div>
</t:layout>