package com.nnp.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
//@ComponentScan(basePackages = "com.nnp.controller")
public class WebMvcConfig {
	@Bean
	public TilesConfigurer getConfigurer() {
		TilesConfigurer tc=new TilesConfigurer();
		tc.setDefinitions("/WEB-INF/tiles.xml");
		return tc;
	}
	
	@Bean
	public TilesViewResolver getViewResolver() {
		return new TilesViewResolver();
	}
}
