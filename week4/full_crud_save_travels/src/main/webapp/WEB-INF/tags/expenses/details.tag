<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <h1>Expense Details</h1>
    <div class="row">
        <p>Expense Name: ${expense.name}</p>
        <p>Expense description: ${expense.description}</p>
        <p>Vendor: ${expense.vendor}</p>
        <p>Amount Spent: <fmt:setLocale value="en_us"/><fmt:formatNumber value="${expense.amount}" type="currency"/></p>
    </div>
</div>