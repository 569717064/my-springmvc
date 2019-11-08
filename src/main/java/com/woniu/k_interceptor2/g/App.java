package com.woniu.k_interceptor2.g;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;

class MyProxy {
	public static Object getProxy(Object target, Interceptor i) {
		ClassLoader cl = App.class.getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		InvocationHandler handler = new MyHandler(target, i);
		ICalc proxy = (ICalc) Proxy.newProxyInstance(cl, interfaces, handler);
		return proxy;
	}

	public static Object getProxy2(Object target) {
		try {
			List<Interceptor> list = new ArrayList<Interceptor>();
			
			InputStream in = App.class.getResourceAsStream("myconfig.properties");
			Properties pro = new Properties();
			pro.load(in);// 加载配置
			
			// 获取配置文件内容按照“,”分隔
			String[] strs = pro.getProperty("Interceptors").split(",");

			// 遍历数组，反射得到类的实例，并加入到list集合里
			for (String s : strs) {
				Class clazz = Class.forName(s);
				list.add((Interceptor) clazz.newInstance());
			}
			
			for (int i = list.size() - 1; i >= 0; i--) {
				target = MyProxy.getProxy(target, list.get(i));
			}
			return target;
		} catch (Exception e) {
			return null;
		}
	}

}

class MyHandler implements InvocationHandler {

	private Object target;
	private Interceptor i;

	public MyHandler(Object target, Interceptor i) {
		this.target = target;
		this.i = i;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Boolean pre = i.preHandle();
		if (!pre) {
			return 0;
		}
		Object r = method.invoke(target, args);
		i.postHandle();
		return r;
	}

}

interface Interceptor {
	Boolean preHandle();

	void postHandle();
}

class A implements Interceptor {
	
	@Override
	public Boolean preHandle() {
		System.out.println("A.preHandle()AAAAAAAAAAAAAAAAAAAAAAAAA");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("A.postHandle()aaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
}

class B implements Interceptor {

	@Override
	public Boolean preHandle() {
		System.out.println("B.preHandle()BBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("B.postHandle()bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	}

}

//========================================================================================================
public class App {
	@Test
	public void test() throws Exception {
		ICalc proxy = (ICalc) MyProxy.getProxy2(new CalcImpl());
		proxy.add(1, 2);
	}
}
