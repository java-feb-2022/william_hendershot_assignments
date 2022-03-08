<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <h1>Language Details</h1>
    <div class="row">
        <p>Name: ${language.name}</p>
        <p>Creator: ${language.creator}</p>
        <p>Version: ${language.version}</p>
    </div>
    <div class="row justify-content-between">
        <a class="col" href="/languages/${language.id}/edit">edit</a>
        <form class="col" action="/languages/${language.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" class="btn btn-warning" value="delete">
        </form>
    </div>
</div>