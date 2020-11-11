package com.nnp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan("com.nnp.dao")
public class persistenceConfig {
	@Bean
	public JndiObjectFactoryBean getDs() {
		JndiObjectFactoryBean jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/oraDsJndi");
		return jofb;
//		return (DataSource) jofb.getObject();
	}
	
	@Bean
	public SimpleJdbcCall getjdbcCall() {
		return new SimpleJdbcCall((DataSource) getDs().getObject());
	}
}
