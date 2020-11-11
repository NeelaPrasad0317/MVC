package com.nnp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nnp.service.StudentMgmtService;

@Controller
public class StudentOperationsController {
	@Autowired
	private StudentMgmtService service;

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/excel")
	public String getRecordsInExcel(Map<String,Object>map) {
		map.put("studentsInfo", service.getAllStudents());
		return "excelView";
	}
	@GetMapping("/pdf")
	public String getRecordsInPDF(Map<String,Object>map) {
		map.put("studentsInfo", service.getAllStudents());
		return "pdfView";
	}
}
