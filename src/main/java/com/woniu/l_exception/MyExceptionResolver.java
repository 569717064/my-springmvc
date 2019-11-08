package com.woniu.l_exception;

import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String path = "";
		if (ex instanceof ArithmeticException) {
			System.out.println(ex);
			path = "l";
			request.setAttribute("exception", "算数异常"+ex);
		}
		return new ModelAndView(path);
	}

}
