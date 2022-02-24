<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Date</title>
        
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
	    
	    <link rel="stylesheet" type="text/css" href="/css/date.css">
        <script type="text/javascript" src="js/date.js" defer></script>
	    
    </head>
    <body>
        <div class="container">
	        <div class="row">
	            <div class="col col-sm-12">
	                <p class="date"><c:out value="${date}"/></p>
	            </div>
	        </div>
        </div>
    </body>
</html>