package com.lrs.springboot.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

// @ConfigurationProperties(ignoreUnknownFields = false, prefix = "mail")
// @PropertySource("classpath:config/email.properties")
public class MailProperties {
	private String host;
	private int port;
	private String from;
	private String username;
	private String password;
	private String protocol;
	private Smtp smtp = new Smtp();

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
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

	public Smtp getSmtp() {
		return smtp;
	}

	public void setSmtp(Smtp smtp) {
		this.smtp = smtp;
	}

	public static class Smtp {
		private String auth;
		private String starttlsEnable;

		public String getAuth() {
			return auth;
		}

		public void setAuth(String auth) {
			this.auth = auth;
		}

		public String getStarttlsEnable() {
			return starttlsEnable;
		}

		public void setStarttlsEnable(String starttlsEnable) {
			this.starttlsEnable = starttlsEnable;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
