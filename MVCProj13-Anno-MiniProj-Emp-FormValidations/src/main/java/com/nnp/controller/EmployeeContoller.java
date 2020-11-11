package com.nnp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nnp.dto.EmployeeDTO;
import com.nnp.model.Employee;
import com.nnp.service.IEmployeeMgmtService;
import com.nnp.validations.EmployeeValidator;

@Controller
public class EmployeeContoller {
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator validator;
	
	/*--------------------------	Welcome -----------------------------------------------*/
	@RequestMapping("/welcome.htm")
	public String getHome() {
		return "home";
	}
	
	/*--------------------------	Get Emp Details -----------------------------------------------*/
	@RequestMapping("/getEmployees.htm")
	public String getEmployeeDetails(Model model) {
		List<EmployeeDTO> lidtos=service.fetchEmployeeDetails();
		model.addAttribute("emp_details", lidtos);
		return "show_emp_details";
	}
	
	/*--------------------------	Add new Emp Details -----------------------------------------------*/
	@GetMapping("/addEmp.htm")
	public String addEmployee(@ModelAttribute("emp") Employee emp) {
		return "addEmp_form";
	}
	
	@PostMapping("/addEmp.htm")
	public String addEmployee(RedirectAttributes rattr,@ModelAttribute("emp") Employee emp,BindingResult errors) {
//		System.out.println(submit);
		if(!emp.getValid().equalsIgnoreCase("yes"))
			if(validator.supports(emp.getClass()))
				validator.validate(emp, errors);
		
		if(errors.hasErrors())
			return "addEmp_form";
		
		//add data to dto
		EmployeeDTO dto=new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		//use service and register emp
		String msg=service.addEmp(dto);
//		List<EmployeeDTO> lidtos=service.fetchEmployeeDetails();
//		map.put("emp_details", lidtos);
		rattr.addFlashAttribute("msg", msg);
		return "redirect:getEmployees.htm";
	}
	
	@ModelAttribute("deptNos")
	private List<Integer> populateDeptNo(){
		return service.fetchAllDeptNos();
	}
	
	/*--------------------------	Delete Emp Details -----------------------------------------------*/
	@GetMapping("/deleteEmp.htm")
	private String deleteEmp(@RequestParam Integer empNo,RedirectAttributes rattr) {
		String msg=null;
		//user service to delete the employee from table
		msg=service.deleteEmpByID(empNo);
		//add result msg as redirect attribute
		rattr.addFlashAttribute("msg", msg);
		
		//redirect page to employees list with msg
		return "redirect:getEmployees.htm";
	}
	
	
	/*--------------------------	Edit Emp Details -----------------------------------------------*/
	@GetMapping("/editEmp.htm")
	public String editEmp(@RequestParam Integer empNo,@ModelAttribute("emp") Employee emp) {
		//use service to get emp details of given empNo
		EmployeeDTO dto=null;
		dto=service.getEmpByID(empNo);
		BeanUtils.copyProperties(dto, emp);
//		emp.setEmpNo(empNo);
		System.out.println(emp);
		return "editEmp_form";
	}
	
	@PostMapping("/editEmp.htm")
	public String editEmp(@ModelAttribute("emp") Employee emp,BindingResult errors,RedirectAttributes rattr ) {
		//check and validate
		if(!emp.getValid().equalsIgnoreCase("yes"))
			if(validator.supports(emp.getClass()))
				validator.validate(emp, errors);
		
		if(errors.hasErrors())
			return "editEmp_form";
		
		EmployeeDTO dto=new EmployeeDTO();
		System.out.println("=================");
		System.out.println(emp);
		BeanUtils.copyProperties(emp, dto);
		String msg=service.updateEmp(dto);
		rattr.addFlashAttribute("msg",msg);
		return "redirect:getEmployees.htm";
	}
}




















