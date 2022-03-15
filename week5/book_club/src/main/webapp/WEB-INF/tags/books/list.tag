<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author Name</th>
                <th>Posted By</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td><a href='/books/${book.id}'>${book.title}</a></td>
                <td>${book.author}</td>
                <td>${book.user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
