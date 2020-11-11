package com.nnp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TilesNavigationController {

	@GetMapping("/home")
	public String getHomePage() {
		return "homePage";
	}
	@GetMapping("/faculties")
	public String getFacultiesPage() {
		return "facultiesPage";
	}
	@GetMapping("/courses")
	public String getCoursesPage() {
		return "coursesPage";
	}
	@GetMapping("/contactUs")
	public String getContactUsPage() {
		return "contactUsPage";
	}
	
}
