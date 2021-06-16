package com.haris.sampleRestAPI.dto;

import java.util.List;

public class JukeBoxDTO {
	
	private String Id;
	private String Model;
	private List<String> Components;
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	
	public String getModel() {
		return Model;
	}
	
	public void setModel(String model) {
		Model = model;
	}
	
	public List<String> getComponents() {
		return Components;
	}
	
	public void setComponents(List<String> components) {
		Components = components;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Id).append(" - ").append(Model);
		return sb.toString();
	}

}
