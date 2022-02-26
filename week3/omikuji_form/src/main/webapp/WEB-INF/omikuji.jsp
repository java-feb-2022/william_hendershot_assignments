<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1 class="">Send an Omikuji!</h1>
                <div class="card">
                    <form method="post" action="/omikuji/send" class="card-body">
                        <div class="row mb-3">
                            <label for="pick_number" class="form-label col-sm">Pick any number from 5 to 25</label>
                            <select class="form-select col-sm-1" name="pick_number">
                                <c:forEach begin="5" end="25" var="i">
                                    <option value="<c:out value='${i}'/>"><c:out value="${i}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="row mb-3">
                            <label for="city" class="form-label">Enter the name of any city</label>
                            <input type="text" class="form-control" name="city">
                        </div>
                        <div class="row mb-3">
                            <label for="person" class="form-label">Enter the name of any real person</label>
                            <input type="text" class="form-control" name="person">
                        </div>
                        <div class="row mb-3">
                            <label for="hobby" class="form-label">Enter professional endeavor or hobby</label>
                            <input type="text" class="form-control" name="hobby">
                        </div>
                        <div class="row mb-3">
                            <label for="animal" class="form-label">Enter any type of living thing</label>
                            <input type="text" class="form-control" name="animal">
                        </div>
                        <div class="row mb-3">
                            <label for="say_something_nice" class="form-label">Say something nice to someone</label>
                            <textarea rows="3" class="form-control" name="say_something_nice"></textarea>
                        </div>
                        <div class="row mb-3">
                            <p>Send and show a friend</p>
                            <div class="row justify-content-end">
                                <button type="submit" class="col-sm-3 btn btn-primary">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:layout>