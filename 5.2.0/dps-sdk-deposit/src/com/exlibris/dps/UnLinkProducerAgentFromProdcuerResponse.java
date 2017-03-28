
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unLinkProducerAgentFromProdcuerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unLinkProducerAgentFromProdcuerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnLinkProducerAgentFromProdcuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unLinkProducerAgentFromProdcuerResponse", propOrder = {
    "unLinkProducerAgentFromProdcuer"
})
public class UnLinkProducerAgentFromProdcuerResponse {

    @XmlElement(name = "UnLinkProducerAgentFromProdcuer")
    protected String unLinkProducerAgentFromProdcuer;

    /**
     * Gets the value of the unLinkProducerAgentFromProdcuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnLinkProducerAgentFromProdcuer() {
        return unLinkProducerAgentFromProdcuer;
    }

    /**
     * Sets the value of the unLinkProducerAgentFromProdcuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnLinkProducerAgentFromProdcuer(String value) {
        this.unLinkProducerAgentFromProdcuer = value;
    }

}
