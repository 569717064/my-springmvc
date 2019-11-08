<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	页面范围：${pageScope.x} <br/>
	请求范围：${requestScope.x} <br/>
	会话范围：${sessionScope.x} <br/>
	应用范围：${applicationScope.x} <br/>
	<hr>
	user2:${user2}<br/>
	user:${user}<br/>
	string:${string}<br/>
	list:${list}<br>
	aa:${aa}<br>
</body>
</html>