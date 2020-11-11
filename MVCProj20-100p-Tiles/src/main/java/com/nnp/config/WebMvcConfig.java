package com.nnp.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nnp.controller")

public class WebMvcConfig implements WebMvcConfigurer{
	@Bean
	public TilesConfigurer configTiles() {
		TilesConfigurer tc=new TilesConfigurer();
		tc.setDefinitions("/WEB-INF/tiles.xml");
		return tc;
	}
	
	@Bean
	public TilesViewResolver getTilesViewResolver() {
		return new TilesViewResolver();
	}
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	   }
}
