
package com.exlibris.dps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setMembersInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setMembersInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfIesAdded" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numberOfIesNotAdded" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="setId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="iEsNotAddedList" type="{http://dps.exlibris.com/}paExecutionError" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setMembersInfo", propOrder = {
    "numberOfIesAdded",
    "numberOfIesNotAdded",
    "setId",
    "iEsNotAddedList"
})
public class SetMembersInfo {

    protected long numberOfIesAdded;
    protected long numberOfIesNotAdded;
    protected Long setId;
    @XmlElement(nillable = true)
    protected List<PaExecutionError> iEsNotAddedList;

    /**
     * Gets the value of the numberOfIesAdded property.
     * 
     */
    public long getNumberOfIesAdded() {
        return numberOfIesAdded;
    }

    /**
     * Sets the value of the numberOfIesAdded property.
     * 
     */
    public void setNumberOfIesAdded(long value) {
        this.numberOfIesAdded = value;
    }

    /**
     * Gets the value of the numberOfIesNotAdded property.
     * 
     */
    public long getNumberOfIesNotAdded() {
        return numberOfIesNotAdded;
    }

    /**
     * Sets the value of the numberOfIesNotAdded property.
     * 
     */
    public void setNumberOfIesNotAdded(long value) {
        this.numberOfIesNotAdded = value;
    }

    /**
     * Gets the value of the setId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSetId() {
        return setId;
    }

    /**
     * Sets the value of the setId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSetId(Long value) {
        this.setId = value;
    }

    /**
     * Gets the value of the iEsNotAddedList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iEsNotAddedList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIEsNotAddedList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaExecutionError }
     * 
     * 
     */
    public List<PaExecutionError> getIEsNotAddedList() {
        if (iEsNotAddedList == null) {
            iEsNotAddedList = new ArrayList<PaExecutionError>();
        }
        return this.iEsNotAddedList;
    }

}
