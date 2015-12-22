package com.exlibris.dps.sdk.examples;

import gov.loc.mets.DivType;
import gov.loc.mets.FileType;
import gov.loc.mets.MetsDocument;
import gov.loc.mets.StructMapType;
import gov.loc.mets.MetsDocument.Mets;
import gov.loc.mets.MetsType.FileSec.FileGrp;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlOptions;

import com.exlibris.core.sdk.formatting.DublinCore;
import com.exlibris.core.sdk.utils.FileUtil;
import com.exlibris.digitool.common.dnx.DnxDocument;
import com.exlibris.digitool.common.dnx.DnxDocumentHelper;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositDataDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositResultDocument;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositDataDocument.DepositData;
import com.exlibris.digitool.deposit.service.xmlbeans.DepositResultDocument.DepositResult;
import com.exlibris.dps.DepositWebServices_Service;
import com.exlibris.dps.ProducerWebServices;
import com.exlibris.dps.ProducerWebServices_Service;
import com.exlibris.dps.SipStatusInfo;
import com.exlibris.dps.SipWebServices_Service;
import com.exlibris.dps.sdk.deposit.IEParser;
import com.exlibris.dps.sdk.deposit.IEParserFactory;
import com.exlibris.dps.sdk.pds.PdsClient;
import com.exlibris.core.sdk.consts.Enum;

public class FullFlowExample {

	static final String userName = "admin1";
	static final String institution = "INS00";
	static final String password = "a12345678A";
	static final String materialflowId = "5";
	static final String depositSetId = "1";

	//should be placed under where submission format of MF is configured
	static final String subDirectoryName = "/DepositExample1";
	static final String folder_on_working_machine = "../dps-sdk-deposit/data/depositExamples";
	static final String filesRootFolder = folder_on_working_machine + "/DepositExample1/content/streams/";
	static final String IEfullFileName = folder_on_working_machine + "/DepositExample1/content/ie1.xml";

	static final String PDS_URL = "http://il-dtldev04:8992/pds";
	static final String DEPOSIT_WSDL_URL = "http://localhost:1801/dpsws/deposit/DepositWebServices?wsdl";
	static final String PRODUCER_WSDL_URL = "http://localhost:1801/dpsws/backoffice/ProducerWebServices?wsdl";
	static final String SIP_STATUS_WSDL_URL = "http://localhost:1801/dpsws/repository/SipWebServices?wsdl";


