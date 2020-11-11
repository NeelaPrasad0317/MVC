package com.nnp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class MvcProj25BootMiniProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProj25BootMiniProjApplication.class, args);
	}

}
