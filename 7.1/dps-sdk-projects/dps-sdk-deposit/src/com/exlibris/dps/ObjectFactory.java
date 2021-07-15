
package com.exlibris.dps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exlibris.dps package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubmitDepositActivityResponse_QNAME = new QName("http://dps.exlibris.com/", "submitDepositActivityResponse");
    private final static QName _GetDepositActivityBySubmitDateByMaterialFlow_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityBySubmitDateByMaterialFlow");
    private final static QName _GetDepositActivityByUpdateDate_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityByUpdateDate");
    private final static QName _GetDepositActivityByUpdateDateResponse_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityByUpdateDateResponse");
    private final static QName _GetHeartBit_QNAME = new QName("http://dps.exlibris.com/", "getHeartBit");
    private final static QName _GetDepositActivityBySubmitDateByMaterialFlowResponse_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityBySubmitDateByMaterialFlowResponse");
    private final static QName _GetDepositActivityBySubmitDate_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityBySubmitDate");
    private final static QName _GetHeartBitResponse_QNAME = new QName("http://dps.exlibris.com/", "getHeartBitResponse");
    private final static QName _GetDepositActivityBySubmitDateResponse_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityBySubmitDateResponse");
    private final static QName _GetDepositActivityByUpdateDateByMaterialFlowResponse_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityByUpdateDateByMaterialFlowResponse");
    private final static QName _SubmitDepositActivity_QNAME = new QName("http://dps.exlibris.com/", "submitDepositActivity");
    private final static QName _GetDepositActivityByUpdateDateByMaterialFlow_QNAME = new QName("http://dps.exlibris.com/", "getDepositActivityByUpdateDateByMaterialFlow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exlibris.dps
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHeartBit }
     * 
     */
    public GetHeartBit createGetHeartBit() {
        return new GetHeartBit();
    }

    /**
     * Create an instance of {@link GetDepositActivityByUpdateDateResponse }
     * 
     */
    public GetDepositActivityByUpdateDateResponse createGetDepositActivityByUpdateDateResponse() {
        return new GetDepositActivityByUpdateDateResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityBySubmitDateByMaterialFlow }
     * 
     */
    public GetDepositActivityBySubmitDateByMaterialFlow createGetDepositActivityBySubmitDateByMaterialFlow() {
        return new GetDepositActivityBySubmitDateByMaterialFlow();
    }

    /**
     * Create an instance of {@link GetDepositActivityByUpdateDate }
     * 
     */
    public GetDepositActivityByUpdateDate createGetDepositActivityByUpdateDate() {
        return new GetDepositActivityByUpdateDate();
    }

    /**
     * Create an instance of {@link SubmitDepositActivityResponse }
     * 
     */
    public SubmitDepositActivityResponse createSubmitDepositActivityResponse() {
        return new SubmitDepositActivityResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityByUpdateDateByMaterialFlow }
     * 
     */
    public GetDepositActivityByUpdateDateByMaterialFlow createGetDepositActivityByUpdateDateByMaterialFlow() {
        return new GetDepositActivityByUpdateDateByMaterialFlow();
    }

    /**
     * Create an instance of {@link SubmitDepositActivity }
     * 
     */
    public SubmitDepositActivity createSubmitDepositActivity() {
        return new SubmitDepositActivity();
    }

    /**
     * Create an instance of {@link GetHeartBitResponse }
     * 
     */
    public GetHeartBitResponse createGetHeartBitResponse() {
        return new GetHeartBitResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityBySubmitDateResponse }
     * 
     */
    public GetDepositActivityBySubmitDateResponse createGetDepositActivityBySubmitDateResponse() {
        return new GetDepositActivityBySubmitDateResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityByUpdateDateByMaterialFlowResponse }
     * 
     */
    public GetDepositActivityByUpdateDateByMaterialFlowResponse createGetDepositActivityByUpdateDateByMaterialFlowResponse() {
        return new GetDepositActivityByUpdateDateByMaterialFlowResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityBySubmitDateByMaterialFlowResponse }
     * 
     */
    public GetDepositActivityBySubmitDateByMaterialFlowResponse createGetDepositActivityBySubmitDateByMaterialFlowResponse() {
        return new GetDepositActivityBySubmitDateByMaterialFlowResponse();
    }

    /**
     * Create an instance of {@link GetDepositActivityBySubmitDate }
     * 
     */
    public GetDepositActivityBySubmitDate createGetDepositActivityBySubmitDate() {
        return new GetDepositActivityBySubmitDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDepositActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "submitDepositActivityResponse")
    public JAXBElement<SubmitDepositActivityResponse> createSubmitDepositActivityResponse(SubmitDepositActivityResponse value) {
        return new JAXBElement<SubmitDepositActivityResponse>(_SubmitDepositActivityResponse_QNAME, SubmitDepositActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityBySubmitDateByMaterialFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityBySubmitDateByMaterialFlow")
    public JAXBElement<GetDepositActivityBySubmitDateByMaterialFlow> createGetDepositActivityBySubmitDateByMaterialFlow(GetDepositActivityBySubmitDateByMaterialFlow value) {
        return new JAXBElement<GetDepositActivityBySubmitDateByMaterialFlow>(_GetDepositActivityBySubmitDateByMaterialFlow_QNAME, GetDepositActivityBySubmitDateByMaterialFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityByUpdateDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityByUpdateDate")
    public JAXBElement<GetDepositActivityByUpdateDate> createGetDepositActivityByUpdateDate(GetDepositActivityByUpdateDate value) {
        return new JAXBElement<GetDepositActivityByUpdateDate>(_GetDepositActivityByUpdateDate_QNAME, GetDepositActivityByUpdateDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityByUpdateDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityByUpdateDateResponse")
    public JAXBElement<GetDepositActivityByUpdateDateResponse> createGetDepositActivityByUpdateDateResponse(GetDepositActivityByUpdateDateResponse value) {
        return new JAXBElement<GetDepositActivityByUpdateDateResponse>(_GetDepositActivityByUpdateDateResponse_QNAME, GetDepositActivityByUpdateDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHeartBit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getHeartBit")
    public JAXBElement<GetHeartBit> createGetHeartBit(GetHeartBit value) {
        return new JAXBElement<GetHeartBit>(_GetHeartBit_QNAME, GetHeartBit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityBySubmitDateByMaterialFlowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityBySubmitDateByMaterialFlowResponse")
    public JAXBElement<GetDepositActivityBySubmitDateByMaterialFlowResponse> createGetDepositActivityBySubmitDateByMaterialFlowResponse(GetDepositActivityBySubmitDateByMaterialFlowResponse value) {
        return new JAXBElement<GetDepositActivityBySubmitDateByMaterialFlowResponse>(_GetDepositActivityBySubmitDateByMaterialFlowResponse_QNAME, GetDepositActivityBySubmitDateByMaterialFlowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityBySubmitDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityBySubmitDate")
    public JAXBElement<GetDepositActivityBySubmitDate> createGetDepositActivityBySubmitDate(GetDepositActivityBySubmitDate value) {
        return new JAXBElement<GetDepositActivityBySubmitDate>(_GetDepositActivityBySubmitDate_QNAME, GetDepositActivityBySubmitDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHeartBitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getHeartBitResponse")
    public JAXBElement<GetHeartBitResponse> createGetHeartBitResponse(GetHeartBitResponse value) {
        return new JAXBElement<GetHeartBitResponse>(_GetHeartBitResponse_QNAME, GetHeartBitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityBySubmitDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityBySubmitDateResponse")
    public JAXBElement<GetDepositActivityBySubmitDateResponse> createGetDepositActivityBySubmitDateResponse(GetDepositActivityBySubmitDateResponse value) {
        return new JAXBElement<GetDepositActivityBySubmitDateResponse>(_GetDepositActivityBySubmitDateResponse_QNAME, GetDepositActivityBySubmitDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityByUpdateDateByMaterialFlowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityByUpdateDateByMaterialFlowResponse")
    public JAXBElement<GetDepositActivityByUpdateDateByMaterialFlowResponse> createGetDepositActivityByUpdateDateByMaterialFlowResponse(GetDepositActivityByUpdateDateByMaterialFlowResponse value) {
        return new JAXBElement<GetDepositActivityByUpdateDateByMaterialFlowResponse>(_GetDepositActivityByUpdateDateByMaterialFlowResponse_QNAME, GetDepositActivityByUpdateDateByMaterialFlowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDepositActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "submitDepositActivity")
    public JAXBElement<SubmitDepositActivity> createSubmitDepositActivity(SubmitDepositActivity value) {
        return new JAXBElement<SubmitDepositActivity>(_SubmitDepositActivity_QNAME, SubmitDepositActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepositActivityByUpdateDateByMaterialFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getDepositActivityByUpdateDateByMaterialFlow")
    public JAXBElement<GetDepositActivityByUpdateDateByMaterialFlow> createGetDepositActivityByUpdateDateByMaterialFlow(GetDepositActivityByUpdateDateByMaterialFlow value) {
        return new JAXBElement<GetDepositActivityByUpdateDateByMaterialFlow>(_GetDepositActivityByUpdateDateByMaterialFlow_QNAME, GetDepositActivityByUpdateDateByMaterialFlow.class, null, value);
    }

}