	/**
	 * Full Flow Example with all stages to create and make a Deposit.
	 *
	 */
	public static void main(String[] args) {

		org.apache.log4j.helpers.LogLog.setQuietMode(true);

		try {
			// 1. Create a SIP directory

			// 2. Create the IE using IE parser

			//list of files we are depositing
			File streamDir = new File(filesRootFolder);
			File[] files = streamDir.listFiles();

			//create parser
			IEParser ie = IEParserFactory.create();

			// add ie dc
			DublinCore dc = ie.getDublinCoreParser();
			dc.addElement("dc:creator", "Exlibris");
			dc.addElement("dc:identifier", "ISBN 1-56389-016-X");
			dc.addElement("dc:title", "SDK - TEST DC");
			ie.setIEDublinCore(dc);
			List<FileGrp> fGrpList = new ArrayList<FileGrp>();

			// add fileGrp
			FileGrp fGrp = ie.addNewFileGrp(Enum.UsageType.VIEW, Enum.PreservationType.PRESERVATION_MASTER);

			// add dnx - A new DNX is constructed and added on the file group level
			DnxDocument dnxDocument = ie.getFileGrpDnx(fGrp.getID());
			DnxDocumentHelper documentHelper = new DnxDocumentHelper(dnxDocument);
			documentHelper.getGeneralRepCharacteristics().setRevisionNumber("1");
			documentHelper.getGeneralRepCharacteristics().setLabel("test");

			//adding an event to the rep DNX
			List<DnxDocumentHelper.Event> eventList = new ArrayList<DnxDocumentHelper.Event>();
			DnxDocumentHelper.Event event = documentHelper.new Event();
			event.setEventIdentifierValue("Test");
			eventList.add(event);
			documentHelper.setEvents(eventList);

			ie.setFileGrpDnx(documentHelper.getDocument(), fGrp.getID());

			fGrpList.add(fGrp);

			for(int i=0;i<files.length;i++){

	            //add file and dnx metadata on file
	            String mimeType = "image/jpeg";
	            FileType fileType = ie.addNewFile(fGrp, mimeType, files[i].getName(), "test file " + i);

	            // add dnx - A new DNX is constructed and added on the file level
	            DnxDocument dnx = ie.getFileDnx(fileType.getID());
	            DnxDocumentHelper fileDocumentHelper = new DnxDocumentHelper(dnx);
	            fileDocumentHelper.getGeneralFileCharacteristics().setNote("note to test");
	            fileDocumentHelper.getGeneralFileCharacteristics().setLabel("test");
	            fileDocumentHelper.getGeneralFileCharacteristics().setFileOriginalPath(files[i].getAbsolutePath());
	            ie.setFileDnx(fileDocumentHelper.getDocument(), fileType.getID());
			}

            ie.generateChecksum(filesRootFolder, Enum.FixityType.MD5.toString());
            ie.updateSize(filesRootFolder);

            //default Structural Map
            ie.generateStructMap(fGrpList.get(0),null, "Table of Contents");

            //example for adding a logical Struct Map.
            MetsDocument metsDoc = MetsDocument.Factory.parse(ie.toXML());
            Mets mets = metsDoc.getMets();
            for(FileGrp fgrp:fGrpList){
            	StructMapType sm = mets.addNewStructMap();
                sm.setID(fgrp.getID() + "-" + 2);
                sm.setTYPE("LOGICAL");
                DivType div1 = sm.addNewDiv();
                div1.setLABEL("Test Struct Map");
                DivType div2 = div1.addNewDiv();
                div2.setLABEL("Table of Contents");
                DivType div3 = div2.addNewDiv();
                div3.setLABEL("Chapter 1");
                FileType file[] = fgrp.getFileArray();
                for(int i=0;i<file.length;i++){
                	DivType div = div3.addNewDiv(); // new div structure
                	div.setLABEL("Page " + i);
                    div.setTYPE("FILE");
                	div.addNewFptr().setFILEID(file[i].getID());
                }
            }

            //insert IE created in content directory
            File ieXML = new File(IEfullFileName);
            XmlOptions opt = new XmlOptions();
            opt.setSavePrettyPrint();
            FileUtil.writeFile(ieXML, metsDoc.xmlText(opt));

			// 3. Place the SIP directory in a folder that can be accessed by the Rosetta application (using FTP is a valid approach)

			// 4. Authenticate using the PDS authentication API

			// Connecting to PDS
			PdsClient pds = PdsClient.getInstance();
			pds.init(PDS_URL,false);
			String pdsHandle = pds.login(institution, userName, password);
			System.out.println("pdsHandle: " + pdsHandle);

			// 5. Submit Deposit

			ProducerWebServices producerWebServices = new ProducerWebServices_Service(new URL(PRODUCER_WSDL_URL),new QName("http://dps.exlibris.com/", "ProducerWebServices")).getProducerWebServicesPort();
			String producerAgentId = producerWebServices.getInternalUserIdByExternalId(userName);
			String xmlReply = producerWebServices.getProducersOfProducerAgent(producerAgentId);
			DepositDataDocument depositDataDocument = DepositDataDocument.Factory
					.parse(xmlReply);
			DepositData depositData = depositDataDocument.getDepositData();

			String producerId = depositData.getDepDataArray(0).getId();
			System.out.println("Producer ID: " + producerId);

			//submit
			String retval = new DepositWebServices_Service(new URL(DEPOSIT_WSDL_URL),new QName("http://dps.exlibris.com/", "DepositWebServices")).getDepositWebServicesPort().submitDepositActivity(pdsHandle,materialflowId, subDirectoryName, producerId, depositSetId);
			System.out.println("Submit Deposit Result: " + retval);

			DepositResultDocument depositResultDocument = DepositResultDocument.Factory.parse(retval);
			DepositResult depositResult = depositResultDocument.getDepositResult();

			// 6.check status of sip when deposit was successful
			for(int i=0;i<1;i++){
				Thread.sleep(3000);//wait until deposit is in
				if(depositResult.getIsError()){
					System.out.println("Submit Deposit Failed");
				}else{
					SipStatusInfo status = new SipWebServices_Service(new URL(SIP_STATUS_WSDL_URL),new QName("http://dps.exlibris.com/", "SipWebServices")).getSipWebServicesPort().getSIPStatusInfo(String.valueOf(depositResult.getSipId()));
					System.out.println("Submitted Deposit Status: " + status.getStatus());
					System.out.println("Submitted Deposit Stage: " + status.getStage());
					System.out.println("Submitted Deposit is in Module: " + status.getModule());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
