package com.his.dto;

import java.util.Date;

import com.his.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnlockDTO {
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
}
