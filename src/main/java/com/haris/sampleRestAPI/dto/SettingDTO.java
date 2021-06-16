package com.haris.sampleRestAPI.dto;

import java.util.List;

public class SettingDTO {
	
	private String Id;
	private List<String> Components;
	
	public void setComponents(List<String> components) {
		this.Components = components;
	}
	
	public void setId(String id) {
		this.Id = id;
	}
	
	public List<String> getComponents() {
		return Components;
	}
	
	public String getId() {
		return Id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Id);
		return sb.toString();
	}

}
