
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unLinkContactFromProdcuerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unLinkContactFromProdcuerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnLinkContactFromProdcuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unLinkContactFromProdcuerResponse", propOrder = {
    "unLinkContactFromProdcuer"
})
public class UnLinkContactFromProdcuerResponse {

    @XmlElement(name = "UnLinkContactFromProdcuer")
    protected String unLinkContactFromProdcuer;

    /**
     * Gets the value of the unLinkContactFromProdcuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnLinkContactFromProdcuer() {
        return unLinkContactFromProdcuer;
    }

    /**
     * Sets the value of the unLinkContactFromProdcuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnLinkContactFromProdcuer(String value) {
        this.unLinkContactFromProdcuer = value;
    }

}
