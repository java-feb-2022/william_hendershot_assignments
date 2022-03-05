<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <h1 class="">Edit Book</h1>
                <div class="card">
                    <form:form method="post" action="/books/${book.id}/update" class="card-body" modelAttribute="book">
                        <input type="hidden" name="_method" value="put">
                        <div class="row mb-3">
                            <form:label path="title" class="form-label">Title:</form:label>
                            <form:input path="title" class="form-control"/>
                            <form:errors path="title"/>
                        </div>
                        <div class="row mb-3">
                            <form:label path="description" class="form-label">Description:</form:label>
                            <form:textarea path="description" rows="3" class="form-control"/>
                            <form:errors path="description"/>
                        </div>
                        <div class="row mb-3">
                            <form:label path="language" class="form-label">Language:</form:label>
                            <form:input path="language" class="form-control"/>
                            <form:errors path="language"/>
                        </div>
                        <div class="row mb-3">
                            <form:label path="num_of_pages" class="form-label">Number of pages:</form:label>
                            <form:input path="num_of_pages" class="form-control"/>
                            <form:errors path="num_of_pages"/>
                        </div>
                        <div class="row justify-content-end">
                            <button type="submit" class="col-sm-3 btn btn-primary">Update</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" value="${book}">