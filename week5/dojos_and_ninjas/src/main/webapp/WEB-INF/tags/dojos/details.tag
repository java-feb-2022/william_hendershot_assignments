<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<div class="container">
    <h1>Dojos Detail</h1>
    <div class="row">
        <p>Name: ${dojo.name}</p>
    </div>
    <div class="row justify-content-between">
        <a class="col" href="/dojos/${dojo.id}/edit">edit</a>
        <form class="col" action="/dojos/${dojo.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" class="btn btn-warning" value="delete">
        </form>
    </div>
    <ninjas:list></ninjas:list>
</div>