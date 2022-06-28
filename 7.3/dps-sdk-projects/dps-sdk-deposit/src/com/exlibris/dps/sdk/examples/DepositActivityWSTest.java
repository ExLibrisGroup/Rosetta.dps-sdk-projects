package com.exlibris.dps.sdk.examples;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlException;

import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityListDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityListDocument.DepositActivityList;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityStatus;
import com.exlibris.digitool.deposit.service.xmlbeans.Record;
import com.exlibris.digitool.deposit.service.xmlbeans.Records;
import com.exlibris.dps.DepositWebServices;
import com.exlibris.dps.DepositWebServices_Service;
import com.exlibris.dps.sdk.pds.HeaderHandlerResolver;

public class DepositActivityWSTest {

	static final String WSDL_URL = "http://localhost:1801/dpsws/deposit/DepositWebServices?wsdl";
	static final String PDS_URL = "http://il-dtldev04:8992/pds";
	static final Long numberOfRecords = 8L;

	public static void main(String[] args) {

	
		String userName = "admin1";
		String password = "a12345678A";
		String institution = "INS00";
		
		DepositWebServices services = null;
		try {
			DepositWebServices_Service depWS = new DepositWebServices_Service(new URL(WSDL_URL),new QName("http://dps.exlibris.com/", "DepositWebServices"));
			depWS.setHandlerResolver(new HeaderHandlerResolver(userName, password, institution));
			
			services = depWS.getDepositWebServicesPort();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result;

		/* DPS-4624
		 * get list with producer agent 100 - admin1
		 * get list with producer agent 100000 - Aackart
		 * get list with all producer agents
		 * */
//		result = services.getDepositActivityBySubmitDate(pdsHandle, "Inprocess", "10000", "100", "20/01/2010", "20/12/2010", "1", "10");
//		System.out.println("test producerAgent in filter:\n"+result+"\n");
//		result = services.getDepositActivityBySubmitDate(pdsHandle, "Inprocess", "10000", "100000", "20/01/2010", "20/12/2010", "1", "10");
//		System.out.println("test producerAgent in filter:\n"+result+"\n");
//		result = services.getDepositActivityBySubmitDate(pdsHandle, "Inprocess", "10000", null, "20/01/2010", "20/12/2010", "1", "10");
//		System.out.println("test producerAgent in filter:\n"+result+"\n");
//		System.out.println(services.getDepositActivityBySubmitDate(pdsHandle, "All", "10000", null, "20/01/2010", "20/12/2010", "1", "10"));

		System.out.println("get all new MF - mine\n"+
				services.getDepositActivityBySubmitDateByMaterialFlow(null, "All", "33980", "10000", null, "20/01/2010", "20/12/2010", "1", "30")
				);
		System.out.println("get standard MF - 1\n"+
				services.getDepositActivityBySubmitDateByMaterialFlow(null, "All", "1", "10000", null, "20/01/2010", "20/12/2010", "1", "30")
				);

		System.out.println("get all MF \n"+
				services.getDepositActivityBySubmitDate(null, "All", "10000", null, "20/01/2010", "20/12/2010", "1", "30")
				);


	}

	//Example for parsing and using the XML response using the xml beans
	public static DepositActivityListDocument workOnDepositListXml(String xml) throws XmlException {
		DepositActivityListDocument doc = DepositActivityListDocument.Factory.parse(xml);
		DepositActivityList depositActivityList = doc.getDepositActivityList();
		depositActivityList.setIsError(false);
		depositActivityList.setTotalRecords(numberOfRecords);
		Records records = depositActivityList.getRecords();
		if (records!=null) {
			for (Record record : records.getRecordArray()) {
				record.setUpdateDate("08/01/2009");
				record.setStatus(DepositActivityStatus.APPROVED);
				record.setProducerId(100L);
			}
		}
		return doc;
	}
}
