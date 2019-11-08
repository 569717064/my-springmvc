package com.woniu.b_replace;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class Foo implements View{

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getRequestDispatcher("index").forward(request, response);//转发
		//response.sendRedirect("index.jsp");//重定向
	}

}
