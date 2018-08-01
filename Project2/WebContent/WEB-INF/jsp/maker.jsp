<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maker Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<ul class="row nav navbar-nav">

				<li class="col"><a href="CustomerController?operation=new">New</a></li>
				<li class="col"><a href="CustomerController?operation=update">Update</a></li>

				<li class="col dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">View <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="CustomerController?operation=viewsingle">Single</a></li>
						<li><a href="CustomerController?operation=viewall">All</a></li>

					</ul></li>
				<li class="col"><a href="CustomerController?operation=delete">Delete</a></li>
				<li class="col"><a href="CustomerController?operation=logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<h1 style="margin-left: auto;; margin-top: auto;; color: green;e">Welcome maker
		${username}</h1>


</body>
</html>