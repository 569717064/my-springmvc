package com.woniu.h_controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	public UserController() {
		System.out.println("UserController.UserController()hhhhh");
	}
	
	
	@RequestMapping("save")
	public ModelAndView save() {//封装模型
		ModelAndView mav = new ModelAndView("h");
		//这里保存的是request请求范围
		mav.addObject("x", "关羽");
		User user = new User();
		user.setId(1);
		user.setName("刘备");
		user.setBirthday(new Date());
		user.setMoney(5000d);
		// 在reuqest范围中，添加一个键值对，键值是user，值是user对象
		mav.addObject("user2", user);
		/**
		在reuqest范围中，添加一个键值对，键值是“智能”生成的，值是user对象键值默认就是类名首字母小写： user
		 */
		mav.addObject(user);
		mav.addObject("飞雪连天射白鹿");
		// 在reuqest范围中，添加一个键值对，键值是userList，值是list对象
		List<User> list = new ArrayList<>();
		list.add(new User(11,"韦小宝", new Date(), 1000d));
		list.add(new User(12,"令狐冲", new Date(), 2000d));
		list.add(new User(13,"张无忌", new Date(), 3000d));
		mav.addObject("list", list);
		return mav;
	}
	
	
	/*
		 控制器的方法，返回类型除了可以是ModelAndView以外，也可以是String类型
		 此时String返回值的内容，表示的是“逻辑视图名”
		 此时，如果还想给跳转的目标页面传递参数，就要为控制器添加一个Model类型的参数
		 但凡要给页面传递什么参数，都是通过model的addAttribute方法实现的
	*/
	@RequestMapping("save2")
	public String save2(Model model) {
		model.addAttribute("aa", "笑书神侠倚碧鸳");
		return "h";
	}
	
	/*
	 	默认的跳转方式是转发，那么如何才能重定向呢？
	 	注意，重定向时，前后缀必须自己手动添加
	*/
	@RequestMapping("save3")
	public String save3() {
		return "redirect:/h.jsp";
	}
}
