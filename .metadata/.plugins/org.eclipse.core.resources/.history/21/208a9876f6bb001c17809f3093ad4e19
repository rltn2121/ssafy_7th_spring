package com.ssafy.hello.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "kor")
public class HelloMessageKor implements HelloMessage {
	// 이전에는 이렇게 함
//	private TestDao dao = new TestDao();
	
	// Spring에서는 이렇게 함
	// 원래는 NPE 나야 하지만, application.xml에서 설정해주면 됨

	@Autowired
	private TestDao dao;
//	public void setDao(TestDao dao) {
//		this.dao = dao;
//	}
	public HelloMessageKor() {
		System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
	}

	public String hello(String name) {
		return "안녕하세요 " + name;
	}
	
}
