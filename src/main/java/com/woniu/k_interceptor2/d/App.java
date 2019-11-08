package com.woniu.k_interceptor2.d;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;
import java.lang.reflect.InvocationHandler;

class MyProxy{
	public static Object getProxy(Object target,Interceptor i) {
		ClassLoader cl = App.class.getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		InvocationHandler handler = new MyHandler(target,i);
		ICalc proxy = (ICalc)Proxy.newProxyInstance(cl, interfaces, handler);
		return proxy;
	}
}

class MyHandler implements InvocationHandler{

	private Object target;
	private Interceptor i;
	public MyHandler(Object target,Interceptor i) {
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


interface Interceptor{
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


class B implements Interceptor{

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
		ICalc c = new CalcImpl();
		ICalc proxy = (ICalc) new MyProxy().getProxy(c,new B());
		int r = proxy.add(1, 2);
		System.out.println(r);
	}
}
