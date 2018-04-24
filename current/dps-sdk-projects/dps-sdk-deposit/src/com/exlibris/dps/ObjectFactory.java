
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

    private final static QName _GetHeartBit_QNAME = new QName("http://dps.exlibris.com/", "getHeartBit");
    private final static QName _UpdateSetMembers_QNAME = new QName("http://dps.exlibris.com/", "updateSetMembers");
    private final static QName _UserAuthorizeException_QNAME = new QName("http://dps.exlibris.com/", "UserAuthorizeException");
    private final static QName _RunProcessResponse_QNAME = new QName("http://dps.exlibris.com/", "runProcessResponse");
    private final static QName _GetProcessExecutionStatusResponse_QNAME = new QName("http://dps.exlibris.com/", "getProcessExecutionStatusResponse");
    private final static QName _SetNotValidException_QNAME = new QName("http://dps.exlibris.com/", "SetNotValidException");
    private final static QName _ProcessException_QNAME = new QName("http://dps.exlibris.com/", "ProcessException");
    private final static QName _GetHeartBitResponse_QNAME = new QName("http://dps.exlibris.com/", "getHeartBitResponse");
    private final static QName _UpdateSetMembersResponse_QNAME = new QName("http://dps.exlibris.com/", "updateSetMembersResponse");
    private final static QName _GetProcessExecutionStatus_QNAME = new QName("http://dps.exlibris.com/", "getProcessExecutionStatus");
    private final static QName _RunProcess_QNAME = new QName("http://dps.exlibris.com/", "runProcess");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exlibris.dps
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RunProcessResponse }
     * 
     */
    public RunProcessResponse createRunProcessResponse() {
        return new RunProcessResponse();
    }

    /**
     * Create an instance of {@link SetMembersInfo }
     * 
     */
    public SetMembersInfo createSetMembersInfo() {
        return new SetMembersInfo();
    }

    /**
     * Create an instance of {@link SetNotValidException }
     * 
     */
    public SetNotValidException createSetNotValidException() {
        return new SetNotValidException();
    }

    /**
     * Create an instance of {@link ProcessException }
     * 
     */
    public ProcessException createProcessException() {
        return new ProcessException();
    }

    /**
     * Create an instance of {@link RunProcess }
     * 
     */
    public RunProcess createRunProcess() {
        return new RunProcess();
    }

    /**
     * Create an instance of {@link GetProcessExecutionStatusResponse }
     * 
     */
    public GetProcessExecutionStatusResponse createGetProcessExecutionStatusResponse() {
        return new GetProcessExecutionStatusResponse();
    }

    /**
     * Create an instance of {@link UpdateSetMembers }
     * 
     */
    public UpdateSetMembers createUpdateSetMembers() {
        return new UpdateSetMembers();
    }

    /**
     * Create an instance of {@link GetHeartBitResponse }
     * 
     */
    public GetHeartBitResponse createGetHeartBitResponse() {
        return new GetHeartBitResponse();
    }

    /**
     * Create an instance of {@link GetProcessExecutionStatus }
     * 
     */
    public GetProcessExecutionStatus createGetProcessExecutionStatus() {
        return new GetProcessExecutionStatus();
    }

    /**
     * Create an instance of {@link ProcessExecutionStatusInfo }
     * 
     */
    public ProcessExecutionStatusInfo createProcessExecutionStatusInfo() {
        return new ProcessExecutionStatusInfo();
    }

    /**
     * Create an instance of {@link GetHeartBit }
     * 
     */
    public GetHeartBit createGetHeartBit() {
        return new GetHeartBit();
    }

    /**
     * Create an instance of {@link UpdateSetMembersResponse }
     * 
     */
    public UpdateSetMembersResponse createUpdateSetMembersResponse() {
        return new UpdateSetMembersResponse();
    }

    /**
     * Create an instance of {@link PaExecutionError }
     * 
     */
    public PaExecutionError createPaExecutionError() {
        return new PaExecutionError();
    }

    /**
     * Create an instance of {@link UserAuthorizeException }
     * 
     */
    public UserAuthorizeException createUserAuthorizeException() {
        return new UserAuthorizeException();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSetMembers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "updateSetMembers")
    public JAXBElement<UpdateSetMembers> createUpdateSetMembers(UpdateSetMembers value) {
        return new JAXBElement<UpdateSetMembers>(_UpdateSetMembers_QNAME, UpdateSetMembers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthorizeException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "UserAuthorizeException")
    public JAXBElement<UserAuthorizeException> createUserAuthorizeException(UserAuthorizeException value) {
        return new JAXBElement<UserAuthorizeException>(_UserAuthorizeException_QNAME, UserAuthorizeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "runProcessResponse")
    public JAXBElement<RunProcessResponse> createRunProcessResponse(RunProcessResponse value) {
        return new JAXBElement<RunProcessResponse>(_RunProcessResponse_QNAME, RunProcessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProcessExecutionStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getProcessExecutionStatusResponse")
    public JAXBElement<GetProcessExecutionStatusResponse> createGetProcessExecutionStatusResponse(GetProcessExecutionStatusResponse value) {
        return new JAXBElement<GetProcessExecutionStatusResponse>(_GetProcessExecutionStatusResponse_QNAME, GetProcessExecutionStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNotValidException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "SetNotValidException")
    public JAXBElement<SetNotValidException> createSetNotValidException(SetNotValidException value) {
        return new JAXBElement<SetNotValidException>(_SetNotValidException_QNAME, SetNotValidException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "ProcessException")
    public JAXBElement<ProcessException> createProcessException(ProcessException value) {
        return new JAXBElement<ProcessException>(_ProcessException_QNAME, ProcessException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSetMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "updateSetMembersResponse")
    public JAXBElement<UpdateSetMembersResponse> createUpdateSetMembersResponse(UpdateSetMembersResponse value) {
        return new JAXBElement<UpdateSetMembersResponse>(_UpdateSetMembersResponse_QNAME, UpdateSetMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProcessExecutionStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "getProcessExecutionStatus")
    public JAXBElement<GetProcessExecutionStatus> createGetProcessExecutionStatus(GetProcessExecutionStatus value) {
        return new JAXBElement<GetProcessExecutionStatus>(_GetProcessExecutionStatus_QNAME, GetProcessExecutionStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunProcess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dps.exlibris.com/", name = "runProcess")
    public JAXBElement<RunProcess> createRunProcess(RunProcess value) {
        return new JAXBElement<RunProcess>(_RunProcess_QNAME, RunProcess.class, null, value);
    }

}
