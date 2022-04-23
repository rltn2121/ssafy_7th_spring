package com.mycom.adv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.adv.dao.StudentDao;
import com.mycom.adv.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao dao;
	
	@Override
//	@Transactional
	public int studentInsert(StudentDto dto) {
		// 첫 번째 삽입 (@Transactional 없으면 여기만 실행되고 두 번째 거 실행 안됨)
		dao.studentInsert(dto);
		// 에러 발생을 위한 코드
		String s = null;
		s.length();
		
		// 두 번째 삽입 (@Transactional 있으면 위에 거 성공해도 오류 발생 시 취소됨)
		return dao.studentInsert(dto);
	}

	@Override
	public StudentDto studentDetail(int studentId) {
		return dao.studentDetail(studentId);
	}

}
