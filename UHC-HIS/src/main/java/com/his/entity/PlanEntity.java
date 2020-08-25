package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HIS_PLAN")
@SQLDelete(sql = "UPDATE HIS_PLAN set DELETE_STATUS='Y' where PLAN_ID=?"  )

public class PlanEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "PLAN_ID")
	    private Integer plan_id;

	    @Column(name = "PLAN_NAME")
	    private String planName;

	    @Column(name = "PLAN_DESC")
	    private String planDesc;
	    
		@Temporal(TemporalType.DATE)
		@Column(name="PLAN_START_DATE")
		private Date plan_start_date;
			
		@Temporal(TemporalType.DATE)
		@Column(name="PLAN_END_DATE")
		private Date plan_end_date;
	    
	    @Column(name = "ACC_STATUS")
		private String accStatus;
	    
	    @Column(name = "DELETE_STATUS")
		private String deleteStatus;
	    
	    @CreationTimestamp
		@Temporal(TemporalType.DATE)
		@Column(name="CREATED_DATE",updatable = false)
		private Date createdDate;
		
		@UpdateTimestamp	
		@Temporal(TemporalType.DATE)
		@Column(name="UPDATED_DATE",insertable = false)
		private Date updatedDate;

}
