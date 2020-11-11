package com.nnp.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nnp.config.RootAppConfig;
import com.nnp.config.WebMvcConfig;

public class WMGWebAppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		//create business layer container
		AnnotationConfigWebApplicationContext parentctx=new AnnotationConfigWebApplicationContext();
		//register config class
		parentctx.register(RootAppConfig.class);
		
		//create context loader listener with parent container
		ContextLoaderListener cll=new ContextLoaderListener(parentctx);
		//add cll to servlet container
		sc.addListener(cll);
		
		//create presentation layer container
		AnnotationConfigWebApplicationContext childctx=new AnnotationConfigWebApplicationContext();
		childctx.register(WebMvcConfig.class);
		
		//create dispather servler
		DispatcherServlet ds=new DispatcherServlet(childctx);
		//register with servlet container
		ServletRegistration.Dynamic register=sc.addServlet("ds", ds);
		//provide url pattern
		register.addMapping("/");
		register.setLoadOnStartup(1);
	}

}
