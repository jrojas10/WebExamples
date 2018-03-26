<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="sb" class="models.Simpson" />
<jsp:setProperty name="sb" property="*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${simpsons[param.id].name}'sProfilePage</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-offset-3 col-sm-6">
				<div class="well text-center">
					<img style="width: 30%;"
						src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png">
					<h2>${simpsons[param.id].name}</h2>
					<p class="lead">Displaying 1 of ${simpsons[param.id].number}
						images.</p>

					<p>
						<a class="btn btn-success" href="CharacterCatalog"> Catalog </a> <a
							class="btn btn-success" href="CharacterProfile?id=${param.id}">
							Next Image </a>
					</p>
					<c:choose>
			<c:when test="${simpsons[param.id].number>0}">
					<p class="text-center" style="overflow: none;">
						<a href="CharacterProfile?id=${param.id}"> <img
							style="max-height: 200px;"
							src="http://albertcervantes.com/cs3220/cdn/simpsons/${simpsons[param.id].underscore}/pic_${simpsons[param.id].random}.jpg">
							
						</a>
					</p>
					</c:when>
					<c:otherwise>
					<p class="text-center" style="overflow: none;">
						<a href="CharacterProfile?id=${param.id}"> <img
							style="max-height: 200px;"
							src="http://via.placeholder.com/150?text=N/A">
							
						</a>
					</p>
										
					
					
					</c:otherwise>
					</c:choose>
			<%-- 		<c:if test="${simpsons[param.id].number=0 }">
					<p class="text-center" style="overflow: none;">
						<a href="CharacterProfile?id=${param.id}"> <img
							style="max-height: 200px;"
						src  = "http://via.placeholder.com/150?text=N/A">
					
					</a>
					</p>
					
					
					
					</c:if>
				--%>	
					
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>