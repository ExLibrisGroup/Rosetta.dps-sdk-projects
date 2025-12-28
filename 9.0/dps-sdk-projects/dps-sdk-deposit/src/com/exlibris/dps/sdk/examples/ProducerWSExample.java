package com.exlibris.dps.sdk.examples;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlException;

import com.exlibris.dps.ProducerWebServices;
import com.exlibris.dps.ProducerWebServices_Service;
import com.exlibris.dps.sdk.pds.HeaderHandlerResolver;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerAccountType;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerInfoDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerStatus;
import com.exlibrisgroup.xsd.dps.backoffice.service.ResponseDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.UserInfoDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerInfoDocument.ProducerInfo;
import com.exlibrisgroup.xsd.dps.backoffice.service.UserInfoDocument.UserInfo;


public class ProducerWSExample {

	static final String WSDL_URL = "http://localhost:1801/dpsws/backoffice/ProducerWebServices?wsdl";
	
	public static void main(String[] args) {

		ResponseDocument contactResponseDoc = null;
		ResponseDocument producerResponseDoc = null;
		ResponseDocument producerAgentResponseDoc = null;

		String userName = "admin1";
		String password = "a12345678A";
		String institution = "INS00";

		//If rosetta_ws_demo_mode is true a client side demo implementation is used ,otherwise the Server Web Service implementation is used
		ProducerWebServices services = null;
		try {
			ProducerWebServices_Service proWS = new ProducerWebServices_Service(new URL(WSDL_URL),new QName("http://dps.exlibris.com/", "ProducerWebServices"));
			proWS.setHandlerResolver(new HeaderHandlerResolver(userName, password, institution));
			services = proWS.getProducerWebServicesPort();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Long contactId = 0L ,producerAgentId = 0L, producerId = 0L;

		/*********************************************************
		 * Create Group producer with a contact	and Agent        *
		 * 1. Prepare Producer info								 *
		 * 2. Prepare Contact info								 *
		 * 3. Create Contact									 *
		 * 4. Create Producer with contact						 *
		 * 5. Prepare Producer Agent							 *
		 * 6. Create Producer Agent 							 *
		 * 7. Link Producer Agent to the Producer created		 *
		 * 8. Get Producer
		 *********************************************************/

		/*
		 * 1. Prepare Producer info
		 */
		ProducerInfoDocument producerDoc = ProducerInfoDocument.Factory.newInstance();
		ProducerInfo producerInfo =  producerDoc.addNewProducerInfo();
		producerInfo.setStatus(ProducerStatus.ACTIVE);
		producerInfo.setExpiryDate("08/02/2010");
		producerInfo.setTelephone1("1800-888-999");
		producerInfo.setTelephone2("");
		producerInfo.setWebSite("");
		producerInfo.setZipCode(Long.valueOf("68745"));
		producerInfo.setEmail("mail@info.org");
		producerInfo.setInstitution("my institution");
		producerInfo.setDepartment("my department");
		producerInfo.setStreet("Emek Hachula 13");
		producerInfo.setSuburb("");
		producerInfo.setCity("Michil");
		producerInfo.setCountry("Israel");
		producerInfo.setAuthoritativeName("Meat and Wool");
		producerInfo.setAccountType(ProducerAccountType.GROUP);
		producerInfo.setEmailNotify("Y");
		producerInfo.setNotes("");
		producerInfo.setLocalField1("");
		producerInfo.setFax("");
		producerInfo.setNegotiatorId(Long.valueOf("68745"));
		producerInfo.setContactUserId2(Long.valueOf("0"));
		producerInfo.setContactUserId3(Long.valueOf("0"));
		producerInfo.setContactUserId4(Long.valueOf("0"));
		producerInfo.setContactUserId5(Long.valueOf("0"));
		producerInfo.setProducerProfileId(1L);


		/*
		 * 2. Prepare Contact info
		 */
		UserInfoDocument contactDoc = UserInfoDocument.Factory.newInstance();
		UserInfo contactInfo = contactDoc.addNewUserInfo();
		contactInfo.setFirstName("Jhon");
		contactInfo.setLastName("Smith");
		contactInfo.setUserName("jhonS");
		contactInfo.setExpiryDate("08/02/2010");
		contactInfo.setJobTitle("BA");
		contactInfo.setStreet("Lakewood");
		contactInfo.setSuburb("");
		contactInfo.setCity("Junglao");
		contactInfo.setCountry("China");
		contactInfo.setZip(Long.valueOf("0"));
		contactInfo.setWebSiteUrl("http://ynet.co.il");
		contactInfo.setEmailAddress("nirk@exlibris.co.il");
		contactInfo.setTelephone1("587-56-19876201");
		contactInfo.setTelephone2("");
		//contactInfo.setUserGruop("");

		/*
		 * 3. Create Contact
		 */
		String contactCreationReply;
		try {
			//Create Contact
			contactCreationReply = services.createContact(null,contactDoc.toString());
			System.out.println("**** example - create contact Reply ****:\n");
			System.out.println(contactCreationReply + "\n");
			contactResponseDoc = ResponseDocument.Factory.parse(contactCreationReply);
			contactId = contactResponseDoc.getResponse().getId();
		}catch (XmlException e) {
			System.out.println(e.getMessage()); //for debug
		}

		/*
		 * 4. Create Producer with contact
		 */
		String producerCreationReply;
		try {
			producerInfo.setContactUserId1(contactId);
			producerCreationReply = services.createProducer(null, producerDoc.toString());
			System.out.println("**** example - create producer ****:\n");
			System.out.println(producerCreationReply + "\n");
			producerResponseDoc = ResponseDocument.Factory.parse(producerCreationReply);
			producerId = producerResponseDoc.getResponse().getId();
		} catch (XmlException e) {
			System.out.println(e.getMessage()); //for debug
		}


		/*
		 * 5. Prepare Producer Agent
		 */

			UserInfoDocument producerAgentDoc = UserInfoDocument.Factory.newInstance();
			UserInfo producerAgentInfo = producerAgentDoc.addNewUserInfo();
			producerAgentInfo.setFirstName("Nir");
			producerAgentInfo.setLastName("Kashi");
			producerAgentInfo.setUserName("nirk");
			producerAgentInfo.setExpiryDate("08/02/2010");
			producerAgentInfo.setJobTitle("BA");
			producerAgentInfo.setStreet("Keren Hayesod 16");
			producerAgentInfo.setSuburb(null);
			producerAgentInfo.setCity("Jerusalem");
			producerAgentInfo.setCountry("Israel");
			producerAgentInfo.setAddress5(null);
			producerAgentInfo.setZip(123L);
			producerAgentInfo.setEmailAddress("nirk@exlibris.co.il");
			producerAgentInfo.setWebSiteUrl(null);
			producerAgentInfo.setTelephone1("123456");
			producerAgentInfo.setTelephone2(null);
			//producerAgentInfo.setUserGruop(null);

		/*
		* 6. Create Producer Agent
		*/
			String producerAgentCreationReply;
			try {
				producerAgentCreationReply = services.createProducerAgent(null, producerAgentDoc.toString());
				System.out.println("**** example - create producer agent ****:\n");
				System.out.println(producerAgentCreationReply + "\n");
				producerAgentResponseDoc = ResponseDocument.Factory.parse(producerAgentCreationReply);
				producerAgentId = producerAgentResponseDoc.getResponse().getId();
			} catch (XmlException e) {
				System.out.println(e.getMessage()); //for debug
			}


		/*
		 * 7. Link Producer Agent to the Producer created
		 */
			String linkProducerAgentReply;
			linkProducerAgentReply = services.linkProducerAgentToProdcuer(null, producerId.toString(),  producerAgentId.toString());
			System.out.println("**** example - link producer agent to producer ****:\n");
			System.out.println(linkProducerAgentReply + "\n");

		/*
		 * 8. Get Producer
		 */
			String getProducerReply = services.getProducerDetails(null, String.valueOf(producerId));
			System.out.println("**** example - get producer ****:\n");
			System.out.println(getProducerReply + "\n");
	}

}
