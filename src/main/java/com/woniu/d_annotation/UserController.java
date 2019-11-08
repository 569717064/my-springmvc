package com.woniu.d_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	public UserController() {
		System.out.println("UserController.UserController()ddddd");
	}
	/**
	 	1.需要给类加上@Controller注解，表示它被spring IOC 容器所管理
	 	2.需要给类加上@RequestMapping注解，它的值拼上方法上注解的值就是访问路径的url，
	 		可以不写，不写就会直接找方法名，但是建议写上
	 	3.需要给方法加上@RequestMapping注解，必须要设置值，建议和方法名相同
	 	4.@RequestMapping：
	 		类的注解名加上方法的注解名拼成的字符串当做map的键值保存起来，把方法当做值保存起来
	 		访问的时候，会在内存中的map里面去找对应的键值，然后执行值所保存的方法
	 */
	
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("UserController.save()dddd");
		return new ModelAndView("index");
	}
	
	@RequestMapping("delete")
	public ModelAndView delete() {
		System.out.println("UserController.delete()dddd");
		return new ModelAndView("index");
	}

}
