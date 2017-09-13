package com.libertymutual.goforcode.invoice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {
	
	@GetMapping("")
	public String unsecured() {
		return "billing-records/list";
	}


}