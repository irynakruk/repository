package com.soap.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.soap.webservice.WebCalculator")
public class WebCalculatorImpl implements WebCalculator {
	
	@Override
	public int add(int a, int b) {
		return (a + b);
	}
	
	@Override
	public int subtract(int a, int b) {
		return (a - b);
	}

	@Override
	public int multiply(int a, int b) {
		return (a * b);
	}

	@Override
	public int divide(int a, int b) {
		return (a / b);
	}

	@Override
	public int sqr(int a) {
		return a * a;
	}
}
