package com.nnp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstAppController {
	
	@GetMapping("/browser")
	public String getBrowserName(Map<String,Object> map,HttpServletRequest req) {
		String browser=req.getHeader("user-agent");
		map.put("browser", browser);
		return "result";
	}
	
	@GetMapping("/welcome")
	public String getHome() {
		return "home";
	}
}
