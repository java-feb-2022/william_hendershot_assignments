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
        <c:forEach var="project" items="${projects}">
            <tr>
                <td><a href='/projects/${project.id}'>${project.title}</a></td>
                <td>${project.teamLead.firstName}</td>
                <td>${project.dueDate}</td>
                <td>
                    <p>Something to do</p>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
