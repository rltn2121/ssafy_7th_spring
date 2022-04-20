package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.DepartmentDto;

@Mapper
public interface DepartmentDao {
	public DepartmentDto departmentDetail(int departmentId);
	public List<DepartmentDto> departmentList();
	public int departmentInsert(DepartmentDto dto);
	public int departmentUpdate(DepartmentDto dto);
	public int departmentDelete(int departmentId);
}
