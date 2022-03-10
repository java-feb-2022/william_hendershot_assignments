<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <h1>Ninja Details</h1>
    <div class="row">
        <p>First Name: ${ninja.first_name}</p>
        <p>Last Name: ${ninja.last_name}</p>
        <p>Age: ${ninja.age}</p>
        <p>Dojo: ${dojo.name}</p>
    </div>
    <div class="row justify-content-between">
        <a class="col" href="/ninjas/${ninja.id}/edit">edit</a>
        <form class="col" action="/ninjas/${ninja.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" class="btn btn-warning" value="delete">
        </form>
    </div>
</div>