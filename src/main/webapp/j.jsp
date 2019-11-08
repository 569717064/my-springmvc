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

	<!-- 
		文件上传时，form表单有2个必须：
		1. method必须是post.  
		2. enctype="multipart/form-data"
			如果不加则enctype默认取值为: application/x-www-form-urlencoded,
				该值表示表单给后台传数据的格式为：键值对，此时不会传递图片的2进制内容
			加上了以后，则表单就会把图片的名字和2进制一起传送给后台服务器！
	 -->
	<form action="user/upload.do" method="post" enctype="multipart/form-data" >
		<input type="file" name="photo" accept="image/*" >
		<button>go</button>
	</form>
	<hr>
	
	<!-- 多文件上传 
		multiple:在文本框中写出此属性就可以选择多文件上传了
	-->
	<form action="user/upload2.do" method="post" enctype="multipart/form-data" >
		<input type="file" name="photos" multiple>
		<button>goMany</button>
	</form>
	<hr>
	
	
	<!-- 使用ajax上传 -->
	<form>
		<input type="file" id="p" name="photo">
		<button type="button" id="btn">goAJAX</button>
	</form>
</body>
</html>
<script>
	$(function () {
		$("#btn").click(function () {
			//模拟数据上传
			var file = $("#p")[0].files[0];
			var formData = new FormData();
			formData.append("photo",file);
			$.ajax({
				type:"post",
				url:"user/upload.do",
				processData : false, // 使数据不做处理
				// 不要设置Content-Type请求头   等价于表单中的 enctype="multipart/form-data"
				contentType : false, 
				data:formData
			});
		});
	});
</script>