
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeProducerAgentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeProducerAgentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RemoveProducerAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeProducerAgentResponse", propOrder = {
    "removeProducerAgent"
})
public class RemoveProducerAgentResponse {

    @XmlElement(name = "RemoveProducerAgent")
    protected String removeProducerAgent;

    /**
     * Gets the value of the removeProducerAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveProducerAgent() {
        return removeProducerAgent;
    }

    /**
     * Sets the value of the removeProducerAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveProducerAgent(String value) {
        this.removeProducerAgent = value;
    }

}
