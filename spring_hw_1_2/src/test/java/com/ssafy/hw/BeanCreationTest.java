package com.ssafy.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.hw.config.ApplicationConfig;
//import com.ssafy.hw.config.ApplicationConfig;
import com.ssafy.hw.model.repo.UserRepo;
import com.ssafy.hw.model.service.UserServiceImpl;

//Spring과 연동하기위해  SpringRunner를 사용한다.
@RunWith(SpringRunner.class)
//설정 파일의 위치를 지정한다.
@ContextConfiguration(classes = ApplicationConfig.class)
//@ContextConfiguration(locations = {"file:src/main/resources/application.xml"})
public class BeanCreationTest {
	
	// 스캔을 통해 빈 가져오기
	@Autowired
	UserRepo repo;
	@Autowired
	UserServiceImpl service;
	@Autowired
	DataSource ds;
	
	// UserRepo, UserService 가 잘 생성되었는지 테스트 한다.
	@Test
	public void testBeanCreation() {
		// 각각 null 이 아닌지 테스트
		assertNotNull(repo);
		assertNotNull(service);
	}
	
	// context에서 직접 얻어온 UserRepo와 UserService가 가지는 UserRepo가 동일한지 테스트한다.
	@Test
	public void testSingleTon() {
		// 두 객체가 동일한 객체인지 테스트
		assertEquals(repo , service.getUserRepo());
	}
	
	// DataSource객체가 잘 생성되었는지 테스트한다.
	@Test
	public void testDataSource() {
		assertNotNull(ds);
	}

}
