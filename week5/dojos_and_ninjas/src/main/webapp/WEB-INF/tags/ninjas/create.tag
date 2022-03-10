<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <div class="card">
                <form:form method="post" action="/ninjas" class="card-body" modelAttribute="ninja">
                    <div class="row mb-3">
                        <form:label path="dojo" for="dojo_name" class="col-sm-3 col-form-label">Dojo:</form:label>
                        <div class="col-sm-9">
                            <form:select path="dojo" name="dojo_id" class="form-select">
                                <form:options items="${dojos}" itemValue="id" itemLabel="name"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <form:label path="first_name" for="ninja_first_name" class="form-label">First Name:</form:label>
                        <form:input path="first_name" type="text" class="form-control" name="ninja_first_name"/>
                        <form:errors path="first_name"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="last_name" for="ninja_last_name" class="form-label">Last Name:</form:label>
                        <form:input path="last_name" class="form-control" name="ninja_last_name"/>
                        <form:errors path="last_name"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="age" for="ninja_age" class="form-label">Age:</form:label>
                        <form:input path="age" class="form-control" name="ninja_age"/>
                        <form:errors path="age"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>