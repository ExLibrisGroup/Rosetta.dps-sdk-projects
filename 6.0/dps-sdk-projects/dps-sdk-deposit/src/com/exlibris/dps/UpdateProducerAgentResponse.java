
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateProducerAgentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateProducerAgentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateProducerAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateProducerAgentResponse", propOrder = {
    "updateProducerAgent"
})
public class UpdateProducerAgentResponse {

    @XmlElement(name = "UpdateProducerAgent")
    protected String updateProducerAgent;

    /**
     * Gets the value of the updateProducerAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateProducerAgent() {
        return updateProducerAgent;
    }

    /**
     * Sets the value of the updateProducerAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateProducerAgent(String value) {
        this.updateProducerAgent = value;
    }

}
