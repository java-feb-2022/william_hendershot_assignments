<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h1>All Ninjas</h1>
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="ninja" items="${ninjas}">
            <tr>
                <td>${ninja.first_name}</td>
                <td>${ninja.last_name}</td>
                <td>${ninja.age}</td>
                <td class="col">
                    <div class="row justify-content-between">
                        <a class="col" href="/ninjas/${ninja.id}/edit">edit</a>
                        <form class="col" action="/ninjas/${ninja.id}/delete" method="post">
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