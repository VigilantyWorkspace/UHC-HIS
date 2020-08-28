package com.his.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.dto.PlanDTO;
import com.his.entity.PlanEntity;
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
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); //yyyy-MM-dd'T'HH:mm:ssZ example
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
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
		
		 return findPlanPaginated(1, model);
		//return "viewPlans";
		
	}//end of method
	
	@RequestMapping("/editPlan")
	public String editPlan(@RequestParam("plan_id") Integer plan_id,Model model) {
		
		PlanDTO planDTO = planService.getPlanById(plan_id);
		model.addAttribute("plan", planDTO);
		
		return "planForm";
	}//end of method
	
	@RequestMapping("/deletePlan")
	public String deletePlan(@RequestParam("plan_id") Integer plan_id) {
		
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
	
	@GetMapping("/planpage/{pageNo}")
	public String findPlanPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
	    int pageSize = 4;

	    Page < PlanEntity > page = planService.findPaginated(pageNo, pageSize);
	    List<PlanEntity> planList = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    //model.addAttribute("planList", planList);
	    return "viewPlans";
	}//end of method
	
}//end of Controller