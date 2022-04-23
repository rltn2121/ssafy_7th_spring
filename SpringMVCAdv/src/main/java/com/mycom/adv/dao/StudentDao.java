package com.mycom.adv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.adv.dto.StudentDto;



@Mapper
public interface StudentDao {
	public int studentInsert(StudentDto dto);
	public StudentDto studentDetail(int studentId);
}
