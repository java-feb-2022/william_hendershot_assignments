<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container card">
    <h1>${book.title}</h1>
    <p>Author: ${book.author}</p>
    <div class="row">
        <form method="get" action="/books/${book.id}/update" class="col">
            <button type="submit" class="col-sm-3 btn btn-primary">Edit</button>
        </form>
        <c:if test="${book.user.id == user.id}">
            <form method="post" action="/books/${book.id}/delete" class="col">
                <input type="hidden" name="_method" value="delete"/>
                <button type="submit" class="col-sm-3 btn btn-primary">Delete</button>
            </form>
        </c:if>
    </div>
</div>