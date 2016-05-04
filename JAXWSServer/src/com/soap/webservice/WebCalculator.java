package com.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebCalculator {
	
	@WebMethod
	public double add(double arg0, double arg1);

	@WebMethod
	public double subtract(double arg0, double arg1);

	@WebMethod
	public double multiply(double arg0, double arg1);

	@WebMethod
	public double divide(double arg0, double arg1);

	@WebMethod
	public double sqr(double arg0);
}