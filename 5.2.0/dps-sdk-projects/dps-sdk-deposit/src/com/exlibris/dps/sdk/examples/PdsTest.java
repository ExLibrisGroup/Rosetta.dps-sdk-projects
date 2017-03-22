package com.exlibris.dps.sdk.examples;

import com.exlibris.dps.sdk.pds.PdsClient;
import com.exlibris.dps.sdk.pds.PdsUserInfo;

public class PdsTest {

	public static void main(String[] args) {
		try {
			PdsClient pds = PdsClient.getInstance();
			pds.init("http://il-dtldev04:8992/pds",false);
			String pdsHandle =  pds.login("INS00", "admin1", "a12345678A");

			System.out.println("User authenticated (PDS_HANDLE=" + pdsHandle + ")");

			PdsUserInfo user = pds.getPdsUserByPdsHandle(pdsHandle);

			System.out.println("User name by PDS_HANDLE=" + user.getUserName());

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
