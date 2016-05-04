
package com.soap.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebCalculatorImplService", targetNamespace = "http://webservice.soap.com/", wsdlLocation = "http://localhost:8080/JAXWSServer/JAXWSServer?wsdl")
public class WebCalculatorImplService
    extends Service
{

    private final static URL WEBCALCULATORIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBCALCULATORIMPLSERVICE_EXCEPTION;
    private final static QName WEBCALCULATORIMPLSERVICE_QNAME = new QName("http://webservice.soap.com/", "WebCalculatorImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/JAXWSServer/JAXWSServer?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBCALCULATORIMPLSERVICE_WSDL_LOCATION = url;
        WEBCALCULATORIMPLSERVICE_EXCEPTION = e;
    }

    public WebCalculatorImplService() {
        super(__getWsdlLocation(), WEBCALCULATORIMPLSERVICE_QNAME);
    }

    public WebCalculatorImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBCALCULATORIMPLSERVICE_QNAME, features);
    }

    public WebCalculatorImplService(URL wsdlLocation) {
        super(wsdlLocation, WEBCALCULATORIMPLSERVICE_QNAME);
    }

    public WebCalculatorImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBCALCULATORIMPLSERVICE_QNAME, features);
    }

    public WebCalculatorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebCalculatorImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebCalculator
     */
    @WebEndpoint(name = "WebCalculatorImplPort")
    public WebCalculator getWebCalculatorImplPort() {
        return super.getPort(new QName("http://webservice.soap.com/", "WebCalculatorImplPort"), WebCalculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebCalculator
     */
    @WebEndpoint(name = "WebCalculatorImplPort")
    public WebCalculator getWebCalculatorImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.soap.com/", "WebCalculatorImplPort"), WebCalculator.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBCALCULATORIMPLSERVICE_EXCEPTION!= null) {
            throw WEBCALCULATORIMPLSERVICE_EXCEPTION;
        }
        return WEBCALCULATORIMPLSERVICE_WSDL_LOCATION;
    }

}
