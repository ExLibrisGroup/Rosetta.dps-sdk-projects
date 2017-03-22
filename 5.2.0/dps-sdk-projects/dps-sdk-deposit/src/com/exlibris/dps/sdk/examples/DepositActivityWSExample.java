package com.exlibris.dps.sdk.examples;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlException;

import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityListDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityStatus;
import com.exlibris.digitool.deposit.service.xmlbeans.Record;
import com.exlibris.digitool.deposit.service.xmlbeans.Records;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositActivityListDocument.DepositActivityList;
import com.exlibris.dps.DepositWebServices;
import com.exlibris.dps.DepositWebServices_Service;
import com.exlibris.dps.sdk.pds.PdsClient;

public class DepositActivityWSExample {

	static final String WSDL_URL = "http://localhost:1801/dpsws/deposit/DepositWebServices?wsdl";
	static final String PDS_URL = "http://il-dtldev04:8992/pds";
	static final Long numberOfRecords = 8L;

	public static void main(String[] args) {

		/* get pds handle */
		String pdsHandle = null;

		String userName = "admin1";
		String password = "a12345678A";
		String institution = "INS00";

		try {
			// Connecting to PDS
			PdsClient pds = PdsClient.getInstance();
			pds.init(PDS_URL,false);
			pdsHandle = pds.login(institution, userName, password);
		} catch(Exception e){}

		//If rosetta_ws_demo_mode is true a client side demo implementation is used ,otherwise the Server Web Service implementation is used
		DepositWebServices services = null;
		try {
			services = new DepositWebServices_Service(new URL(WSDL_URL),new QName("http://dps.exlibris.com/", "DepositWebServices")).getDepositWebServicesPort();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//DepositWebServices services = DepositWSFactory.create(WSDL_URL);
		String result;

		/* get deposit activity list by submit date */
		result = services.getDepositActivityBySubmitDate(pdsHandle, "Inprocess", "10000", "763", "20/01/2009", "20/02/2010", "11", "14");
		System.out.println("example xml from xml - by submit date:\n"+result+"\n");

		/* get deposit activity list by update date */
		result = services.getDepositActivityByUpdateDate(pdsHandle, "Inprocess", "10000", "763", "20/01/2009", "20/02/2010", "11", "14");
		System.out.println("example xml from xml - by update date:\n"+result+"\n");

		DepositActivityListDocument doc;
		try {
			/* example of working on xml using xml bean */
			doc = workOnDepositListXml(result);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//error response example
		result = services.getDepositActivityByUpdateDate(pdsHandle, "Inprocess", "a", "aa", "20/01/2009", "20/02/2010", "1", "20");
		System.out.println("example xml from xml on  error:\n"+result+"\n");
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
