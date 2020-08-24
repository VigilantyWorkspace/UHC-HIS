package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.his.dto.UserDTO;
import com.his.entity.User;
import com.his.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
//	@Autowired
//    private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean saveUser(UserDTO userDTO) {
		User userEntity = new User();
		/*
		 * if (userEntity.getUser_id() == null) {
		 * userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword())
		 * ); userEntity.setActive(Boolean.FALSE); }
		 */
		
		BeanUtils.copyProperties(userDTO, userEntity);
		User savedUserEntity = userRepo.save(userEntity);
		return savedUserEntity.getUser_id() != null;
	
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		List<User> fetchedUsers = userRepo.findAll();
		List<UserDTO> userListDTO = new ArrayList<UserDTO>();
		
		for(User userEntity :fetchedUsers) {
			UserDTO  userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity,userDTO);
			userListDTO.add(userDTO);
		}
		
		return userListDTO;
	}

	@Override
	public UserDTO getUserById(Long uid) {
		
		 Optional<User> userById = userRepo.findById(uid);
		
		if(userById.isPresent()) {
			
			User userEntity = userById.get();
			UserDTO  userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity,userDTO);
			return userDTO;
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long uid) {
		
		userRepo.deleteById(uid);
		
		return true;
	}
	
    @Override
    public List<UserDTO> searchBy(String roleName) {
    	
	     
	     List<User> userList = userRepo.findByRoleNameIgnoreCaseContaining(roleName);
	     List<UserDTO> userListDTO = new ArrayList<UserDTO>();
			
			for(User userEntity :userList) {
				UserDTO  userDTO = new UserDTO();
				BeanUtils.copyProperties(userEntity,userDTO);
				userListDTO.add(userDTO);
			}
			
			return userListDTO;
	}
}