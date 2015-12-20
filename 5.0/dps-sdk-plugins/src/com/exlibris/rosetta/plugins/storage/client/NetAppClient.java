package com.exlibris.dps.repository.plugin.storage.netapp.client;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;

/**
 * <p>
 * Provides the client for NetApp storage connection.
 * </p>
 */
public class NetAppClient {
	private static final ExLogger log = ExLogger.getExLogger(NetAppClient.class);

	private String container_name = "";
	private String username = "";
	private String password = "";
	private String host = "";
	private int port = 80;
	private int ingestPort = 80;
	private String protocol = "http";


	public void setHost(String host) {
		this.host = host;
	}
	public String getHost() {
		return host;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setContainerName(String container_name) {
		this.container_name = container_name;
	}
	public String getContainerName() {
		return container_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getPort() {
		return port;
	}
	public int getIngestPort() {
		return ingestPort;
	}
	public void setIngestPort(int ingestPort) {
		this.ingestPort = ingestPort;
	}
}
