
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProducerDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProducerDetailsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProducerDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProducerDetailsResponse", propOrder = {
    "getProducerDetails"
})
public class GetProducerDetailsResponse {

    @XmlElement(name = "GetProducerDetails")
    protected String getProducerDetails;

    /**
     * Gets the value of the getProducerDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetProducerDetails() {
        return getProducerDetails;
    }

    /**
     * Sets the value of the getProducerDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetProducerDetails(String value) {
        this.getProducerDetails = value;
    }

}
