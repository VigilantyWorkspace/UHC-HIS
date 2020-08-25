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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.dto.PlanDTO;
import com.his.service.PlanService;

@Controller
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping(value = {"/addPlan"})
	public String loadForm(Model model) {
		
		PlanDTO planDTO = new PlanDTO();
		model.addAttribute("plan", planDTO);
		return "planForm";
	}//end of method
	
	@PostMapping(value = "/storePlan")
	public String handleSubmitBtn(@ModelAttribute("plan")PlanDTO planDTO, RedirectAttributes attributes) {
		
		boolean isSaved = planService.savePlan(planDTO);
		if(isSaved) {
			attributes.addFlashAttribute("successMsg", "Plan Saved Successfully");
		}else {
			attributes.addFlashAttribute("errorMsg", "Plan Saving Failed");
		}
		
		return "redirect:/addPlan";
	}//end of method
	
	@GetMapping("/viewPlans")
	public String handleViewPlans(Model model) {
		List<PlanDTO> planListDTO =planService.getAllPLans();
		model.addAttribute("planDetailsList",planListDTO);
		
		return "viewPlans";
		
	}//end of method
	
	@RequestMapping("/editPlan")
	public String editPlan(@RequestParam("plan_id") Integer plan_id,Model model) {
		
		PlanDTO planDTO = planService.getPlanById(plan_id);
		model.addAttribute("plan", planDTO);
		
		return "redirect:/addPlan";
	}//end of method
	
	@RequestMapping("/deletePlan")
	public String deletePlan(@RequestParam("plan_Id") Integer plan_id) {
		
		boolean deletestatus = planService.deletePlan(plan_id);
		if(deletestatus) {
			return "redirect:/viewPlans";
		}
		return null;

	}//end of method
	
	@GetMapping("/activePlan")
	public String editStatusForActive(@RequestParam("plan_id") Integer plan_id,Model model) {
		
	  int updateStatusCode = planService.updateStatusCode(plan_id);
		if(updateStatusCode <= 0) {
			System.out.println(updateStatusCode);
			return "redirect:/viewPlans";
		}
		else {
			System.out.println(updateStatusCode);
			return "redirect:/viewPlans";
		}
		
	}//end of method
	
}//end of Controller