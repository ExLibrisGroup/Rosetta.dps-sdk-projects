
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for linkProducerAgentToProdcuerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="linkProducerAgentToProdcuerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkProducerAgentToProdcuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkProducerAgentToProdcuerResponse", propOrder = {
    "linkProducerAgentToProdcuer"
})
public class LinkProducerAgentToProdcuerResponse {

    @XmlElement(name = "LinkProducerAgentToProdcuer")
    protected String linkProducerAgentToProdcuer;

    /**
     * Gets the value of the linkProducerAgentToProdcuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkProducerAgentToProdcuer() {
        return linkProducerAgentToProdcuer;
    }

    /**
     * Sets the value of the linkProducerAgentToProdcuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkProducerAgentToProdcuer(String value) {
        this.linkProducerAgentToProdcuer = value;
    }

}
