package com.woniu.n_rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void findAll() {
		System.out.println("findAll...");
	}
	
	@RequestMapping(value = "/{id}/{name}", method = RequestMethod.GET)
	@ResponseBody
	public void findOne(@PathVariable Integer id, @PathVariable String name) {
		System.out.println("findOne:" + id + ", " + name);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void save() {
		System.out.println("UserController.save()");
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void update() {
		System.out.println("UserController.update()");
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(Integer id) {
		System.out.println("delete:" + id);
	}
}

