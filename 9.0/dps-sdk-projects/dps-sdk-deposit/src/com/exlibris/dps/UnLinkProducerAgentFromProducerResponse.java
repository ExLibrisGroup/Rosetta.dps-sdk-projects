
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unLinkProducerAgentFromProducerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unLinkProducerAgentFromProducerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unLinkProducerAgentFromProducer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unLinkProducerAgentFromProducerResponse", propOrder = {
    "unLinkProducerAgentFromProducer"
})
public class UnLinkProducerAgentFromProducerResponse {

    protected String unLinkProducerAgentFromProducer;

    /**
     * Gets the value of the unLinkProducerAgentFromProducer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnLinkProducerAgentFromProducer() {
        return unLinkProducerAgentFromProducer;
    }

    /**
     * Sets the value of the unLinkProducerAgentFromProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnLinkProducerAgentFromProducer(String value) {
        this.unLinkProducerAgentFromProducer = value;
    }

}
