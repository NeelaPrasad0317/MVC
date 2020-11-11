package com.nnp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class AopConfig {
	@Autowired
	private DataSource ds;
	@Bean
	public TransactionManager getTxMgr() {
		return new DataSourceTransactionManager(ds);
	}
}
