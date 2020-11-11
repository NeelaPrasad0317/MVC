package com.nnp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nnp.service.IWishMsgGenerator;

@Controller
public class WMGController {
	@Autowired
	private IWishMsgGenerator wmg;
	
	@GetMapping("/wish")
	public String getWish(Map<String,Object> map) {
		String msg=wmg.getWmg();
		map.put("msg", msg);
		return "home";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
}
