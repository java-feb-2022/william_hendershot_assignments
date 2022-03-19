<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container card">
    <h1>Project Details</h1>
    <div class="row">
        <label for="project_title" class="col-sm-2 col-form-label">Project Title:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control-plaintext" name="project_title" value="${project.title}">
        </div>
    </div>
    <div class="row">
        <label for="project_description" class="col-sm-2 col-form-label">Project Description:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control-plaintext" name="project_description" value="${project.description}">
        </div>
    </div>
    <div class="row">
        <label for="project_dueDate" class="col-sm-2 col-form-label">Due Date:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control-plaintext" name="project_dueDate" value="<fmt:formatDate pattern='M/dd/yyyy' value='${project.dueDate}'/>">
        </div>
    </div>
    <div class="row">
        <c:if test="${project.teamLead.id == user_id}">
            <form method="get" action="/projects/${project.id}/edit" class="col">
                <button type="submit" class="col-sm-3 btn btn-primary">Edit</button>
            </form>
            <form method="post" action="/projects/${project.id}/delete" class="col">
                <input type="hidden" name="_method" value="delete"/>
                <button type="submit" class="col-sm-3 btn btn-danger">Delete</button>
            </form>
        </c:if>
    </div>
</div>