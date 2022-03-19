<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container card">
    <h1>Edit Project</h1>
    <form:form method="post" action="/projects/${project.id}" modelAttribute="project">
        <input type="hidden" name="_method" value="put">
        <div class="row">
            <form:label path="title" for="project_title" class="col-sm-2 col-form-label form-label">Project Title:</form:label>
            <form:input path="title" type="text" class="form-control col-sm-10" name="project_title" value="${project.title}"/>
            <form:errors path="title"/>
        </div>
        <div class="row">
            <form:label path="description" for="project_description" class="col-sm-2 col-form-label form-label">Project Description:</form:label>
            <form:textarea path="description" rows="3" class="form-control col-sm-10" name="project_description" value="${project.description}"/>
            <for:errors path="description"/>
        </div>
        <div class="row">
            <form:label path="dueDate" for="poject_dueDate" class="col-sm-2 col-form-label">Due Date:</form:label>
            <fmt:formatDate pattern='yyyy-MM-dd' value='${project.dueDate}' var="project_dueDate"/>
            <form:input path="dueDate" type="date" class="form-control col-sm-10" name="project_dueDate" value="${project_dueDate}"/>
            <form:errors path="dueDate"/>
        </div>
        <div class="row justify-content-end">
            <a href="/projects/${project.id}" class="me-3 col-2 btn btn-primary">Cancel</a>
            <button type="submit" class="col-2 btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>