package com.xing.studyboot.database.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MyJdbcTemplate {
	@Bean(name = "xhJdbcTemplate")
	public JdbcTemplate xhJdbcTemplate(@Qualifier("xhDS") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	@Bean(name = "cjkJdbcTemplate")
	public JdbcTemplate cjkJdbcTemplate(@Qualifier("cjkDS") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
