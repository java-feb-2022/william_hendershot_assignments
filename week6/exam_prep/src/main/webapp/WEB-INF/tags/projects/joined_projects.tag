<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Project</th>
                <th>Team Lead</th>
                <th>Due Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="project" items="${my_projects}">
            <tr>
                <td><a href='/projects/${project.id}'>${project.title}</a></td>
                <td>${project.teamLead.firstName}</td>
                <td><fmt:formatDate pattern='MMM dd, yyyy' value='${project.dueDate}'/></td>
                <td class="d-flex flex-row justify-content-around">
                    <c:if test="${user_id == project.teamLead.id}">
                        <a href='/projects/${project.id}/edit'>Edit</a>
                        <p>||</p>
                    </c:if>
                    <form method="post" action="/projects/${project.id}/leave">
                        <p class="text-decoration-underline text-primary" onclick="this.parentNode.submit();">Leave team</p>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
