package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.his.dto.UserDTO;
import com.his.entity.User;
import com.his.service.UserService;





@Controller
//@RequestMapping("/edit_user")
public class ViewUsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/editUser")
	public String editUser(@RequestParam("user_id") Long user_id,Model model) {
		
		UserDTO userDTO = userService.getUserById(user_id);
		model.addAttribute("user", userDTO);
		
		return "userForm";

	}
	
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("user_id") Long user_id) {
		
		boolean deletestatus = userService.deleteUser(user_id);
		if(deletestatus) {
			return "redirect:/viewUsers";
		}
		return null;

	}
	
  
  @PostMapping("/searchSubmit")
  public String searchSubmit(@ModelAttribute UserDTO searchDto,Model model) {
	  System.out.println(searchDto);
      List<UserDTO> result = userService.searchBy(searchDto.getRoleName());
      System.out.println(result);
      model.addAttribute("result",result);
	  
	  return "filterResult";
  }
  
  @GetMapping("/active")
	public String editStatusForActive(@RequestParam("user_id") Long user_id,Model model) {
		
	  int updateStatusCode = userService.updateStatusCode(user_id);
		if(updateStatusCode <= 0) {
			System.out.println(updateStatusCode);
			return "redirect:/viewUsers";
		}
		else {
			System.out.println(updateStatusCode);
			return "redirect:/viewUsers";
		}
		
		
		
	}
}
