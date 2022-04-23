package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.DepartmentDto;

public interface DepartmentService {
	public DepartmentDto departmentDetail(int departmentId);
	public List<DepartmentDto> departmentList();
	public int departmentInsert(DepartmentDto dto);
	public int departmentUpdate(DepartmentDto dto);
	public int departmentDelete(int departmentId);
}
