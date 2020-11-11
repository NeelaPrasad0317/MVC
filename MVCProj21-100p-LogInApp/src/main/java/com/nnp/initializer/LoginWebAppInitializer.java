package com.nnp.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nnp.config.RootAppConfig;
import com.nnp.config.WebMvcConfig;

public class LoginWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};
	}

}
