<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1 class="">Add a Book to Your Shelf!</h1>
                    <div class="card">
                        <form:form method="post" action="/shelf" class="card-body" modelAttribute="bookThought">
                            <div class="row mb-3">
                                <form:label path="book.title" for="book_title" class="form-label">Title:</form:label>
                                <form:input path="book.title" type="text" class="form-control" name="book_title"/>
                                <form:errors path="book.title"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="book.author" for="book_author" class="form-label">Language:</form:label>
                                <form:input path="book.author" type="text" class="form-control" name="book_author"/>
                                <form:errors path="book.author"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="thought" for="book_thought" class="form-label">My thoughts:</form:label>
                                <form:textarea path="thought" rows="3" class="form-control" name="book_thought"></form:textarea>
                                <form:errors path="thought"/>
                            </div>
                            <div class="row justify-content-end">
                                <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>