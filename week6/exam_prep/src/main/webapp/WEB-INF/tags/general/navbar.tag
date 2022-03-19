<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar 0.1</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" id="projectsDropdown" data-bs-toggle="dropdown" aria-current="page" href="#">Projects</a>
                    <ul class="dropdown-menu" aria-labelledby="projectsDropdown">
                        <li><a class="dropdown-item" href="/projects">Dashboard</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/projects/new">New Project</a></li>
                    </ul>
                </li>
                <c:if test="${user_id != null && user_id > 0}">
                    <li class="nav-item">
                        <form class="col" action="/logout" method="post">
                            <input type="submit" class="btn btn-primary" value="Logout">
                        </form>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>