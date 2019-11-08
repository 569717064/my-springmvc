package com.woniu.g_httpmessageconverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class UserHttpMessageConverter extends AbstractHttpMessageConverter<User> {

	@Override
	protected boolean supports(Class<?> clazz) {
		System.out.println("UserHttpMessageConverter.supports()");
		return User.class == clazz;
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println("UserHttpMessageConverter.readInternal()");
		// 这里应该根据请求中所传递的请求参数，来生成User对象。
		// 首要问题就是，从哪获取请求中的请求参数？？ 答：从当前方法的第二个参数：inputMessage中获取！！
		//id@@100---name@@andy---birthday@@2011-12-11---money@@567
		
		InputStream in = inputMessage.getBody();
		StringBuilder sb = new StringBuilder();
		while (in.available() > 0) {
			int n = in.read();
			sb.append((char)n);
		}
		 // 字符串的split天生支持“正则式”， 所以如果split的参数是正则式的特殊字符，需要转义
		String[] strs = sb.toString().split("---");
		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (String s : strs) {
			String fieldName = s.toString().split("@@")[0];
			if ("id".equals(fieldName)) {
				user.setId(Integer.parseInt(s.toString().split("@@")[1]));
			}else if ("name".equals(fieldName)) {
				user.setName(s.toString().split("@@")[1]);
			}else if ("birthday".equals(fieldName)) {
				try {
					user.setBirthday(sdf.parse(s.toString().split("@@")[1]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if ("money".equals(fieldName)) {
				user.setMoney(Double.parseDouble(s.toString().split("@@")[1]));
			}
		}
		return user;
	}

	@Override
	protected void writeInternal(User t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		System.out.println("UserHttpMessageConverter.writeInternal()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 通过输出流给客户端响应数据：
		OutputStream out = outputMessage.getBody();
		//id@@100---name@@andy---birthday@@2011-12-11---money@@567
		String str = "id@@"+t.getId()+"---name@@"+t.getName()+"---birthday@@"+sdf.format(t.getBirthday())+"---money@@"+t.getMoney();
		out.write(str.getBytes());
		out.flush();
		out.close();
	}

	
}
