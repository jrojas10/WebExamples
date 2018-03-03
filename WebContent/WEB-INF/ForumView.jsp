<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://bootswatch.com/4/united/bootstrap.min.css">
</head>
<body>
	<h2>forum</h2>


	<table class="table table-bordered table-hover">

		<tr>
			<th>Title</th>
			<th>Link</th>
			<th>Upvotes</th>
			<th>Downvotes</th>
		</tr>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td>${post.title}</td>
				<td><a href="${post.link}">${post.link}</a></td>

				<td>
					<form action="UpvoteController" method="post">
						<input name="id" type="hidden" value="${post.id}"> <input
							name="count" type="hidden" value="${post.upvote}"> <input
							class="btn btn-primary" type="submit" name="submit"
							value="${post.upvote}">

					</form>
				</td>
				<td>
					<form action="DownvoteController" method="post">
						<input name="id" type="hidden" value="${post.id}"> <input
							name="count" type="hidden" value="${post.downvote}"> <input
							class="btn btn-primary" type="submit" name="submit"
							value="${post.downvote}">

					</form>

				</td>
			</tr>
		</c:forEach>
	</table>



	<h3>add a post</h3>
	<form action="AddPost" method="post">
		Title: <input type="text" name="title" value=""> URL: <input
			type="text" name="link" value=""> <input
			class="btn btn-primary" type="submit" name="submit" value="Add">


	</form>
</body>
</html>