<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <c:forEach var="task" items="${project.tasks}">
        <p>Added by ${task.user.firstName} at <fmt:formatDate pattern="h:mm:ssa MMM d" value="${task.createdAt}"/></p>
        <p><c:out value="${task.task}"/></p>
    </c:forEach>
</div>
