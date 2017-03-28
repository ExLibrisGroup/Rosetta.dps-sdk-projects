package com.exlibris.dps.sdk.examples;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlException;

import com.exlibris.core.sdk.utils.FileUtil;
import com.exlibris.dps.ProducerWebServices;
import com.exlibris.dps.ProducerWebServices_Service;
import com.exlibris.dps.sdk.pds.PdsClient;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerAccountType;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerInfoDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerStatus;
import com.exlibrisgroup.xsd.dps.backoffice.service.ResponseDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.UserInfoDocument;
import com.exlibrisgroup.xsd.dps.backoffice.service.ProducerInfoDocument.ProducerInfo;
import com.exlibrisgroup.xsd.dps.backoffice.service.UserInfoDocument.UserInfo;


public class ProducerWSTest {

	static final String WSDL_URL = "http://localhost:1801/dpsws/backoffice/ProducerWebServices?wsdl";
	static final String PDS_URL = "http://il-dtldev04:8992/pds";

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

		ProducerWebServices services = null;
		try {
			services = new ProducerWebServices_Service(new URL(WSDL_URL),new QName("http://dps.exlibris.com/", "ProducerWebServices")).getProducerWebServicesPort();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		DPS4749(services,pdsHandle);
//		DPS4745(services,pdsHandle);
//		DPS4618(services,pdsHandle);
//		DPS4838(services,pdsHandle);
//		DPS4746(services,pdsHandle);
//		DPS4633(services,pdsHandle);
//		DPS4733(services,pdsHandle);
//		DPS5067(services,pdsHandle);
//		DPS4732(services,pdsHandle);
//		DPS4744(services,pdsHandle);
//		DPS4621(services,pdsHandle);
//		DPS4908(services,pdsHandle);

		//DPS5369(services,pdsHandle);
		//DPS5425(services,pdsHandle);
		//DPS5424(services,pdsHandle);
		//DPS5368(services,pdsHandle);
		//DPS5376(services,pdsHandle);

		//DPS5426(services,pdsHandle);
		//DPS5630(services,pdsHandle);
		//DPS4599(services,pdsHandle);
		DPS4731(services,pdsHandle);

	}

	/* DPS-4731
	LDNET - when inserting non valid date (from/to), java is convering the value to valid date
	 */
	public static void DPS4731(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument user =  getProducerAgent("inalidDateDay");
		user.getUserInfo().setExpiryDate("32/06/2011");
		System.out.println("DPS-4731 create producer agent with date 32/06/2011:\n"+services.createProducerAgent(pdsHandle, user.toString()));
	}

	/* DPS-4599
	Add option to logout from PDS in the SDK
	 */
	public static void DPS4599(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument user =  getProducerAgent("afterLogin");
		System.out.println("DPS-4599 create producer agent after login:\n"+services.createProducerAgent(pdsHandle, user.toString()));
		try {
			// Connecting to PDS
			PdsClient pds = PdsClient.getInstance();
			pds.init(PDS_URL,false);
			if (pds.logout(pdsHandle) == null) {
				System.out.println("After logout: return null");
			} else {
				System.out.println("After logout: function somehow does not return null");
			}
			user =  getProducerAgent("afterLogout");
			System.out.println("DPS-4599 create producer agent after logout:\n"+services.createProducerAgent(pdsHandle, user.toString()));

		} catch(Exception e){}
		try {
			// Connecting to PDS
			PdsClient pds = PdsClient.getInstance();
			pds.init(PDS_URL,false);
			pdsHandle =  pds.login("INS00", "admin1", "a12345678A");
		} catch(Exception e){}
		user =  getProducerAgent("afterLoginAgain");System.out.println("DPS-4599 create producer agent after login again:\n"+services.createProducerAgent(pdsHandle, user.toString()));

	}

