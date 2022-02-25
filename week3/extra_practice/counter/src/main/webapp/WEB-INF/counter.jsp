<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Current Visit Count</title>
    
        <link 
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
            crossorigin="anonymous">
        <script 
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" 
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" 
            crossorigin="anonymous" defer>
        </script>
        <script 
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" 
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" 
            crossorigin="anonymous" defer>
        </script>
        
        
        
    </head>
    
    <body>
        <div class="container">
	        <div class="row">
	            <div class="col col-sm-12">
                    <h1>You have visited <a href="https://localhost:8080">localhost</a> <c:out value="${counter}"/> times.</h1>
	            </div>
	        </div>
	        <div class="row">
	            <div class="col col-sm-12">
                    <h1><a href="http://localhost:8080">Test another visit?</a></h1>
	            </div>
	        </div>
            <div class="row">
                <form action="http://localhost:8080/resetCounter">
                    <button type="submit" class="btn btn-primary">Reset Counter</button>
                </form>
            </div>
        </div>
    </body>
</html>