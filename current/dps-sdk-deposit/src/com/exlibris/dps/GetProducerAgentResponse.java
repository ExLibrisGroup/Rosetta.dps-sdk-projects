
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProducerAgentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProducerAgentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProducerAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProducerAgentResponse", propOrder = {
    "getProducerAgent"
})
public class GetProducerAgentResponse {

    @XmlElement(name = "GetProducerAgent")
    protected String getProducerAgent;

    /**
     * Gets the value of the getProducerAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetProducerAgent() {
        return getProducerAgent;
    }

    /**
     * Sets the value of the getProducerAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetProducerAgent(String value) {
        this.getProducerAgent = value;
    }

}
