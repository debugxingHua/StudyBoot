package com.xing.studyboot.database.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSourceOtherConfig {

	/**
	 * 1.通过以xh.datasource开头的属性配置赖创建一个DataSourceProperties
	 * @return
	 */
	@Bean
	@ConfigurationProperties("xh.datasource")
	public DataSourceProperties aDataSourceProperties() {
		return new DataSourceProperties();
	}
	/**
	 * 2.用上面的DataSourceProperties构建一个数据源，@Primary生命成这个为主数据源
	 * @return
	 */
	@Bean(name="xhDS")
	@Primary
	public DataSource aDataSource() {
	  DataSourceProperties dataSourceProperties = aDataSourceProperties();
	  System.out.println("数据源xh datasource:->{}"+dataSourceProperties.getUrl());
	  return dataSourceProperties.initializeDataSourceBuilder().build();
	}
	/**
	 * 实例化一个事务
	 * @param dataSource
	 * @return
	 */
	@Bean
	@Resource
	public PlatformTransactionManager xhTxManager(DataSource dataSource) {
	  return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@ConfigurationProperties("cjk.datasource")
	public DataSourceProperties bDataSourceProperties() {
	  return new DataSourceProperties();
	}
	@Bean(name="cjkDS")
	public DataSource bDataSource() {
	  DataSourceProperties dataSourceProperties = bDataSourceProperties();
	  System.out.println("数据源cjk datasource: {}"+dataSourceProperties.getUrl());
	  return dataSourceProperties.initializeDataSourceBuilder().build();
	}
	@Bean
	@Resource
	public PlatformTransactionManager cjkTxManager(DataSource dataSource) {
	  return new DataSourceTransactionManager(dataSource);
	}
}
