package com.ssafy.hw.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//이 파일이 환경설정 파일임을 명시한다.
@Configuration
//basePackage를 통해 bean을 스캔한다.
@ComponentScan(basePackages = {"com.ssafy.hw"})
public class ApplicationConfig {
	
	/**
	 * Annotation망식을 통해 생성할 수 없는 bean은 @Bean을 통해 등록한다.
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafy_user?serverTimeZone=UTC");
		ds.setUsername("ssafy");
		ds.setPassword("1234");
		
		return ds;
	}
}
