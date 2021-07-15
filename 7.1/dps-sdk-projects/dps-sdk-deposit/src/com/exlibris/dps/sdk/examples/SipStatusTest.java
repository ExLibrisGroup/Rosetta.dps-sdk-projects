package com.exlibris.dps.sdk.examples;

import java.net.URL;

import javax.xml.namespace.QName;

import com.exlibris.dps.SipStatusInfo;
import com.exlibris.dps.SipWebServices_Service;

public class SipStatusTest {

	public static void main(String[] args) throws Exception {
		URL swsdlUrl = new URL("http://localhost:1801/dpsws/repository/SipWebServices?wsdl");
		SipStatusInfo sipStatus = new SipWebServices_Service(swsdlUrl,new QName("http://dps.exlibris.com/", "SipWebServices")).getSipWebServicesPort().getSIPStatusInfo("3", true);
		System.out.println(sipStatus.getStatus());
		System.out.println(sipStatus.getModule());
		System.out.println(sipStatus.getStage());
		System.out.println(sipStatus.getNumberOfIEs());


	}
}
