package com.woniu.k_interceptor2.d;

public class CalcImpl implements ICalc {

	@Override
	public int add(int a, int b) {
		System.out.println("CalcImpl.add()");
		int r = a + b;
		return r;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("CalcImpl.sub()");
		int r = a - b;
		return r;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("CalcImpl.mul()");
		int r = a * b;
		return r;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("CalcImpl.div()");
		int r = a / b;
		return r;
	}

}
