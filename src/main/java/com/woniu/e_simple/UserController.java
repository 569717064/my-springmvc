package com.woniu.e_simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	public UserController() {
		System.out.println("UserController.UserController()eeee");
	}
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("UserController.save()eeee");
		return new ModelAndView("index");
	}
	
	@RequestMapping("delete")
	public ModelAndView delete() {
		System.out.println("UserController.delete()eeee");
		return new ModelAndView("index");
	}

}
