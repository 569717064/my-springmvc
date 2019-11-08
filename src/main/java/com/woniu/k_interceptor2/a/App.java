package com.woniu.k_interceptor2.a;

import static org.junit.Assert.*;

import org.junit.Test;

public class App {
	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		int r = c.add(1, 2);
		System.out.println(r);
	}
}
