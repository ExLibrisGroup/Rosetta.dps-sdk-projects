
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInternalUserIdByExternalIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInternalUserIdByExternalIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetInternalUserIdByExternalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInternalUserIdByExternalIdResponse", propOrder = {
    "getInternalUserIdByExternalId"
})
public class GetInternalUserIdByExternalIdResponse {

    @XmlElement(name = "GetInternalUserIdByExternalId")
    protected String getInternalUserIdByExternalId;

    /**
     * Gets the value of the getInternalUserIdByExternalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetInternalUserIdByExternalId() {
        return getInternalUserIdByExternalId;
    }

    /**
     * Sets the value of the getInternalUserIdByExternalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetInternalUserIdByExternalId(String value) {
        this.getInternalUserIdByExternalId = value;
    }

}
