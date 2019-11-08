package com.woniu.k_interceptor2.c;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;
import java.lang.reflect.InvocationHandler;

class MyProxy{
	public static Object getProxy(Object target) {
		ClassLoader cl = App.class.getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		InvocationHandler handler = new MyHandler(target);
		ICalc proxy = (ICalc)Proxy.newProxyInstance(cl, interfaces, handler);
		return proxy;
	}
}


class MyHandler implements InvocationHandler{

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object r = method.invoke(target, args);
		return r;
	}

	
}


//=====================================================================================================
public class App {
	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		ICalc proxy = (ICalc) new MyProxy().getProxy(c);
		int r = proxy.add(1, 2);
		System.out.println(r);
	}
}
