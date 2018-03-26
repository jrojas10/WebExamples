<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "cs3220" uri = "http://cs3.calstatela.edu/cs3220stu31/examples" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty param.input}">
<c:set var = "new" value = "${param.input}" scope = "session"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab11</title>
</head>
<body>
<h2>Integer to text conversion</h2>
<h3>Enter an integer</h3>
<form action="Lab11.jsp" method = "post">
<input class="form-control" rows="5" name="input"></input>


<input class="btn btn-primary" type="submit" name="submit" value="Execute Query">
</form>

<p> Number entered is ${param.input} </p>
<%-- <p> output is ${cs3220:numToText(param.input)} </p> --%>
<p>
In Text:
${cs3220:toText(param.input)} 
</p>

</body>
</html>