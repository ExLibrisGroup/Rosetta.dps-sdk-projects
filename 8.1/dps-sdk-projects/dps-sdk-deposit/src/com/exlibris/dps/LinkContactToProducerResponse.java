
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for linkContactToProducerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="linkContactToProducerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="linkContactToProducer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkContactToProducerResponse", propOrder = {
    "linkContactToProducer"
})
public class LinkContactToProducerResponse {

    protected String linkContactToProducer;

    /**
     * Gets the value of the linkContactToProducer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkContactToProducer() {
        return linkContactToProducer;
    }

    /**
     * Sets the value of the linkContactToProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkContactToProducer(String value) {
        this.linkContactToProducer = value;
    }

}
