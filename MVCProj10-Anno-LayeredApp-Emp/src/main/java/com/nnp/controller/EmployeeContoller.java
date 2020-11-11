package com.nnp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnp.dto.EmployeeDTO;
import com.nnp.service.IEmployeeMgmtService;

@Controller
public class EmployeeContoller {
	@Autowired
	private IEmployeeMgmtService service;
	
	@RequestMapping("/getEmployees")
	public String getEmployeeDetails(Model model) {
		List<EmployeeDTO> lidtos=service.fetchEmployeeDetails();
		model.addAttribute("emp_details", lidtos);
		return "show_emp_details";
	}
	
	@RequestMapping("/welcome")
	public String getHome() {
		return "home";
	}
	
}
