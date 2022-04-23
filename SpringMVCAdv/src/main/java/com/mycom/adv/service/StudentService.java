package com.mycom.adv.service;

import com.mycom.adv.dto.StudentDto;

public interface StudentService {
	public int studentInsert(StudentDto dto);
	public StudentDto studentDetail(int studentId);
}
