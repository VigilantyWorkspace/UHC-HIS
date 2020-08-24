package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.dto.UnlockDTO;
import com.his.dto.UserDTO;
import com.his.service.UserService;

@Controller
public class UnLockController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/unlockAccount")
	public String unlockAccount(@RequestParam("email") String mail, @RequestParam("OTP") String otp, Model model) {

		UnlockDTO unlockDTO = new UnlockDTO();
		model.addAttribute("mail", mail);
		model.addAttribute("otp", otp);
		model.addAttribute("unLockBind", unlockDTO);

		return "unlockAccount";

	};

	@PostMapping("/unlockUserAcc")
	public String unlockUserAcc(@ModelAttribute("confirmPwd") UnlockDTO unlockDTO, Model model) {
		UnlockDTO unlockbind = new UnlockDTO();
		model.addAttribute("unLockBind", unlockbind);
		try {

			UserDTO accountDetailsBytempPwd = userService.getAccountDetailsBytempPwd(unlockDTO.getTempPwd(),
					unlockDTO.getEmail());

			if (accountDetailsBytempPwd != null) {

				accountDetailsBytempPwd.setPassword(unlockDTO.getConfirmPwd());

				Boolean updateFormData = userService.updateAccountData(accountDetailsBytempPwd);
				if (updateFormData != null) {
					return "confirmation";
				}

			}
		} catch (Exception e) {

		}

		model.addAttribute("errorMsg", "Please Check Your  OTP");
		unlockbind.setEmail(unlockDTO.getEmail());

		return "unlockAccount";

	};

}
