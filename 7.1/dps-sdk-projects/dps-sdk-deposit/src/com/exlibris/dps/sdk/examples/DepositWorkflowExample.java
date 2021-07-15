package com.exlibris.dps.sdk.examples;

import java.net.URL;

import javax.xml.namespace.QName;

import com.exlibris.digitool.deposit.service.xmlbeans.DepositDataDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositResultDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositDataDocument.DepositData;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositResultDocument.DepositResult;
import com.exlibris.dps.DepositWebServices_Service;
import com.exlibris.dps.ProducerWebServices;
import com.exlibris.dps.ProducerWebServices_Service;
import com.exlibris.dps.SipStatusInfo;
import com.exlibris.dps.SipWebServices_Service;
import com.exlibris.dps.sdk.pds.HeaderHandlerResolver;

public class DepositWorkflowExample {

	static final String userName = "admin1";
	static final String institution = "INS00";
	static final String password = "a12345678A";
	static final String materialflowId = "5";
	static final String depositSetId = "1";

	//should be placed under where submissionformat of MF is configured
	static final String subDirectoryName = "/folder_on_unix_machine/deposits/dep1";

	static final String DEPOSIT_WSDL_URL = "http://localhost:1801/dpsws/deposit/DepositWebServices?wsdl";
	static final String PRODUCER_WSDL_URL = "http://localhost:1801/dpsws/backoffice/ProducerWebServices?wsdl";
	static final String SIP_STATUS_WSDL_URL = "http://localhost:1801/dpsws/repository/SipWebServices?wsdl";


	/**
	 * Example of a bulk deposit program using the API of DepositWebServices
	 *
	 * @param args
	 *            location of ingest.properties file.
	 */
	public static void main(String[] args) {

		org.apache.log4j.helpers.LogLog.setQuietMode(true);

		try {
			ProducerWebServices_Service proWS = new ProducerWebServices_Service(new URL(PRODUCER_WSDL_URL),new QName("http://dps.exlibris.com/", "ProducerWebServices"));
			proWS.setHandlerResolver(new HeaderHandlerResolver(userName, password, institution));
			ProducerWebServices producerWebServices = proWS.getProducerWebServicesPort();
			String producerAgentId = producerWebServices
					.getInternalUserIdByExternalId(userName);
			String xmlReply = producerWebServices.getProducersOfProducerAgent(producerAgentId);
			DepositDataDocument depositDataDocument = DepositDataDocument.Factory
					.parse(xmlReply);
			DepositData depositData = depositDataDocument.getDepositData();

			String producerId = depositData.getDepDataArray(0).getId();
			System.out.println("Producer ID: " + producerId);

			//Create the IE using IE parser...

			//Create a deposit folder under the Unix Machine...
			DepositWebServices_Service depWS = new DepositWebServices_Service(new URL(DEPOSIT_WSDL_URL),new QName("http://dps.exlibris.com/", "DepositWebServices"));
			depWS.setHandlerResolver(new HeaderHandlerResolver(userName, password, institution));
			String retval = depWS.getDepositWebServicesPort().submitDepositActivity(null ,materialflowId, subDirectoryName, producerId, depositSetId);
			System.out.println("Submit Deposit Result: " + retval);

			DepositResultDocument depositResultDocument = DepositResultDocument.Factory.parse(retval);
			DepositResult depositResult = depositResultDocument.getDepositResult();

			//check status of sip when deposit was successful

			if(depositResult.getIsError()){
				System.out.println("Submit Deposit Failed");
			}else{
				SipStatusInfo status = new SipWebServices_Service(new URL(SIP_STATUS_WSDL_URL),new QName("http://dps.exlibris.com/", "SipWebServices")).getSipWebServicesPort().getSIPStatusInfo(String.valueOf(depositResult.getSipId()), false);
				System.out.println("Submitted Deposit Status: " + status.getStatus());
				System.out.println("Submitted Deposit Stage: " + status.getStage());
				System.out.println("Submitted Deposit is in Module: " + status.getModule());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
