
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProducersOfProducerAgentWithInsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProducersOfProducerAgentWithInsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProducersResultWithIns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProducersOfProducerAgentWithInsResponse", propOrder = {
    "producersResultWithIns"
})
public class GetProducersOfProducerAgentWithInsResponse {

    @XmlElement(name = "ProducersResultWithIns")
    protected String producersResultWithIns;

    /**
     * Gets the value of the producersResultWithIns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducersResultWithIns() {
        return producersResultWithIns;
    }

    /**
     * Sets the value of the producersResultWithIns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducersResultWithIns(String value) {
        this.producersResultWithIns = value;
    }

}
