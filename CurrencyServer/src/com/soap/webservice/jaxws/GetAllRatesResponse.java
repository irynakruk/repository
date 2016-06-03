
package com.soap.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllRatesResponse", namespace = "http://webservice.soap.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllRatesResponse", namespace = "http://webservice.soap.com/")
public class GetAllRatesResponse {

    @XmlElement(name = "return", namespace = "")
    private com.soap.webservice.CurrencyData _return;

    /**
     * 
     * @return
     *     returns CurrencyData
     */
    public com.soap.webservice.CurrencyData getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.soap.webservice.CurrencyData _return) {
        this._return = _return;
    }

}
