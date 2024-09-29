
package com.exlibris.dps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSIPsStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSIPsStatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfIEs" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sipId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSIPsStatusInfo", propOrder = {
    "numberOfIEs",
    "sipId"
})
public class GetSIPsStatusInfo {

    protected boolean numberOfIEs;
    @XmlElement(nillable = true)
    protected List<String> sipId;

    /**
     * Gets the value of the numberOfIEs property.
     * 
     */
    public boolean isNumberOfIEs() {
        return numberOfIEs;
    }

    /**
     * Sets the value of the numberOfIEs property.
     * 
     */
    public void setNumberOfIEs(boolean value) {
        this.numberOfIEs = value;
    }

    /**
     * Gets the value of the sipId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sipId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSipId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSipId() {
        if (sipId == null) {
            sipId = new ArrayList<String>();
        }
        return this.sipId;
    }

}
