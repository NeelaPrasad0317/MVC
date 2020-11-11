package com.nnp.controller;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nnp.service.WishMessageGenerator;

public class WishMessageController extends AbstractController {
	private WishMessageGenerator service;
	
	public WishMessageController(WishMessageGenerator service) {
		super();
		this.service = service;
	}

	@Override 
	public ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String wish=null;
		wish=service.generateMessage();
		return new ModelAndView("result", "wish", wish);
	}

}
