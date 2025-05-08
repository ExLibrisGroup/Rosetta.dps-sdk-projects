
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for linkProducerAgentToProducerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="linkProducerAgentToProducerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="linkProducerAgentToProducer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkProducerAgentToProducerResponse", propOrder = {
    "linkProducerAgentToProducer"
})
public class LinkProducerAgentToProducerResponse {

    protected String linkProducerAgentToProducer;

    /**
     * Gets the value of the linkProducerAgentToProducer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkProducerAgentToProducer() {
        return linkProducerAgentToProducer;
    }

    /**
     * Sets the value of the linkProducerAgentToProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkProducerAgentToProducer(String value) {
        this.linkProducerAgentToProducer = value;
    }

}
