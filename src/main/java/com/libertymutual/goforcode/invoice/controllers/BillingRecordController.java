package com.libertymutual.goforcode.invoice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {
	
	@GetMapping("")
	public ModelAndView list() {		
		ModelAndView mv = new ModelAndView("billing-records/list");
		return mv;
	}


}
