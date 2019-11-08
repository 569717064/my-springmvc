<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script>
// 		$(function() {
// 			$("form:eq(0)").submit(function() {
// 				var aa=false,bb=false;
// 				if($("input[name=username]").val().length == 0) {
// 					$("input[name=username]").next().html("username不能为空");
// 					aa = false;
// 				} else {
// 					$("input[name=username]").next().html("");
// 					aa = true;
// 				}
// 				if($("input[name=password]").val().length == 0) {
// 					$("input[name=password]").next().html("password不能为空");
// 					bb = false;
// 				} else {
// 					$("input[name=password]").next().html("");
// 					bb = true;
// 				}
// 				// 在事件处理函数中，如果返回false，则表示，就当这件事情没有发生过。
// 				return aa&&bb;
// 			});
// 		});
	</script>
	<h3>m.jsp</h3>
	<form action="/springmvc/user/save.do" method="post">
		id:<input name="id" value="${user.id }" /><span>${idError }</span> <br />
		username:<input name="username" value="${user.username }" /><span>${usernameError }</span> <br />
		password:<input name="password" value="${user.password }" /><span>${passwordError }</span> <br />
		money:<input name="money" value="${user.money }" /><span>${moneyError }</span> <br />
		cellphone:<input name="cellphone" value="${user.cellphone }" /><span>${cellphoneError }</span> <br />
		<button>注册</button>
	</form>
	<br><hr>
	
</body>
</html>