<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1>All Books</h1>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.getId()}"/></td>
            <td><a href='/books/<c:out value="${book.getId()}"/>'><c:out value="${book.getTitle()}"/></a></td>
            <td><c:out value="${book.getLanguage()}"/></td>
            <td><c:out value="${book.getNum_of_pages()}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
