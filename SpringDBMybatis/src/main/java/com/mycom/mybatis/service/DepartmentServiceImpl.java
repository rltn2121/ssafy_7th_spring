package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.DepartmentDao;
import com.mycom.mybatis.dto.DepartmentDto;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentDao dao;

	@Override
	public DepartmentDto departmentDetail(int departmentId) {
		return dao.departmentDetail(departmentId);
	}

	@Override
	public List<DepartmentDto> departmentList() {
		return dao.departmentList();
	}

	@Override
	public int departmentInsert(DepartmentDto dto) {
		return dao.departmentInsert(dto);
	}

	@Override
	public int departmentUpdate(DepartmentDto dto) {
		return dao.departmentUpdate(dto);
	}

	@Override
	public int departmentDelete(int departmentId) {
		return dao.departmentDelete(departmentId);
	}	

}
