package com.haris.sampleRestAPI.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.haris.sampleRestAPI.model.JukeBoxResult;
import com.haris.sampleRestAPI.repository.JukeBoxResultsRepository;

@Service
public class JukeBoxResultsService {
	
	
	@Autowired
	private JukeBoxResultsRepository jukeBoxResultsRepository;
	
	
	public JukeBoxResultsService(JukeBoxResultsRepository jukeBoxResultsRepository) {
		this.jukeBoxResultsRepository = jukeBoxResultsRepository;
	}
	
	public void deleteAll(){
		jukeBoxResultsRepository.deleteAll();
	}
	
	
	public List<JukeBoxResult> findAll(){
		List<JukeBoxResult> result = new ArrayList<JukeBoxResult>();
		Iterable<JukeBoxResult> iterable =jukeBoxResultsRepository.findAll();
		Iterator<JukeBoxResult> it= iterable.iterator();
		while(it.hasNext()) {
			result.add(it.next());
		}
		return result;
	}
	
	public List<JukeBoxResult> findPaginated(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return jukeBoxResultsRepository.findAll(pageable).toList();
	}
	
	public List<JukeBoxResult> findOffsetBasedPaginated(int offset, int size){
		List<JukeBoxResult> result = findAll();
		if(size>result.size()-offset) size=result.size()-offset;
		return result.subList(offset, (size+offset));
	}
	
	public JukeBoxResult save(JukeBoxResult jukeBoxResult) {
		return jukeBoxResultsRepository.save(jukeBoxResult);
	}
	
	public Iterable<JukeBoxResult> save(List<JukeBoxResult> jukeBoxResults) {
		return jukeBoxResultsRepository.saveAll(jukeBoxResults);
		
	}
	
	
	
	
	
}
