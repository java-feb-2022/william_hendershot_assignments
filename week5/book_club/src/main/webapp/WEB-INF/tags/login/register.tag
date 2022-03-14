<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <div class="card">
                <form:form method="post" action="/register" class="card-body" modelAttribute="new_user">
                    <div class="row mb-3">
                        <form:label path="name" for="new_user_name" class="form-label">Name:</form:label>
                        <form:input path="name" type="text" class="form-control" name="new_user_name"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="email" for="new_user_email" class="form-label">Email:</form:label>
                        <form:input path="email" type="email" class="form-control" name="new_user_email"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="password" for="new_user_password" class="form-label">Password:</form:label>
                        <form:input path="password" type="password" class="form-control" name="new_user_password"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="confirm" for="new_user_confirm" class="form-label">Confirm PW:</form:label>
                        <form:input path="confirm" type="password" class="form-control" name="new_user_confirm"/>
                        <form:errors path="confirm"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>