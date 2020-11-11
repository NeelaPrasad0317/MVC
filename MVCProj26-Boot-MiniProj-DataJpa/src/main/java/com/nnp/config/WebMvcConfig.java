package com.nnp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class WebMvcConfig {
	@Bean("messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource rbms=new ResourceBundleMessageSource();
		rbms.setBasename("com/nnp/commons/error");
		return rbms;
	}
	
}
