<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <h1 class="">Create a Book</h1>
            <div class="card">
                <form:form method="post" action="/books" class="card-body" modelAttribute="book_thought">
                    <div class="row mb-3">
                        <form:label path="book.title" for="book_title" class="form-label">Title:</form:label>
                        <form:input path="book.title" type="text" class="form-control" name="book_title"/>
                        <form:errors path="book.title"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="book.author" for="book_author" class="form-label">Author:</form:label>
                        <form:input path="book.author" type="text" class="form-control" name="book_author"/>
                        <form:errors path="book.author"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="thought" for="book_thought" class="form-label">My Thoughts:</form:label>
                        <form:textarea path="thought" rows="3" class="form-control" name="book_thought"></form:textarea>
                    </div>
                    <div class="row mb-3">
                        <form:input path="user" type="hidden" class="form-control" name="user_id" value="${user_id}"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form> 
            </div>
        </div>
    </div>
</div>