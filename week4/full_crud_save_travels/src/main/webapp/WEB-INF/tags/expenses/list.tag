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
                <td>${expense.name}</td>
                <td>${expense.vendor}</td>
                <td><fmt:setLocale value="en_us"/> <fmt:formatNumber value="${expense.amount}" type="currency"/></td>
                <td><a href="/expenses/edit/${expense.id}">edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>