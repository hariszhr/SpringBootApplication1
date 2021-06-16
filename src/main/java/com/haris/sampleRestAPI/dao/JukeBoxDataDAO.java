package com.haris.sampleRestAPI.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.haris.sampleRestAPI.configurations.JsonGeneratorConfig;
import com.haris.sampleRestAPI.dto.JukeBoxDTO;

@Controller
public class JukeBoxDataDAO {
	
	@Autowired
	private JsonGeneratorConfig jsonGeneratorConfig;
	@Autowired
	private NetworkDAO networkDAO;
	
	public List<JukeBoxDTO> fetch() throws IOException{
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "Bearer "+jsonGeneratorConfig.getToken());
		String rawString = networkDAO.request(jsonGeneratorConfig.getJukes(), headers);
		
		List<JukeBoxDTO> jukeboxes = new ArrayList<JukeBoxDTO>();
		JsonElement obj =  JsonParser.parseString(rawString);
		for(JsonElement e1: obj.getAsJsonArray()) {
			JukeBoxDTO jukeboxDto = new JukeBoxDTO();
			String Id= e1.getAsJsonObject().get("id").getAsString();
			String Model= e1.getAsJsonObject().get("model").getAsString();
			ArrayList<String> componentsList = new ArrayList<String>();
			for(JsonElement e2: e1.getAsJsonObject().get("components").getAsJsonArray()) {
				componentsList.add(e2.getAsJsonObject().get("name").getAsString());
			}
			jukeboxDto.setId(Id);
			jukeboxDto.setModel(Model);
			jukeboxDto.setComponents(componentsList);
			jukeboxes.add(jukeboxDto);
		}
		
		return jukeboxes;
	}
	
	

}
