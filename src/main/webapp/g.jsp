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
</body>
	<button>ajax go</button>
	<button>ajax go2</button>
	<button>ajax go3</button>
	<button>ajax go4</button>
</html>
<script>
	$(function () {
		$("button:eq(0)").click(function () {
			$.ajax({
				type:"post",
				url:"/springmvc/user/save.do",
				headers:{
					//Accept：是希望服务器响应json类型格式
					Accept:"application/json"					
				},
				success:function(data){
					alert(data);
				}
			});
		});
		
		
		$("button:eq(1)").click(function () {
			$.ajax({
				type:"post",
				url:"/springmvc/user/save2.do",
				data:{id:1,name:"jack"},
				success:function(data){
				}
			});
		});
		
		
		$("button:eq(2)").click(function () {
			$.ajax({
				type:"post",
				url:"/springmvc/user/save3.do",
				data:"id@@100---name@@andy---birthday@@2011-12-11---money@@567",
				headers:{
					"Content-Type":"text/woniu"	,
					Accept:"text/woniu"
				},
				success:function(data){
					alert(data);
				}
			});  
		});
		
		
		$("button:eq(3)").click(function () {
			$.ajax({
				type:"post",
				url:"/springmvc/user/save4.do",
				data:"{\"id\":100,\"name\":\"andy\",\"birthday\":\"2011-12-11\",\"money\":\"567\"}",
				headers:{
					"Content-Type":"application/json"	,
					Accept:"application/json"
				},
				success:function(data){
					alert(data);
				}
			});  
		});
	})
</script>