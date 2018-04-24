
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createProducerAgentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createProducerAgentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateProducerAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createProducerAgentResponse", propOrder = {
    "createProducerAgent"
})
public class CreateProducerAgentResponse {

    @XmlElement(name = "CreateProducerAgent")
    protected String createProducerAgent;

    /**
     * Gets the value of the createProducerAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateProducerAgent() {
        return createProducerAgent;
    }

    /**
     * Sets the value of the createProducerAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateProducerAgent(String value) {
        this.createProducerAgent = value;
    }

}
