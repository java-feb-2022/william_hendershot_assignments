<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container card">
    <h1><c:out value="${book_title}"/></h1>
    <p>Description: <c:out value="${book_description}"/></p>
    <p>Language: <c:out value="${book_language}"/></p>
    <p>Number of Pages: <c:out value="${book_num_of_pages}"/></p>
    <form method="get" action="/books/<c:out value='${book_id}'/>/update">
        <div class="row justify-content-center">
            <button type="submit" class="col-sm-3 btn btn-primary">Edit</button>
        </div>
    </form>
</div>