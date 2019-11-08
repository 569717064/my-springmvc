package com.woniu.f_parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date>{
	/**
	 	转换器类需要实现Converter<String, Date>接口，第一个参数是原始数据的类型，
	 	第二个参数是要转换为的数据类型
	 */
	@Override
	public Date convert(String source) {
		System.out.println("原始数据："+source);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sf.parse(source);
			return date;
		} catch (ParseException e) {
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2;
			try {
				date2 = sf2.parse(source);
				return date2;
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
}
