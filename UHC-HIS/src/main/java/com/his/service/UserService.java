package com.his.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.his.dto.UserDTO;
import com.his.entity.User;

public interface UserService {
	
	boolean saveUser(UserDTO userDTO);
	
	List<UserDTO> getAllUsers( );
	
	UserDTO getUserById(Long uid);
	
	boolean deleteUser(Long uid);
	
	List<UserDTO> searchBy(String roleName);
	
	UserDTO getAccountDetailsBytempPwd(String pwd,String email);
	
	Boolean updateAccountData(UserDTO userDTO);
	
	int updateStatusCode(Long conId);
	
	Page<User> findPaginated(int pageNo, int pageSize);
}