	/* DPS-5630
	Add webservice to check if user exists
	 */
	public static void DPS5630(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument user =  getProducerAgent("kukusharo1");

		services.createProducerAgent(pdsHandle, user.toString());

		System.out.println("DPS-5630 admin1 exists:\n"+services.isUserExists(pdsHandle,"admin1"));
		System.out.println("DPS-5630 kukusharo1 exists:\n"+services.isUserExists(pdsHandle,"kukusharo1"));
		System.out.println("DPS-5630 kukusharo2 not exists:\n"+services.isUserExists(pdsHandle,"kukusharo2"));
		System.out.println("DPS-5630 mandatory error:\n"+services.isUserExists(pdsHandle,null));

	}

	/* DPS-5426
	Producer notes doesn't reflect on DPS UI
	 */
	public static void DPS5426(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producer1 =  getProducer(ProducerAccountType.GROUP);
		ProducerInfoDocument producer2 =  getProducer(ProducerAccountType.INDIVIDUAL);

		String res1 = services.createProducer(pdsHandle, producer1.toString());
		String res2 = services.createProducer(pdsHandle, producer2.toString());
		try {
			ResponseDocument response1 = ResponseDocument.Factory.parse(res1);
			ResponseDocument response2 = ResponseDocument.Factory.parse(res2);

			System.out.println("DPS-5426:\n"+services.getProducerDetails(pdsHandle, String.valueOf(response1.getResponse().getId())));
			System.out.println("DPS-5426:\n"+services.getProducerDetails(pdsHandle, String.valueOf(response2.getResponse().getId())));
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	/* DPS-5376
		assigning fax for producer
	*/
	public static void DPS5376(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producer1 =  getProducer(ProducerAccountType.GROUP);
		ProducerInfoDocument producer2 =  getProducer(ProducerAccountType.INDIVIDUAL);
		System.out.println("DPS-5376 for bean:\n"+services.createProducer(pdsHandle, producer1.toString()));
		System.out.println("DPS-5376 for bean:\n"+services.createProducer(pdsHandle, producer2.toString()));

		String producerXml = FileUtil.getFileContent("demoXml/producer_details.xml");
		System.out.println("DPS-5376 for xml:\n"+services.createProducer(pdsHandle, producerXml));

	}

	/* DPS-5368
		Producer and Producer Agent Expiry Date should not be mandatory
	*/
	public static void DPS5368(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producer1 =  getProducer(ProducerAccountType.GROUP);
		ProducerInfoDocument producer2 =  getProducer(ProducerAccountType.INDIVIDUAL);
		UserInfoDocument user =  getProducerAgent();
		producer1.getProducerInfo().setExpiryDate(null);
		producer2.getProducerInfo().setExpiryDate(null);
		user.getUserInfo().setExpiryDate(null);
		System.out.println("DPS-5368 producer for bean:\n"+services.createProducer(pdsHandle, producer1.toString()));
		System.out.println("DPS-5368 producer for bean:\n"+services.createProducer(pdsHandle, producer2.toString()));
		System.out.println("DPS-5368 agent for bean:\n"+services.createProducerAgent(pdsHandle, user.toString()));

		String producerXml = FileUtil.getFileContent("demoXml/producer_details_no_expiry.xml");
		System.out.println("DPS-5368 producer for xml:\n"+services.createProducer(pdsHandle, producerXml));
		String producerAgentXml = FileUtil.getFileContent("demoXml/producer_agent_details_no_expiry.xml");
		System.out.println("DPS-5368 agent for xml:\n"+services.createProducerAgent(pdsHandle, producerAgentXml));
	}

	/* DPS-5424
		Postal code doesn't reflect on DPS UI
	 */
	public static void DPS5424(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument user =  getProducerAgent();
		System.out.println("DPS-5424 for bean:\n"+services.createProducerAgent(pdsHandle, user.toString()));

		String producerAgentXml = FileUtil.getFileContent("demoXml/producer_agent_details.xml");
		System.out.println("DPS-5424 for xml:\n"+services.createProducerAgent(pdsHandle, producerAgentXml));

		ProducerInfoDocument producer =  getProducer(ProducerAccountType.GROUP);
		System.out.println("DPS-5368 producer for bean:\n"+services.createProducer(pdsHandle, producer.toString()));

		String producerXml = FileUtil.getFileContent("demoXml/producer_details.xml");
		System.out.println("DPS-5368 for xml:\n"+services.createProducer(pdsHandle, producerXml));

	}

	/* DPS-5369 - zip is mandatory */
	public static void DPS5369(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument user =  getProducerAgent(false);
		System.out.println("DPS-5369 for bean:\n"+services.createProducerAgent(pdsHandle, user.toString()));

		String producerAgentXml = FileUtil.getFileContent("demoXml/producer_agent_no_zip.xml");
		System.out.println("DPS-5369: for xml\n"+services.createProducerAgent(pdsHandle, producerAgentXml));
	}

	/* DPS-5425
		'Send email' has set to 'Y' on LDNet but DPS UI shows 'Send report' as '-'
	 */
	public static void DPS5425(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producer =  getProducer(ProducerAccountType.GROUP);
		producer.getProducerInfo().setEmailNotify("Y");
		String producerCreated = services.createProducer(pdsHandle, producer.toString());
		System.out.println("DPS-5425 for bean:\n"+producerCreated);

		producer =  getProducer(ProducerAccountType.GROUP);
		producer.getProducerInfo().setEmailNotify("N");
		producerCreated = services.createProducer(pdsHandle, producer.toString());
		System.out.println("DPS-5425 for bean with N:\n"+producerCreated);

		producer =  getProducer(ProducerAccountType.GROUP);
		producer.getProducerInfo().setEmailNotify(null);
		producerCreated = services.createProducer(pdsHandle, producer.toString());
		System.out.println("DPS-5425 for bean with null:\n"+producerCreated);

		String producerXml = FileUtil.getFileContent("demoXml/producer_details.xml");
		System.out.println("DPS-5425 for xml:\n"+services.createProducer(pdsHandle, producerXml));

		ResponseDocument reponse;
		try {
			reponse = ResponseDocument.Factory.parse(producerCreated);
			System.out.println("DPS-5425 get producer created:\n"+services.getProducerDetails(pdsHandle, String.valueOf(reponse.getResponse().getId())));

		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DPS-5425 get Demo producer:\n"+services.getProducerDetails(pdsHandle, "10000"));

	}

	/* DPS-4908 - pdshandle null */
	public static void DPS4908(ProducerWebServices services, String pdsHandle) {
		System.out.println("DPS-4908:\n"+services.createContact(null, getContact().toString()));
		System.out.println("DPS-4908:\n"+services.createProducerAgent(null, getProducerAgent().toString()));
		System.out.println("DPS-4908:\n"+services.createProducer(null, getProducer(ProducerAccountType.INDIVIDUAL).toString()));
		System.out.println("DPS-4908:\n"+services.createProducer(null, getProducer(ProducerAccountType.GROUP).toString()));

		System.out.println("DPS-4908:\n"+services.updateContact(null, "10",getContact().toString()));
		System.out.println("DPS-4908:\n"+services.updateProducerAgent(null, "10",getProducerAgent().toString()));
		System.out.println("DPS-4908:\n"+services.updateProducer(null, "10",getProducer(ProducerAccountType.INDIVIDUAL).toString()));
		System.out.println("DPS-4908:\n"+services.updateProducer(null, "10",getProducer(ProducerAccountType.GROUP).toString()));

		System.out.println("DPS-4908:\n"+services.removeContact(null, "10"));
		System.out.println("DPS-4908:\n"+services.removeProducerAgent(null, "10"));
		System.out.println("DPS-4908:\n"+services.removeProducer(null, "10"));

		System.out.println("DPS-4908:\n"+services.linkContactToProdcuer(null, "10", "10","false"));
		System.out.println("DPS-4908:\n"+services.linkProducerAgentToProdcuer(null, "10", "10"));
		System.out.println("DPS-4908:\n"+services.unLinkContactFromProdcuer(null, "10", "10"));
		System.out.println("DPS-4908:\n"+services.unLinkProducerAgentFromProdcuer(null, "10", "10"));

		/* email check */
		String emailUpdate1 = services.getProducerAgent(pdsHandle,"34192");
		String emailUpdate2 = services.getContact(pdsHandle,"34188");

		System.out.println("email check:\n"+services.updateProducerAgent(pdsHandle, "34192", emailUpdate1));
		System.out.println("email check:\n"+services.updateContact(pdsHandle, "34188", emailUpdate2));

	}

	/* DPS-4744
	 * test create individual producer with multi same contact id */
	public static void DPS4744(ProducerWebServices services, String pdsHandle) {
		String producerXml4744 = FileUtil.getFileContent("demoXml/producer_group_details_multi_contacts.xml");
		System.out.println("DPS-4744:\n"+services.createProducer(pdsHandle, producerXml4744));
	}

	/* DPS-4621 */
	public static void DPS4621(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument agentDoc4621 = getProducerAgent();
		agentDoc4621.getUserInfo().setFirstName(null);
		agentDoc4621.getUserInfo().setLastName(null);
		System.out.println("DPS-4621:\n"+services.createProducerAgent(pdsHandle,agentDoc4621.toString()));
	}

	/* DPS-4732 */
	public static void DPS4732(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument contactDoc7 = getContact();
		String res7 = services.createContact(pdsHandle,contactDoc7.toString());

		try {
			ResponseDocument response7 = ResponseDocument.Factory.parse(res7);
			System.out.println("DPS-4732:\n"+services.linkContactToProdcuer(pdsHandle, "10000", String.valueOf(response7.getResponse().getId()),"false"));
			System.out.println("DPS-4732:\n"+services.linkContactToProdcuer(pdsHandle, "10000", String.valueOf(response7.getResponse().getId()),"false"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* DPS-5067 */
	public static void DPS5067(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producerDoc = getProducer(ProducerAccountType.GROUP);
		String producerXml5067 = services.createProducer(pdsHandle, producerDoc.toString());
		System.out.println("DPS-5067\n"+producerXml5067);
		ResponseDocument reponse;
		try {
			reponse = ResponseDocument.Factory.parse(producerXml5067);
			producerXml5067 = services.updateProducer(pdsHandle, String.valueOf(reponse.getResponse().getId()), producerDoc.toString());
			System.out.println(producerXml5067);

		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* DPS-4749
	 * test create individual producer with null contact id */
	public static void DPS4749(ProducerWebServices services, String pdsHandle) {
		String producerXml = FileUtil.getFileContent("demoXml/producer_individual_details.xml");
		System.out.println("DPS-4749:\n"+services.createProducer(pdsHandle, producerXml));
	}

	/* DPS-4745
	 * test create contact - userName is not mandatory */
	public static void DPS4745(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument contactDoc = getContact();
		System.out.println("DPS-4745:\n"+services.createContact(pdsHandle,contactDoc.toString()));

		UserInfoDocument contactDoc2 = getContact();
		String contact2Xml = services.createContact(pdsHandle,contactDoc2.toString());
		ResponseDocument res2;
		try {

			res2 = ResponseDocument.Factory.parse(contact2Xml);
			services.linkContactToProdcuer(pdsHandle, "10000", String.valueOf(res2.getResponse().getId()), "false");
			services.removeContact(pdsHandle, String.valueOf(res2.getResponse().getId()));
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		services.removeContact(pdsHandle,"38270");
	}

	/* DPS-4618
	 * create contact with missing email
	 * create contact with corrupted  email and corrupted phone
	 * create producer agent with missing email
	 * create producer agent with corrupted  email and corrupted phone
	 * */
	public static void DPS4618(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument contactDoc3 = getContact();
		UserInfoDocument agentDoc3 = getProducerAgent();
		contactDoc3.getUserInfo().setStreet(null);
		agentDoc3.getUserInfo().setStreet(null);
		System.out.println("DPS-4618:\n"+services.createContact(pdsHandle,contactDoc3.toString()));
		System.out.println("DPS-4618:\n"+services.createProducerAgent(pdsHandle,agentDoc3.toString()));
		contactDoc3.getUserInfo().setEmailAddress("invalid email");
		agentDoc3.getUserInfo().setEmailAddress("invalid email");
		contactDoc3.getUserInfo().setTelephone1("invalid phone");
		agentDoc3.getUserInfo().setTelephone1("invalid phone");
		System.out.println("DPS-4618:\n"+services.createContact(pdsHandle,contactDoc3.toString()));
		System.out.println("DPS-4618:\n"+services.createProducerAgent(pdsHandle,agentDoc3.toString()));
	}

	/* DPS-4838
	 * Individual producer can get PA on creation or by staff mediate and not by adding manuyally PA.
	 * Should be implement also in SDK link/create PA should return error for Individual producer.
	 */
	public static void DPS4838(ProducerWebServices services, String pdsHandle) {
		ProducerInfoDocument producerDoc = getProducer(ProducerAccountType.INDIVIDUAL);
		String producerXml4838 = services.createProducer(pdsHandle, producerDoc.toString());
		System.out.println(producerXml4838);
		ResponseDocument res4;
		try {
			res4 = ResponseDocument.Factory.parse(producerXml4838);
			System.out.println("DPS-4838:\n"+services.linkProducerAgentToProdcuer(pdsHandle,String.valueOf(res4.getResponse().getId()), "100")); //try to link admin1 to it

		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* DPS-4746
	 * it is possible to unlink the main PA from producer individual
	 */
	public static void DPS4746(ProducerWebServices services, String pdsHandle) {
		System.out.println("DPS-4746:\n"+services.unLinkProducerAgentFromProdcuer(pdsHandle,"34586","34583"));
	}

	/* DPS-4633 */
	public static void DPS4633(ProducerWebServices services, String pdsHandle) {
		services.removeContact(pdsHandle, "34684");
	}

	/* DPS-4733 */
	public static void DPS4733(ProducerWebServices services, String pdsHandle) {
		UserInfoDocument contactDoc5 = getContact();
		UserInfoDocument contactDoc6 = getContact();
		services.createContact(pdsHandle,contactDoc5.toString());
		String res5 = services.createContact(pdsHandle,contactDoc5.toString());
		String res6 = services.createContact(pdsHandle,contactDoc6.toString());
		try {
			ResponseDocument response5 = ResponseDocument.Factory.parse(res5);
			ResponseDocument response6 = ResponseDocument.Factory.parse(res6);
			services.linkContactToProdcuer(pdsHandle, "10000", String.valueOf(response5.getResponse().getId()),"false");
			services.linkContactToProdcuer(pdsHandle, "10000", String.valueOf(response6.getResponse().getId()),"false");
			System.out.println("DPS-4733:\n"+services.unLinkContactFromProdcuer(pdsHandle, "10000", String.valueOf(response6.getResponse().getId())));
			System.out.println("DPS-4733:\n"+services.unLinkContactFromProdcuer(pdsHandle, "10000", String.valueOf(response6.getResponse().getId())));

		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ProducerInfoDocument getProducer(ProducerAccountType.Enum type) {
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
		producerInfo.setFirstName("producer first name");
		producerInfo.setLastName("producer last name");
		producerInfo.setUserName("producer user name"+ Math.random()*3);
		producerInfo.setAccountType(type);
		producerInfo.setEmailNotify("Y");
		producerInfo.setNotes("my notes here");
		producerInfo.setLocalField1("");
		producerInfo.setFax("999999999999");
		//producerInfo.setNegotiatorId(Long.valueOf("68745"));
		//producerInfo.setContactUserId2(Long.valueOf("0"));
		//producerInfo.setContactUserId3(Long.valueOf("0"));
		//producerInfo.setContactUserId4(Long.valueOf("0"));
		//producerInfo.setContactUserId5(Long.valueOf("0"));
		producerInfo.setProducerProfileId(1L);
		return producerDoc;

	}

	public static UserInfoDocument getContact() {
		UserInfoDocument contactDoc = UserInfoDocument.Factory.newInstance();
		UserInfo contactInfo = contactDoc.addNewUserInfo();
		contactInfo.setFirstName("Jhon");
		contactInfo.setLastName("Smith");
		//contactInfo.setUserName("jhonS"); userName is not mandatory
		contactInfo.setExpiryDate("08/02/2010");
		contactInfo.setJobTitle("BA");
		contactInfo.setStreet("Lakewood");
		contactInfo.setSuburb("");
		contactInfo.setCity("Junglao");
		contactInfo.setCountry("China");
		contactInfo.setZip(Long.valueOf("123456"));
		//contactInfo.setWebSiteUrl("www.ynet.co.il");
		contactInfo.setEmailAddress("tomery@exlibris.co.il");
		contactInfo.setTelephone1("587-56-19876201");
		contactInfo.setTelephone2("");
		//contactInfo.setUserGruop("");
		return contactDoc;
	}

	public static UserInfoDocument getProducerAgent() {
		return getProducerAgent(null);
	}

	public static UserInfoDocument getProducerAgent(String userName) {
		UserInfoDocument producerAgentDoc = UserInfoDocument.Factory.newInstance();
		UserInfo producerAgentInfo = producerAgentDoc.addNewUserInfo();
		producerAgentInfo.setFirstName("Nir");
		producerAgentInfo.setLastName("Kashi");
		if (userName!=null)
			producerAgentInfo.setUserName(userName);
		else
			producerAgentInfo.setUserName("nirk" + Math.random()*3);
		producerAgentInfo.setExpiryDate("08/02/2010");
		producerAgentInfo.setJobTitle("BA");
		producerAgentInfo.setStreet("Keren Hayesod 16");
		producerAgentInfo.setSuburb(null);
		producerAgentInfo.setCity("Jerusalem");
		producerAgentInfo.setCountry("Israel");
		producerAgentInfo.setAddress5(null);
		producerAgentInfo.setZip(123L);
		producerAgentInfo.setEmailAddress("tomery@exlibris.co.il");
		producerAgentInfo.setWebSiteUrl(null);
		producerAgentInfo.setTelephone1("123456");
		producerAgentInfo.setTelephone2(null);
		//producerAgentInfo.setUserGruop(null);
		return producerAgentDoc;
	}

	public static UserInfoDocument getProducerAgent(boolean withZip) {
		UserInfoDocument producerAgentDoc = UserInfoDocument.Factory.newInstance();
		UserInfo producerAgentInfo = producerAgentDoc.addNewUserInfo();
		producerAgentInfo.setFirstName("Nir");
		producerAgentInfo.setLastName("Kashi");
		producerAgentInfo.setUserName("nirk" + Math.round(Math.random()*3));
		producerAgentInfo.setExpiryDate("08/02/2010");
		producerAgentInfo.setJobTitle("BA");
		producerAgentInfo.setStreet("Keren Hayesod 16");
		producerAgentInfo.setSuburb(null);
		producerAgentInfo.setCity("Jerusalem");
		producerAgentInfo.setCountry("Israel");
		producerAgentInfo.setAddress5(null);
		if (withZip)
			producerAgentInfo.setZip(123L);
		producerAgentInfo.setEmailAddress("tomery@exlibris.co.il");
		producerAgentInfo.setWebSiteUrl(null);
		producerAgentInfo.setTelephone1("123456");
		producerAgentInfo.setTelephone2(null);
		//producerAgentInfo.setUserGruop(null);
		return producerAgentDoc;
	}
}
