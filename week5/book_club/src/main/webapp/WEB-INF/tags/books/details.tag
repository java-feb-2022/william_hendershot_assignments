<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container card">
    <h1>${book_title}</h1>
    <p>Author: ${book_description}</p>
    <div class="row">
        <form method="get" action="/books/<c:out value='${book_id}'/>/update" class="col">
            <button type="submit" class="col-sm-3 btn btn-primary">Edit</button>
        </form>
        <form method="post" action="/books/<c:out value='${book_id}'/>/delete" class="col">
            <button type="submit" class="col-sm-3 btn btn-primary">Delete</button>
        </form>
    </div>
</div>