
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDepositActivityByUpdateDateByMaterialFlowResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDepositActivityByUpdateDateByMaterialFlowResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateDateResultByMF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDepositActivityByUpdateDateByMaterialFlowResponse", propOrder = {
    "updateDateResultByMF"
})
public class GetDepositActivityByUpdateDateByMaterialFlowResponse {

    @XmlElement(name = "UpdateDateResultByMF")
    protected String updateDateResultByMF;

    /**
     * Gets the value of the updateDateResultByMF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateDateResultByMF() {
        return updateDateResultByMF;
    }

    /**
     * Sets the value of the updateDateResultByMF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateDateResultByMF(String value) {
        this.updateDateResultByMF = value;
    }

}
