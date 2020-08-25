package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.his.constants.AppConstant;
import com.his.dto.UserDTO;
import com.his.entity.User;
import com.his.repo.UserRepository;
import com.his.utils.PasswordUtils;


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
		
//		BeanUtils.copyProperties(userDTO, userEntity);
//		User savedUserEntity = userRepo.save(userEntity);
//		return savedUserEntity.getUser_id() != null;
		
		Boolean isSave = false;
		if (userEntity.getUser_id() == null) {
			userDTO.setPassword(PasswordUtils.generateOTP(AppConstant.size));
			userDTO.setAccStatus(AppConstant.lockedStatus);
			userDTO.setDeleteStatus("Y");
			BeanUtils.copyProperties(userDTO, userEntity);
			userRepo.save(userEntity);
			isSave = true;
			return isSave;
		}
		return isSave;
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

	@Override
	public UserDTO getAccountDetailsBytempPwd(String pwd, String email) {
	
		User findByPassword = userRepo.findByPasswordAndEmail(pwd,email);
		UserDTO userDTO = null;
		
		if(findByPassword != null) {
			userDTO = new UserDTO();
			BeanUtils.copyProperties(findByPassword,userDTO);
		}
		
		return userDTO;
	}
		

	@Override
	public Boolean updateAccountData(UserDTO userDTO) {
		
		Boolean isUpdate = false;
		
		userDTO.setAccStatus(AppConstant.finallockedStatus);
		User entity = new User();
		
		BeanUtils.copyProperties(userDTO,entity);
		userRepo.save(entity);
		
		isUpdate = true;
		
		return isUpdate;
	}
	
	@Override
	public int updateStatusCode(Long id) {
		
		return this.userRepo.updateStatus(id);
		
	}
}