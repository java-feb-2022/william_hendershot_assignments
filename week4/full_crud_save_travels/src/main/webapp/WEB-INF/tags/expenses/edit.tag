<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <h1 class="">Edit an Expense:</h1>
            <div class="card">
                <form:form method="post" action="/expenses/edit/${expense.id}" class="card-body" modelAttribute="expense">
                    <input type = "hidden" name="_method" value="put">
                    <div class="row mb-3">
                        <form:label path="name" for="expense_name" class="form-label">Expense Name:</form:label>
                        <form:input path="name" type="text" class="form-control" name="expense_name"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="vendor" for="expense_vendor" class="form-label">Vendor:</form:label>
                        <form:input path="vendor" class="form-control" name="expense_vendor"/>
                        <form:errors path="vendor"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="amount" for="expense_amount" class="form-label">Amount:</form:label>
                        <form:input path="amount" type="number" step="0.01" class="form-control" name="expense_amount"/>
                        <form:errors path="amount"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="description" for="expense_description" class="form-label">Description:</form:label>
                        <form:textarea path="description" rows="3" class="form-control" name="expense_description"></form:textarea>
                        <form:errors path="description"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>