<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <h1 class="">Create a Project</h1>
            <div class="card">
                <form:form method="post" action="/projects/new" class="card-body" modelAttribute="new_project">
                    <div class="row mb-3">
                        <form:label path="title" for="project_title" class="form-label">Project Title:</form:label>
                        <form:input path="title" type="text" class="form-control" name="project_title"/>
                        <form:errors path="title"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="description" for="project_description" class="form-label">Project Description:</form:label>
                        <form:textarea path="description" rows="3" class="form-control" name="Project Description"></form:textarea>
                        <form:errors path="description"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="dueDate" for="project_due_date" class="form-label">Due Date:</form:label>
                        <form:input path="dueDate" type="date" class="form-control" name="project_due_date"/>
                        <form:errors path="dueDate"/>
                    </div>
                    <div class="row mb-3">
                        <form:input path="teamLead" type="hidden" class="form-control" name="team_leaduser_id" value="${user_id}"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form> 
            </div>
        </div>
    </div>
</div>