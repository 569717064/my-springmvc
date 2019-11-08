package com.woniu.k_interceptor2.a;

public class CalcImpl implements ICalc {

	@Override
	public int add(int a, int b) {
		int r = a + b;
		return r;
	}

	@Override
	public int sub(int a, int b) {
		int r = a - b;
		return r;
	}

	@Override
	public int mul(int a, int b) {
		int r = a * b;
		return r;
	}

	@Override
	public int div(int a, int b) {
		int r = a / b;
		return r;
	}

}
