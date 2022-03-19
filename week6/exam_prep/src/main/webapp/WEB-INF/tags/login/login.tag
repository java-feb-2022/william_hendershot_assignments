<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <div class="card">
                <form:form method="post" action="/login" class="card-body" modelAttribute="potential_user">
                    <div class="row mb-3">
                        <form:label path="email" for="user_email" class="form-label">Email:</form:label>
                        <form:input path="email" type="text" class="form-control" name="user_email"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="password" for="user_password" class="form-label">Password:</form:label>
                        <form:input path="password" type="password" class="form-control" name="user_password"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>