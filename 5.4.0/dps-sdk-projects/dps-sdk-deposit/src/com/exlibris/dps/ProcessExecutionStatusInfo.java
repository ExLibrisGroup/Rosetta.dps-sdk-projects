
package com.exlibris.dps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processExecutionStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processExecutionStatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="executionExceptions" type="{http://dps.exlibris.com/}paExecutionError" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processExecutionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processExecutionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalRecordsFailed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalRecordsProcessed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processExecutionStatusInfo", propOrder = {
    "executionExceptions",
    "processExecutionId",
    "processExecutionStatus",
    "processId",
    "processName",
    "totalRecordsFailed",
    "totalRecordsProcessed"
})
public class ProcessExecutionStatusInfo {

    @XmlElement(nillable = true)
    protected List<PaExecutionError> executionExceptions;
    protected long processExecutionId;
    protected String processExecutionStatus;
    protected long processId;
    protected String processName;
    protected long totalRecordsFailed;
    protected long totalRecordsProcessed;

    /**
     * Gets the value of the executionExceptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the executionExceptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecutionExceptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaExecutionError }
     * 
     * 
     */
    public List<PaExecutionError> getExecutionExceptions() {
        if (executionExceptions == null) {
            executionExceptions = new ArrayList<PaExecutionError>();
        }
        return this.executionExceptions;
    }

    /**
     * Gets the value of the processExecutionId property.
     * 
     */
    public long getProcessExecutionId() {
        return processExecutionId;
    }

    /**
     * Sets the value of the processExecutionId property.
     * 
     */
    public void setProcessExecutionId(long value) {
        this.processExecutionId = value;
    }

    /**
     * Gets the value of the processExecutionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessExecutionStatus() {
        return processExecutionStatus;
    }

    /**
     * Sets the value of the processExecutionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessExecutionStatus(String value) {
        this.processExecutionStatus = value;
    }

    /**
     * Gets the value of the processId property.
     * 
     */
    public long getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     */
    public void setProcessId(long value) {
        this.processId = value;
    }

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

    /**
     * Gets the value of the totalRecordsFailed property.
     * 
     */
    public long getTotalRecordsFailed() {
        return totalRecordsFailed;
    }

    /**
     * Sets the value of the totalRecordsFailed property.
     * 
     */
    public void setTotalRecordsFailed(long value) {
        this.totalRecordsFailed = value;
    }

    /**
     * Gets the value of the totalRecordsProcessed property.
     * 
     */
    public long getTotalRecordsProcessed() {
        return totalRecordsProcessed;
    }

    /**
     * Sets the value of the totalRecordsProcessed property.
     * 
     */
    public void setTotalRecordsProcessed(long value) {
        this.totalRecordsProcessed = value;
    }

}
