package com.nnp.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nnp.dto.UserDTO;
import com.nnp.model.User;
import com.nnp.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	private ILoginService service;
	
	@GetMapping("/login")
	private String getLogInForm(@ModelAttribute User user) {
		return "login_form";
	}
	@PostMapping("/login")
	private String performLogIn(Map<String,Object> map,@ModelAttribute User user) {
		UserDTO dto=new UserDTO();
		BeanUtils.copyProperties(user, dto);
		String result=service.checkCredentials(dto);
		System.out.println(result);
		map.put("result", result);
		return "login_form";
	}
}
