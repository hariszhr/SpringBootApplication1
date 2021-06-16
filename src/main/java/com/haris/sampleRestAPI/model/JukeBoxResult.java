package com.haris.sampleRestAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JukeBoxResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String Name;
	
	public JukeBoxResult() {
	}
	
	public JukeBoxResult(String name) {
		this.Name=name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getName() {
		return Name;
	}

}
