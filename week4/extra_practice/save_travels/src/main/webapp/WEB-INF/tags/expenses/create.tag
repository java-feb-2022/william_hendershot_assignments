<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1 class="">Add an Expanse:</h1>
                <p>Errors will go here, when/if there are any.</p>
                    <div class="card">
                        <form:form method="post" action="/expenses" class="card-body">
                            <div class="row mb-3">
                                <form:label path="expense" for="expense_name" class="form-label">Expense Name:</form:label>
                                <form:input path="expense" type="text" class="form-control" name="expense_name"/>
                                <form:errors path="expense"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path ="expense" for="expense_vendor" class="form-label">Vendor:</form:label>
                                <form:input path="expense" class="form-control" name="expense_vendor"/>
                                <form:errors path="expense"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="expense" for="expense_amount" class="form-label">Amount:</form:label>
                                <form:input path="expense" type="number" min="0.01" class="form-control" name="expense_amount"/>
                                <form:errors path="expense"/>
                            </div>
                            <div class="row mb-3">
                                <form:label path="expense" for="expense_description" class="form-label">Description:</form:label>
                                <from:textarea path="expense" rows=3 class="form-control" name="expense_description"></form:textarea>
                            </div>
                            <div class="row justify-content-end">
                                <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>