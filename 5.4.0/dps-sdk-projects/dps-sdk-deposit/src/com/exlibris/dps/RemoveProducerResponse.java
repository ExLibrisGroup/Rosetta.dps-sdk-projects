
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeProducerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeProducerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RemoveProducer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeProducerResponse", propOrder = {
    "removeProducer"
})
public class RemoveProducerResponse {

    @XmlElement(name = "RemoveProducer")
    protected String removeProducer;

    /**
     * Gets the value of the removeProducer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveProducer() {
        return removeProducer;
    }

    /**
     * Sets the value of the removeProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveProducer(String value) {
        this.removeProducer = value;
    }

}
