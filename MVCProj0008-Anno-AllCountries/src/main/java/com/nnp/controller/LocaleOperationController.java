package com.nnp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nnp.service.ILocaleInfoService;

@Controller
public class LocaleOperationController  {
	@Autowired
	private ILocaleInfoService service;
	
	@RequestMapping("/welcome")
	public String welcomeHome() {
		return "home";
	}
	
	@RequestMapping("/countriesInfo")
	public ModelAndView wishMsg() {
		Set<String> countries=service.fetchAllCountriesList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("countries", countries);
		mav.addObject("operation", "Countries");
		mav.setViewName("result");
		mav.addObject("size",countries.size());
		return mav;
	}

}
