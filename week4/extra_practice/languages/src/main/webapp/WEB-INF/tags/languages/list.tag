<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h1>All Languages</h1>
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="language" items="${languages}">
            <tr>
                <td><a href="languages/${language.id}">${language.name}</a></td>
                <td>${language.creator}</td>
                <td>${language.version}</td>
                <td class="col">
                    <div class="row justify-content-between">
                        <a class="col" href="/languages/${language.id}/edit">edit</a>
                        <form class="col" action="/languages/${language.id}/delete" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" class="btn btn-warning" value="delete">
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>