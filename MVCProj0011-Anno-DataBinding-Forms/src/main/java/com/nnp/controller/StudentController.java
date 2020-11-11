package com.nnp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nnp.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/welcome")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String getForm(@ModelAttribute Student st) {
		st.setSadd("Hyd");
		System.out.println("student::"+st);
		System.out.println(st.hashCode());
		return "show_form";
	}
	
	/*@GetMapping("/register")
	public String getForm(Map<String,Student> map) {
		Student st=new Student();
		st.setSadd("Hyd");
		map.put("stFrm", st);
		System.out.println("student::"+st);
		System.out.println(st.hashCode());
		return "show_form";
	}*/
	
	@PostMapping("/register")
	public String getForm(Map<String,Student> map,@ModelAttribute Student st) {
		map.put("stFrm", st);
		System.out.println("student::"+st);
		System.out.println(st.hashCode());
		return "result";
	}
	
	@GetMapping("/links")
	public String getLinksData(	@RequestParam("sno")Integer sno,
										@RequestParam("sname")String sname) {
		System.out.println("req params::"+sno+"...."+sname);
		return "show_params";
	}
}
