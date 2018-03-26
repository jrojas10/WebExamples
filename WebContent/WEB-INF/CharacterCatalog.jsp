<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="sb" class = "models.Simpson"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Character Catalog</title>
</head>
<body>

<div class="container">

<div class="jumbotron text-center">
  <img style="width: 30%;" src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png">
  <h1>Character Catalog</h1>
  <p class="lead">Click on an image below to view a random image of your favorite character!</p>
</div>


<div class="row">
<c:forEach items = "${simpsons}" var = "simpson">


<div class="col-sm-4 text-center">
<div class= "well">
<a href = "CharacterProfile?id=${simpson.id}">
<c:choose>
<c:when test="${simpson.number>0}">
<img style="height: 150px;" src="http://albertcervantes.com/cs3220/cdn/simpsons/${simpson.underscore}/pic_0001.jpg" class="img-responsive img-thumbnail" alt="${simpson.name}" >
</c:when>
<c:otherwise>
<img style="height: 150px;" src="http://via.placeholder.com/150?text=N/A" class="img-responsive img-thumbnail" alt="N/A" >
</c:otherwise>
</c:choose>
</a>
<h4 class = "text-center"> <a href = "CharacterProfile?id=${simpson.id}">  ${simpson.name}</a> </h4>



</div>

</div>


</c:forEach>

</div>
</div>


</body>
</html>