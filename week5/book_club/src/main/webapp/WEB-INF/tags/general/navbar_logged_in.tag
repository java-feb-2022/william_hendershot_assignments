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
                        <li><a class="dropdown-item" href="#">Add Book</a></li>
                        <li><a class="dropdown-item" href="#">List All Books</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">My Bookshelf</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-secondary" aria-current="page" href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>