package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.dto.UserDTO;
import com.his.entity.PlanEntity;
import com.his.entity.User;
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
		  
		  return findUserPaginated(1, model);
		  //return "viewUsers";
	  
	  }
	 
	  @GetMapping("/page/{pageNo}")
		public String findUserPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		    int pageSize = 4;

		    Page<User> page = userService.findPaginated(pageNo, pageSize);
		    List<User> userList = page.getContent();

		    model.addAttribute("currentPage", pageNo);
		    model.addAttribute("totalPages", page.getTotalPages());
		    model.addAttribute("totalItems", page.getTotalElements());
		    //model.addAttribute("userList", userList);
		    return "viewUsers";
		}//end of method
	  
}