package com.nnp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nnp.service.WishMessageGenerator;

@Controller
public class WishMessageController  {
	@Autowired
	private WishMessageGenerator service;
	
	@RequestMapping("/welcome")
	public String welcomeHome() {
		return "home";
	}
	
	@RequestMapping("/wish")
	public ModelAndView wishMsg() {
		String wish=service.generateMessage();
		return new ModelAndView("result", "wish", wish);
	}

}
