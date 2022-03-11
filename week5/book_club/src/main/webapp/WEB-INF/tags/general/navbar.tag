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
                    <a class="nav-link dropdown-toggle" role="button" id="dojosDropdown" data-bs-toggle="dropdown" aria-current="page" href="#">Dojos</a>
                    <ul class="dropdown-menu" aria-labelledby="dojosDropdown">
                        <li><a class="dropdown-item" href="/dojos/new">Add Dojo</a></li>
                        <li><a class="dropdown-item" href="/dojos">List Dojos</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" id="ninjasDropdown" data-bs-toggle="dropdown" aria-current="page" href="#">Ninjas</a>
                    <ul class="dropdown-menu" aria-labelledby="ninjasDropdown">
                        <li><a class="dropdown-item" href="/ninjas/new">Add Ninja</a></li>
                        <li><a class="dropdown-item" href="/ninjas">List Ninjas</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>