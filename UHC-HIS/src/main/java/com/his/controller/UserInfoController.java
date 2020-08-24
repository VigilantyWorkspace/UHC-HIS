package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.dto.UserDTO;
import com.his.service.UserService;
import com.his.utils.MailUtils;



@Controller
//@RequestMapping("/user-api")

public class UserInfoController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailUtils mailUtils;
	
	@GetMapping(value = { "/", "/addUser" })
	public String loadForm(Model model) {
		
		UserDTO userDTO = new UserDTO();
		model.addAttribute("user", userDTO);
		return "userForm";
		
	}
	
	@PostMapping(value = "/storeUser")
	public String handleSubmitBtn(@ModelAttribute("user")UserDTO userDTO, RedirectAttributes attributes) {
		
		boolean isSaved = userService.saveUser(userDTO);
		if(isSaved) {
			mailUtils.sendUserAccUnlockMail2(userDTO);
			attributes.addFlashAttribute("msg", "Your Account is almost created.Check your email to unlock account,Thank you.");
		}else {
			attributes.addFlashAttribute("errorMsg", "Sorry,Account Creation Failed");
		}
		
		return "redirect:/addUser";
	}
	
	
	  @GetMapping("/viewUsers")
	  public String handleViewUserLink(Model model) {
		  List<UserDTO> userListDTO =userService.getAllUsers();
		  model.addAttribute("userDetailsList",userListDTO);
		  
		  return "viewUsers";
	  
	  }
	 
	  
	  
}