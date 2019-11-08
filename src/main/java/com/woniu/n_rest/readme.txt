rest是一种设计风格，而不是协议，也不是标准。

意思是，不同公司中，使用rest的写法，各不一样！！



预备知识：
1. 默认servlet
	专门负责，响应静态资源（图片、视频、html）
	也会在资源找不到时，响应404界面
	
2. /与/*的区别
	/ 	拦截所有请求
	/*  拦截所有请求
	
	区别是，/什么都拦截，就是不拦截jsp   /* 什么都拦截，包括jsp
	最终，我们下午要正式学习的rest，要求，前端控制器，拦截路径为 / 
	
=============================================================================

rest，全称Representational State Transfer,  翻译过来叫做： 表现性状态转换！

rest编程风格的特点：
1. rest风格中，是面向资源编程的。
	所谓资源，就是网络上，有利用价值的东西：  一首歌， 一段相声， 一篇文章， 一张图片， 用户，电影， 商品，都可以称之为资源。 

2. rest风格，要求，对资源的操作，不会影响url地址。


3. 以前我们所使用的开发方式，其实是不符合rest风格的，为什么不符合呢？

	http://localhost:8080/test/user/save.do		增加
	http://localhost:8080/test/user/delete.do	删除
	http://localhost:8080/test/user/update.do	修改
	http://localhost:8080/test/user/findAll.do	查询
	
	问题是，http协议中，已经规定了8个请求方式， 我们知道的只有：get和post
	
	这8中请求方式分别是： get post delete put  patch head options track
	
	其中， 
		get请求方式，含义是 查询
		post请求方式，含义是增加
		delete请求方式，含义是删除
		put请求方式，含义是修改
		
	可以看出，http不同的请求方式，已经能表示CRUD的不同操作了！ 就不需要再在url上，通过动词来指定本次请求要做什么？
	以前的url地址，为了表示增加，需要在地址上明显地写出save， 为了表示删除，需要写出delete。 其实这完全是多余的！
	
	只要我们把请求方式改变了， 服务器就能知道，本次请求的目的是什么！ 以下是符合rest风格的请求地址：
	
	http://localhost:8080/test/users				post
	http://localhost:8080/test/users				delete
	http://localhost:8080/test/users				put
	http://localhost:8080/test/users				get
	http://localhost:8080/test/users/1			get

============================================================================================================

在springmvc中使用rest （其他语言也能支持rest， rest并不是springmvc中特有的！ 而是springmvc对rest进行了支持！）

1. rest风格中，要求资源都是复数形式！
2. rest风格中，要求请求地址，不能有后缀，也就是不能加.do .action 这就要修改前端控制器
	<servlet>
		<servlet-name>DispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:com/woniuxy/o_rest/spring-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>DispatcherServlet</servlet-name>
		<url-pattern>/</url-pattern>		《==	看这里，看这里，看这里，看这里，看这里，看这里
	</servlet-mapping>


3. 问题是，表单只支持get和post请求方式，不支持put和delete。
   如何才能让表单也支持put和delete呢？？
   
   只需要先在web.xml中，加入一个过滤器：
   	<filter>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
还要在表单中，加入一个隐藏域，该隐藏域的名字必须叫做"_method"， 取值为 delete或put。
	<form action="/springmvc/users" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Go</button>
	</form>
	
符合restful风格的ajax CURD，请参见o2.jsp


问题，符合rest风格的url，如果传递其他参数? 比如传递页码，和每页显示行数

get方法  http://localhost:8080/test/users?page=1&size=10

 
我们已经知道， 此时的前端控制器， 映射路径是/ 	， 问题是，这/一改，就再也看不到应用中的图片了（原因你懂得）

为了解决这个问题，需要再在spring-serlvet.xml中，添加配置：


		


