<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b3>n.jsp</b3>
	
	<form action="/springmvc/users" method="post">
		<button type="submit">save</button>
	</form>
	
	<form action="/springmvc/users" method="get">
		<button type="submit">findAll</button>
	</form>
	
	<form action="/springmvc/users/1/eason" method="get">
		<button type="submit">findOne</button>
	</form>
	
	<form action="/springmvc/users" method="post">
		<input type="hidden" name="_method" value="put" />
		<button type="submit">update</button>
	</form>
	
	<form action="/springmvc/users" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">delete</button>
	</form>
</body>
</html>