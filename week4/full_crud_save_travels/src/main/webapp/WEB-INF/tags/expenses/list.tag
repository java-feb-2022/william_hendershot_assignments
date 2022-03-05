<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h1>All Books</h1>
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td><a href="expenses/${expense.id}">${expense.name}</a></td>
                <td>${expense.vendor}</td>
                <td><fmt:setLocale value="en_us"/> <fmt:formatNumber value="${expense.amount}" type="currency"/></td>
                <td class="row justify-content-between">
                    <a class="col" href="/expenses/edit/${expense.id}">edit</a>
                    <form class="col" action="/expenses/delete/${expense.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" class="btn btn-warning" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>