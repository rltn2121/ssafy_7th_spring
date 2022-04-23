package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import com.mycom.mybatis.dto.EmpDto;

public interface DBService {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
	public List<EmpDto> empListParameterMap(Map<String, String> map);
	public List<EmpDto> empListParameterMap2(String firstName, String lastName);
	public List<EmpDto> empListParameterMap3(EmpDto dto);
	public List<EmpDto> empListLike(String searchWord);
	
	public List<EmpDto> empListWhereIf(Map<String, String> map);
}
