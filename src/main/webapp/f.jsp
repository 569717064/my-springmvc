<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>八种基本类型</legend>
		<form action="/springmvc/user/save.do" method="post">
			byte<input type="text" name="b"><br>
			short<input type="text" name="s"><br>
			int<input type="text" name="i"><br>
			long<input type="text" name="l"><br>
			float<input type="text" name="f"><br>
			double<input type="text" name="d"><br>
			boolean<input type="text" name="bo"><br>
			char<input type="text" name="c"><br>
			<button>go</button>
		</form>
	</fieldset>
	<hr>
	
	<fieldset>
		<legend>对象类型</legend>
		<form action="/springmvc/user/save2.do" method="post">
			id<input type="text" name="id"><br>
			name<input type="text" name="name"><br>
			birthday<input type="text" name="birthday"><br>
			money<input type="text" name="money"><br>
			<button>go</button>
		</form>
	</fieldset>
	<hr>
	
	<fieldset>
		<legend>List类型</legend>
		<form action="/springmvc/user/save3.do" method="post">
			hobby<input type="checkbox" name="hobby" value="football">足球
			<input type="checkbox" name="hobby" value="basketball">篮球
			<input type="checkbox" name="hobby" value="volleyball">排球
			<button>go</button>
		</form>
	</fieldset>
	<hr>
	
	
	<fieldset>
		<legend>Set类型</legend>
		<form action="/springmvc/user/save4.do" method="post">
			hobby<input type="checkbox" name="hobby" value="game">游戏
			<input type="checkbox" name="hobby" value="study">学习
			<input type="checkbox" name="hobby" value="run">跑步
			<button>go</button>
		</form>
	</fieldset>
	<hr>
	
	<fieldset>
		<legend>Map类型</legend>
		<form action="/springmvc/user/save5.do" method="post">
			hobby<input type="checkbox" name="a" value="film">电影
			<input type="checkbox" name="b" value="music">音乐
			<input type="checkbox" name="c" value="sleep">睡觉
			<button>go</button>
		</form>
	</fieldset>
	<hr>
	
</body>
</html>