package com.soap.webservice;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebCurrencyProvider {

	@WebMethod
	public CurrencyData getAllRates(Date date);
}
