package com.nnp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AopConfig.class,ServiceConfig.class,persistenceConfig1.class})
public class RootAppConfig {
	
}
