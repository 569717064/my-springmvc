package com.woniu.l_exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("save")
	public String save() {
		System.out.println("UserController.save()");
		System.out.println(8/0);
		return "l";
	}   
}

