package com.mycom.adv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.adv.dto.StudentDto;
import com.mycom.adv.service.StudentService;

@RunWith(SpringRunner.class)	// junit과 spring 연결
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")			// Spring context 설정
public class StudentTest {
	@Autowired
	StudentService service;
	
	@Test
	public void testBeanCreation() {
		assertNotNull(service);
	}
	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testStudentInsert() {
//		StudentDto dto = new StudentDto();
//		dto.setStudentNm("이길동");
//		dto.setEmail("lee@gil.com");
//		dto.setPhone("010-1111-2222");
//		
//		assertEquals(service.studentInsert(dto),1);
//	}
	
	@Test
	public void testStudentDetail() {
		StudentDto dto = new StudentDto();
		dto.setStudentId(1);
		dto.setStudentNm("홍길동");
		dto.setEmail("hong");
		dto.setPhone("010-1111-0000");
		
		assertEquals(service.studentDetail(1),dto);
	}
}
