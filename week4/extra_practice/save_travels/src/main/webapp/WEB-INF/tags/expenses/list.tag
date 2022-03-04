<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1>All Books</h1>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expenses}">
        <tr>
            <td>${expense.name}</td>
            <td>${expense.vendor}</td>
            <td>${expense.amount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
