<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
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
                            <form:label path="author" class="form-label">Author:</form:label>
                            <form:input path="author" class="form-control"/>
                            <form:errors path="author"/>
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