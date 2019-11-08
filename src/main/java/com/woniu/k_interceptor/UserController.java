package com.woniu.k_interceptor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("save")
	@ResponseBody
	public void save() {
		System.out.println("UserController.save()");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public void delete() {
		System.out.println("UserController.delete()");
	}
	
}
