<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h1>All Dojos</h1>
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="dojo" items="${dojos}">
            <tr>
                <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
                <td class="col">
                    <div class="row justify-content-between">
                        <a class="col" href="/dojos/${dojo.id}/edit">edit</a>
                        <form class="col" action="/dojos/${dojo.id}" method="post">
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