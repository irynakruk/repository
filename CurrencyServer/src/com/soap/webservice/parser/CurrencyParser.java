package com.soap.webservice.parser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.soap.webservice.CurrencyData;
import com.soap.webservice.CurrencyRate;

public class CurrencyParser {

	private static final String RESOURCE_URL = "http://www.bank.gov.ua/control/uk/curmetal/currency/search?formType=searchFormDate&time_step=daily&outer=table&date=";

	private static final String DATE_FORMAT = "dd.mm.yyyy";

	public CurrencyData getData(Date date) throws IOException {
		CurrencyData data = new CurrencyData();

		Document doc = Jsoup.connect(RESOURCE_URL + convertDateIntoStr(date)).get();
		Elements newsHeadlines = doc.select(".content tr");

		Iterator<Element> iterator = newsHeadlines.iterator();
		// omit first and second <tr>
		iterator.next();
		iterator.next();
		
		Date responseDate = parseInfoMessage(iterator.next());
		data.setResponseDate(responseDate);
		
		//omit titles <tr>
		iterator.next();
		List<CurrencyRate> parsedData = new ArrayList<>();
		while(iterator.hasNext()){
			CurrencyRate rate = parseCurrencyData(iterator.next());
			if(rate != null){
				parsedData.add(rate);
			}					
		}
		data.setCurrencyRates(parsedData);
		
		return data;
	}

	private String convertDateIntoStr(Date date) {
		SimpleDateFormat parserSDF = new SimpleDateFormat(DATE_FORMAT);
		return parserSDF.format(date);
	}
	
	private Date convertStrIntoDate(String dateStr) {
		SimpleDateFormat parserSDF = new SimpleDateFormat(DATE_FORMAT);
		try {
			return parserSDF.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	private Date parseInfoMessage(Element element) {
		return convertStrIntoDate(element.text());
	}

	private CurrencyRate parseCurrencyData(Element element) {
		CurrencyRate cRate = new CurrencyRate();
		List<Element> tdElements = element.getElementsByClass("cell_c");
		if(tdElements != null && tdElements.size() == 4){
			Iterator<Element> elemIt = tdElements.iterator();
			cRate.setCode(Integer.parseInt(elemIt.next().text()));
			cRate.setStrCode(elemIt.next().text());
			cRate.setQuantity(Integer.parseInt(elemIt.next().text()));
			cRate.setRate(Double.parseDouble(elemIt.next().text()));
			
			List<Element> nameElem =element.getElementsByClass("cell");
			cRate.setName(nameElem.iterator().next().text());
			
			return cRate;
		}
		return null;		
	}
}
