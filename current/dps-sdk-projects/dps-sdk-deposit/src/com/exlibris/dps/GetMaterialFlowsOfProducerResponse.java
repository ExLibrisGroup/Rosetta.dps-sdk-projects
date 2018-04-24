
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMaterialFlowsOfProducerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMaterialFlowsOfProducerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaterialFlowsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMaterialFlowsOfProducerResponse", propOrder = {
    "materialFlowsResult"
})
public class GetMaterialFlowsOfProducerResponse {

    @XmlElement(name = "MaterialFlowsResult")
    protected String materialFlowsResult;

    /**
     * Gets the value of the materialFlowsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialFlowsResult() {
        return materialFlowsResult;
    }

    /**
     * Sets the value of the materialFlowsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialFlowsResult(String value) {
        this.materialFlowsResult = value;
    }

}
