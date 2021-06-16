package com.haris.sampleRestAPI.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "json.generator")
public class JsonGeneratorConfig {
	private String token;
	private String jukes;
	private String settings;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getJukes() {
		return jukes;
	}
	public void setJukes(String jukes) {
		this.jukes = jukes;
	}
	public String getSettings() {
		return settings;
	}
	public void setSettings(String settings) {
		this.settings = settings;
	}
	
	
	

}
