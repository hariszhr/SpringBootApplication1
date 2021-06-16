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
import com.haris.sampleRestAPI.dto.SettingDTO;

@Controller
public class SettingsDataDAO {
	
	@Autowired
	private JsonGeneratorConfig jsonGeneratorConfig;
	@Autowired
	private NetworkDAO networkDAO;
	
	public List<SettingDTO> fetch() throws IOException{
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "Bearer "+jsonGeneratorConfig.getToken());
		String rawString = networkDAO.request(jsonGeneratorConfig.getSettings(), headers);
		
		List<SettingDTO> settings = new ArrayList<SettingDTO>();
		JsonElement obj =  JsonParser.parseString(rawString);
		for(JsonElement e1: obj.getAsJsonArray()) {
			SettingDTO settingDto = new SettingDTO();
			String id= e1.getAsJsonObject().get("name").getAsString();
			ArrayList<String> requiresList = new ArrayList<String>();
			for(JsonElement e2: e1.getAsJsonObject().get("requires").getAsJsonArray()) {
				requiresList.add(e2.getAsString());
			}
			settingDto.setId(id);
			settingDto.setComponents(requiresList);
			settings.add(settingDto);
		}
		return settings;
	}

}
