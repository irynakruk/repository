package com.soap.webservice;

import java.io.IOException;
import java.util.Date;

import com.soap.webservice.parser.CurrencyParser;

public class CurrencyService {
	
	private CurrencyParser parser = new CurrencyParser();

	public CurrencyData getDataByDate(Date date){
		CurrencyData data = new CurrencyData();
		try {
			data = parser.getData(date);
			data.setMessage("Success");
		} catch (IOException e) {
			data.setMessage("Error: " + e.getMessage());
		}		
		return data;
	}
}
