
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSIPStatusInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSIPStatusInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SipStatusInfo" type="{http://dps.exlibris.com/}sipStatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSIPStatusInfoResponse", propOrder = {
    "sipStatusInfo"
})
public class GetSIPStatusInfoResponse {

    @XmlElement(name = "SipStatusInfo")
    protected SipStatusInfo sipStatusInfo;

    /**
     * Gets the value of the sipStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SipStatusInfo }
     *     
     */
    public SipStatusInfo getSipStatusInfo() {
        return sipStatusInfo;
    }

    /**
     * Sets the value of the sipStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SipStatusInfo }
     *     
     */
    public void setSipStatusInfo(SipStatusInfo value) {
        this.sipStatusInfo = value;
    }

}
