
package com.soap.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllRates_QNAME = new QName("http://webservice.soap.com/", "getAllRates");
    private final static QName _GetAllRatesResponse_QNAME = new QName("http://webservice.soap.com/", "getAllRatesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllRates }
     * 
     */
    public GetAllRates createGetAllRates() {
        return new GetAllRates();
    }

    /**
     * Create an instance of {@link GetAllRatesResponse }
     * 
     */
    public GetAllRatesResponse createGetAllRatesResponse() {
        return new GetAllRatesResponse();
    }

    /**
     * Create an instance of {@link CurrencyData }
     * 
     */
    public CurrencyData createCurrencyData() {
        return new CurrencyData();
    }

    /**
     * Create an instance of {@link CurrencyRate }
     * 
     */
    public CurrencyRate createCurrencyRate() {
        return new CurrencyRate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.soap.com/", name = "getAllRates")
    public JAXBElement<GetAllRates> createGetAllRates(GetAllRates value) {
        return new JAXBElement<GetAllRates>(_GetAllRates_QNAME, GetAllRates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.soap.com/", name = "getAllRatesResponse")
    public JAXBElement<GetAllRatesResponse> createGetAllRatesResponse(GetAllRatesResponse value) {
        return new JAXBElement<GetAllRatesResponse>(_GetAllRatesResponse_QNAME, GetAllRatesResponse.class, null, value);
    }

}
