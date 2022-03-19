<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <form:form method="post" action="/projects/${project.id}/tasks" class="card-body" modelAttribute="new_task">
                <div class="row mb-3">
                    <form:label path="task" for="task" class="form-label">Add a task ticket for this team:</form:label>
                    <form:textarea path="task" rows="3" class="form-control" name="task"/>
                    <form:errors path="task"/>
                </div>
                <form:input path="user" type="hidden" value="${task.user.id}"/>
                <form:input path="project" type="hidden" value="${task.project.id}"/>
                <div class="row justify-content-end">
                    <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                </div>
            </form:form> 
        </div>
    </div>
</div>