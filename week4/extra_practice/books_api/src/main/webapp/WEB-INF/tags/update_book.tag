<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1 class="">Edit Book</h1>
                    <div class="card">
                        <form:form method="put" action="/books/${book.id}" class="card-body" modelAttribute="book">
                            <div class="row mb-3">
                                <form:label path="title" for="book_title" class="form-label">Title:</form:label>
                                <form:input path="title" type="text" class="form-control" name="book_title" value="${book.title}"/>
                                <form:errors path="title"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="description" for="book_description" class="form-label">Description:</form:label>
                                <form:textarea path="description" rows="3" class="form-control" name="book_description"/>
                                <form:errors path="description"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="language" for="book_language" class="form-label">Language:</form:label>
                                <form:input path="language" type="text" class="form-control" name="book_language" value="${book.language}"/>
                                <form:errors path="language"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="num_of_pages" for="book_num_of_pages" class="form-label">Number of pages:</form:label>
                                <form:input path="num_of_pages" type="number" min="100" class="form-control" name="book_num_of_pages" value="${book.num_of_pages}"/>
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