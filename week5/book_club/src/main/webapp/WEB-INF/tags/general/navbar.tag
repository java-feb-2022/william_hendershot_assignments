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
                    <a class="nav-link dropdown-toggle" role="button" id="booksDropdown" data-bs-toggle="dropdown" aria-current="page" href="#">Books</a>
                    <ul class="dropdown-menu" aria-labelledby="booksDropdown">
                        <li><a class="dropdown-item" href="/books/new">Add Book</a></li>
                        <li><a class="dropdown-item" href="/books">List Books</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" id="thoughtsDropdown" data-bs-toggle="dropdown" aria-current="page" href="#">Thoughts</a>
                    <ul class="dropdown-menu" aria-labelledby="thoughtsDropdown">
                        <li><a class="dropdown-item" href="/thoughts">Thoughts</a></li>
                    </ul>
                </li>
                <c:if test = "${user_id}">
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