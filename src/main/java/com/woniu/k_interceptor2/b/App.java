package com.woniu.k_interceptor2.b;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;
import java.lang.reflect.InvocationHandler;

class MyHandler implements InvocationHandler{

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("MyHandler.invoke()");
		Object r = method.invoke(target, args);
		return r;
	}

	
}

//=================================================================================================
public class App {
	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		ClassLoader cl = App.class.getClassLoader();
		Class[] interfaces = c.getClass().getInterfaces();
		InvocationHandler handler = new MyHandler(c);
		ICalc proxy = (ICalc)Proxy.newProxyInstance(cl, interfaces, handler);
		int r = proxy.add(1, 2);
		System.out.println(r);
	}
}
