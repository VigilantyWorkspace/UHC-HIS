package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dto.PlanDTO;
import com.his.entity.PlanEntity;
import com.his.repo.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepository planRepo;
	
	@Override
	public boolean savePlan(PlanDTO planDTO) {
		PlanEntity planEntity = new PlanEntity();
		planDTO.setDeleteStatus("N");
		BeanUtils.copyProperties(planDTO, planEntity);
		PlanEntity savedPlanEntity = planRepo.save(planEntity);
		return savedPlanEntity.getPlan_id() != null;
	}

	@Override
	public List<PlanDTO> getAllPLans() {
		List<PlanEntity> fetchedPlans = planRepo.findAll();
		List<PlanDTO> planListDTO = new ArrayList<PlanDTO>();
		
		for(PlanEntity planEntity :fetchedPlans) {
			PlanDTO planDTO = new PlanDTO();
			BeanUtils.copyProperties(planEntity,planDTO);
			planListDTO.add(planDTO);
		}
		
		return planListDTO;
	}

	@Override
	public PlanDTO getPlanById(Integer planid) {
		
		Optional<PlanEntity> planById = planRepo.findById(planid);

		if(planById.isPresent()) {

			PlanEntity planEntity = planById.get();
			PlanDTO  planDTO = new PlanDTO();
			BeanUtils.copyProperties(planEntity,planDTO);
			return planDTO;
		}
		return null;
	}

	@Override
	public boolean deletePlan(Integer planid) {

		planRepo.deleteById(planid);
		
		return true;
	}

	@Override
	public int updateStatusCode(Integer planid) {
		return this.planRepo.updateStatus(planid);
	}

}