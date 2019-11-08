package com.woniu.b_replace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

//	@Override  //实现HttpRequestHandler接口
//	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("UserController.handleRequest()bbbb");
//	}

	@Override //实现Controller接口
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserController.handleRequest()bbbb");
		return new ModelAndView("index");
	}

}
