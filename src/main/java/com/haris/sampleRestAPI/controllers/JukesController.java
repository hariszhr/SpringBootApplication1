package com.haris.sampleRestAPI.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.haris.sampleRestAPI.dao.JukeBoxDataDAO;
import com.haris.sampleRestAPI.dao.SettingsDataDAO;
import com.haris.sampleRestAPI.dto.JukeBoxDTO;
import com.haris.sampleRestAPI.dto.SettingDTO;
import com.haris.sampleRestAPI.model.JukeBoxResult;
import com.haris.sampleRestAPI.service.JukeBoxResultsService;


@RestController
public class JukesController {
	
	@Autowired
	private JukeBoxDataDAO jukeBoxDataDAO;
	@Autowired
	private SettingsDataDAO settingsDataDAO;
	@Autowired
	private JukeBoxResultsService jukeBoxResultsService;
	
	
	
	@GetMapping("/jukeboxes")
	@ResponseBody
	public List<JukeBoxResult> getJukeBoxes(	@RequestParam(value = "settingId") String settingId, 
								@RequestParam(value = "model", defaultValue = "") String model,
								@RequestParam(value = "offset", defaultValue = "-1") int offset,
								@RequestParam(value = "limit", defaultValue = "-1") int limit) throws IOException {
		
		jukeBoxResultsService.deleteAll();
		
		List<JukeBoxDTO> jukeBoxDTOs =jukeBoxDataDAO.fetch();
		List<SettingDTO> settingDTOs =settingsDataDAO.fetch();
		
//		make list of components for specified 'settingId'
		List<String> requiredComponents = new ArrayList<String>();
		boolean settingFound=false;
		for(SettingDTO each : settingDTOs) {
			if(each.getId().equals(settingId)) {
				for(String comp: each.getComponents())
					requiredComponents.add(comp);
				settingFound=true;
				break;
			}
		}
		if(!settingFound)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "setting not found");
		
//		find jukeboxes which have components we collected in previous step
		List<JukeBoxResult> results = new ArrayList<JukeBoxResult>();
		for(JukeBoxDTO each : jukeBoxDTOs) {
			if(each.getComponents().containsAll(requiredComponents) && (model.isEmpty() || model.equals(each.getModel()))) {
				results.add(new JukeBoxResult(each.getId()));
			}
		}
		jukeBoxResultsService.save(results);
		
		if(offset > -1 && limit > -1) {
			return jukeBoxResultsService.findOffsetBasedPaginated(offset, limit);
		} else {
			return jukeBoxResultsService.findAll();
		}
	}

}
