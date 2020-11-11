package com.nnp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class WebMvcConfig {
	@Bean("messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource rbms=new ResourceBundleMessageSource();
		rbms.setBasename("com/nnp/commons/error");
		return rbms;
	}
	
	@Bean
	public JndiObjectFactoryBean getJOFB() {
		JndiObjectFactoryBean jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/oraDsJndi");
		return jofb;
	}
	@Bean
	public JdbcTemplate getJt() {
		System.out.println();
		JdbcTemplate jt=new JdbcTemplate((DataSource) getJOFB().getObject());
		System.out.println();
		System.out.println(jt);
		System.out.println();
		return jt;
	}
}
