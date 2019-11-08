package com.woniu.g_httpmessageconverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final String Accept = null;

	// 该方法演示了， 服务器端 与 客户端请求发来的Accept搭配使用的场景。
	@RequestMapping("save")
	public void save(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String message = "";
		//获取请求头中的accept：是客户端希望服务器返回的格式
		String accept = req.getHeader("Accept");
		if (accept.equals("application/json")) {
			message = "{\"id\":1,\"name\":\"jack\"}";
		}else {
			message = "hahaha";
		}
		out.print(message);
		out.flush();
		out.close();
	}
	
	
	/**
	 	当页面发起ajax请求，经过映射器找到此方法并返回给适配器，适配器在处理此方法前会先看参数前有没有@RequestBody注解
	 		 如果有，则使用HttpMessageConverter注入参数的值，就会去读取请求头的Content-Type，
	 		就告诉服务器我页面发的是键值对格式的，然后springMVC会找到与此Context-Type匹配的HttpMessageConverter，
	 		就找到了StringHttpMessageConverter，会调用它的canRead方法进行判断是否归自己管，然后回调supports方法，
	 		
	 		public final T read(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException{
	 			return String.class == clazz;
	 		}
        	判断方法参数的类型是不是String，返回true，然后继续调用它的readInternal方法注入参数
	 		
	 */
	@RequestMapping("save2")
	public void save2(@RequestBody String str) throws IOException {
		System.out.println(str);          
	}
	
	/**
		1.有@RequestBody注解就读取请求头Content-Type得到text/woniu
		2.找到StringHttpMessageConverter     UserHTTPMessageConverter
		3.调用UserHTTPMessageConverter的supports方法
				false                               true
		4.调用UserHTTPMessageConverter的readInternal方法注入参数
		=======================================================
		5.当参数注入以后，返回的时候，就看方法上有没有@ResponseBody注解，
			如果有就读取请求头中的Accept得到text/woniu
		6.找到StringHttpMessageConverter     UserHTTPMessageConverter
				false                               true
		7.调用UserHTTPMessageConverter的writeInternal方法响应
	 */
	@RequestMapping("save3")
	@ResponseBody
	public User save3(@RequestBody User user) throws IOException {
		//初始传入的数据：[id=100, name=andy, birthday=Sun Dec 11 00:00:00 CST 2011, money=567.0]
		user.setId(1);
		user.setName("jack");
		user.setBirthday(new Date());
		user.setMoney(5000d);
		return user;
	}
	
	
	@RequestMapping("save4")
	@ResponseBody
	public User save4(@RequestBody User user) throws IOException {
		//初始传入的数据：[id=100, name=andy, birthday=Sun Dec 11 08:00:00 CST 2011, money=567.0]
		user.setId(1);
		user.setName("jack");
		user.setBirthday(new Date());
		user.setMoney(5000d);
		return user;
	}
    
}
