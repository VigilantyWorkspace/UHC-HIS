package com.his.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.his.dto.PlanDTO;
import com.his.dto.UserDTO;
import com.his.entity.PlanEntity;

public interface PlanService {
	
	boolean savePlan(PlanDTO planDTO);

	List<PlanDTO> getAllPLans( );

	PlanDTO getPlanById(Integer planid);

	boolean deletePlan(Integer planid);
	
	int updateStatusCode(Integer planid);
	
	Page<PlanEntity> findPaginated(int pageNo, int pageSize);
}
