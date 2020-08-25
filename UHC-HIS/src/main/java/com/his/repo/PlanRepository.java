package com.his.repo;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable>{
	
	@Transactional
	@Modifying
	@Query(value="UPDATE HIS_PLAN set DELETE_STATUS='N' where PLAN_ID=?",nativeQuery=true)
	public int  updateStatus(Integer PLAN_ID);
}
