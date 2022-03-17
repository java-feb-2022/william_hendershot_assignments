<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<c:forEach var="book_thought" items="${book.bookThoughts}">
<div class="container mt-3">
    <div class="card">
        <div class="card-body">
            <c:choose>
            <c:when test="${book.user.id == user.id}">
                <h5 class="card-title">You read ${book.title}</h5>
                <h6 class="card-subtitle">Here are your thoughts:</h6>
            </c:when>
            <c:otherwise>
                <h5 class="card-title">${book_thought.user.name} read ${book.title} by ${book.author}</h5>
                <h6 class="card-subtitle">Here are ${book_thought.user.name}'s thoughts:</h6>
            </c:otherwise>
            </c:choose>
            <div  class="border-top border-bottom">
                <p>${book_thought.thought}</p>
            </div>
        </div>
    </div>
</div>
</c:forEach>
