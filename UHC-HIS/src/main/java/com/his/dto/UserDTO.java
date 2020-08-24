package com.his.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.his.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
	
	private Long user_id;
    private String firstName;
    private String lastName;
    private String email;
    private Long contact_no;
    private String gender;
    private String password;
    private String roleName;
    private boolean isActive;
    private String accStatus;
    private String deleteStatus;
    private Date createdDate;
    private Date updatedDate;
}
