package com.exlibris.dps.repository.plugin.storage.netapp.client;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class CustomX509TrustManager implements X509TrustManager {
	public void checkClientTrusted(X509Certificate[] xcs, String string)
			throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] xcs, String string)
			throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}