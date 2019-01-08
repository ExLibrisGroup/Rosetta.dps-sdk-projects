package com.exlibris.dps.sdk.examples;

import gov.loc.mets.FileType;
import gov.loc.mets.MetsType.FileSec.FileGrp;

import java.io.File;

import com.exlibris.core.sdk.consts.Enum;
import com.exlibris.core.sdk.formatting.DublinCore;
import com.exlibris.core.sdk.utils.FileUtil;
import com.exlibris.digitool.common.dnx.DnxDocument;
import com.exlibris.digitool.common.dnx.DnxDocumentHelper;
import com.exlibris.dps.sdk.deposit.IEParser;
import com.exlibris.dps.sdk.deposit.IEParserFactory;


public class IECreationTest {

		//should be placed under where submissionformat of MF is configured
		static final String folder_on_unix_machine = "../dps-sdk-deposit/data/depositExamples";

		public static void main(String[] args) {

			org.apache.log4j.helpers.LogLog.setQuietMode(true);

			try {
			String rootDir = null;
			if ((args != null) && (args.length > 0) &&
				(args[0] != null) && (args[0].trim().length() > 0)){
				rootDir = args[0];
			}else{
				rootDir =folder_on_unix_machine;
			}
			String filesRootFolder = rootDir + "/DepositExample1/content/streams/";
			String fileName = "Sunset.jpg";
			String IEfullFileName = rootDir + "/DepositExample1/content/ie1.xml";

			//file we are depositing
			File file = new File(filesRootFolder + fileName);

			//create parser
			IEParser ie = IEParserFactory.create();

			// add ie dc
			DublinCore dc = ie.getDublinCoreParser();
			dc.addElement("dc:creator", "Exlibris");
			dc.addElement("dc:identifier", "ISBN 1-56389-016-X");
			dc.addElement("dc:title", "SDK -TEST DC");
			ie.setIEDublinCore(dc);

			// add fileGrp
			FileGrp fGrp = ie.addNewFileGrp(Enum.UsageType.VIEW, Enum.PreservationType.PRESERVATION_MASTER);

			// add dnx - A new DNX is constructed and added on the file group level
			DnxDocument dnxDocument = ie.getFileGrpDnx(fGrp.getID());
			DnxDocumentHelper documentHelper = new DnxDocumentHelper(dnxDocument);
			documentHelper.getGeneralRepCharacteristics().setRevisionNumber("1");
			documentHelper.getGeneralRepCharacteristics().setLabel("test");
			ie.setFileGrpDnx(documentHelper.getDocument(), fGrp.getID());

            //add file and dnx metadata on file
            String mimeType = "image/jpeg";
            FileType fileType = ie.addNewFile(fGrp, mimeType, file.getName(), "test file");

            // add dnx - A new DNX is constructed and added on the file level
            DnxDocument dnx = ie.getFileDnx(fileType.getID());
            DnxDocumentHelper fileDocumentHelper = new DnxDocumentHelper(dnx);
            fileDocumentHelper.getGeneralFileCharacteristics().setNote("note to test");
            fileDocumentHelper.getGeneralFileCharacteristics().setLabel("test");
            fileDocumentHelper.getGeneralFileCharacteristics().setFileOriginalPath(file.getAbsolutePath());
            ie.setFileDnx(fileDocumentHelper.getDocument(), fileType.getID());

            ie.generateChecksum(filesRootFolder, Enum.FixityType.MD5.toString());
            ie.updateSize(filesRootFolder);
            ie.generateStructMap(null,null, "Table of Contents");

            //put IE created in content directory
            File ieXML = new File(IEfullFileName);
            FileUtil.writeFile(ieXML, ie.toXML());

			// print the ie
			System.out.println(ie.toXML());

			} catch (Exception e) {
				e.printStackTrace(System.out);
			}

	}

}
