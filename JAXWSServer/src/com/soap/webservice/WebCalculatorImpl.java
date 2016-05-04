package com.soap.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.soap.webservice.WebCalculator")
public class WebCalculatorImpl implements WebCalculator {
	
	@Override
	public double add(double arg0, double arg1) {
		return (arg0 + arg1);
	}
	
	@Override
	public double subtract(double arg0, double arg1) {
		return (arg0 - arg1);
	}

	@Override
	public double multiply(double arg0, double arg1) {
		return (arg0 * arg1);
	}

	@Override
	public double divide(double arg0, double arg1) {
		return (arg0 / arg1);
	}

	@Override
	public double sqr(double arg0) {
		return arg0 * arg0;
	}
}
