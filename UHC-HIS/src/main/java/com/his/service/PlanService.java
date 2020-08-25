package com.his.service;

import java.util.List;

import com.his.dto.PlanDTO;

public interface PlanService {
	
	boolean savePlan(PlanDTO planDTO);

	List<PlanDTO> getAllPLans( );

	PlanDTO getPlanById(Integer planid);

	boolean deletePlan(Integer planid);
	
	int updateStatusCode(Integer planid);
}
