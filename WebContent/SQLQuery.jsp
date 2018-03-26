<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu31" 
	user="cs3220stu31"
	password="LU!XDd.q" />
 	
<c:if test="${not empty param.submit}">
<c:set var = "new" value = "${param.sql}" scope = "session"/>
</c:if>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://bootswatch.com/4/united/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Query</title>
</head>
<body>
<div class="container">

<div class="page-header">
	<h3>SQL Query</h3>	
</div>

<div class="well">

	<form action="SQLQuery.jsp" method="post">
		<c:choose>
<c:when test = "${empty param.submit and empty param.sql}"/>
<c:when test = "${not empty param.submit and not empty param.sql}"/>
<c:otherwise> <p class="lead text-danger">Invalid Query: <code></code></p> </c:otherwise>
</c:choose>
		<div class="form-group">
			<textarea class="form-control" rows="5" name="sql"></textarea>
		</div>
		<div class="text-center">
			<input class="btn btn-primary" type="submit" name="submit" value="Execute Query">
		</div>
	</form>
</div>

<%-- 
 <p>empty sql ${empty param.sql}</p>
<p>empty submit ${empty param.submit}</p> 

<c:if test="${not empty param.sql}">
<sql:query var="results" sql= "${param.sql}" />

</c:if>

 --%>




<c:choose>

<c:when test="${not empty param.sql}">
<p><strong># records returned for:</strong> <code>${param.sql}</code></p>

	<c:catch var = "catchException">
	
	<sql:query var="results" sql= "${param.sql}" />
	
	</c:catch>
	
	<c:if test = "${catchException != null}">
	<p> There is an exception: ${catchException.message}</p>
	</c:if>
	<table class="table table-bordered table-hover">
	<%--	Print a row of headings specific to the result set --%>
		 <thead class="thead-dark">
		<tr>
			<c:forEach items="${results.columnNames}" var="heading">
				<th>${heading}</th>
			</c:forEach>
		</tr>
		</thead>
		<%-- Print the columns of each row --%>
		<c:forEach items="${results.rowsByIndex}" var="row">
			<tr>
				<c:forEach items="${row}" var="col">
					<td>${col}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</c:when>
</c:choose>


</div>
</body>
</html>