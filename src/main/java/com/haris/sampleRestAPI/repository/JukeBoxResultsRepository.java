package com.haris.sampleRestAPI.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.haris.sampleRestAPI.model.JukeBoxResult;

public interface JukeBoxResultsRepository extends PagingAndSortingRepository<JukeBoxResult, Long> {
	
}
