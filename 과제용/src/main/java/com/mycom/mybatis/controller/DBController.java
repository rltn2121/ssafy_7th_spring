package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.DBService;

@Controller
public class DBController {
	@Autowired
	DBService service;
	
	
	@GetMapping
	public String departmentPage() {
		return "department";
	}
	
	@GetMapping("/empDetail/{employeeId}")	
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println("employeeId: " + employeeId);
		EmpDto dto = service.empDetail(employeeId);
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping("/empDetailPage/{employeeId}")	
	public String empDetailPage(@PathVariable int employeeId, Model model) {
		System.out.println("employeeId: " + employeeId);
		EmpDto dto = service.empDetail(employeeId);
		model.addAttribute("dto", dto);
		System.out.println(dto);
		return "detail";
	}
	
	@GetMapping("/empList")	
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		list.forEach((emp) -> System.out.println(emp));
		return list;
	}
	
	@PostMapping("/empInsert")	
	@ResponseBody
	public int empInsert(EmpDto dto) {
		System.out.println(dto);
		int ret = service.empInsert(dto);
		return ret;
	}
	@PostMapping("/empInsertJSON")	
	@ResponseBody
	public int empInsertJSON(@RequestBody EmpDto dto) {
		System.out.println(dto);
		int ret = service.empInsert(dto);
		return ret;
	}
	@PostMapping("/empUpdate")	
	@ResponseBody
	public int empUpdate(EmpDto dto) {
		System.out.println(dto);
		int ret = service.empUpdate(dto);
		return ret;
	}
	
	@PostMapping("/empDelete")	
	@ResponseBody
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
	@GetMapping("/empListResultMap")	
	@ResponseBody
	public List<EmpDto> empListResultMap() {
		List<EmpDto> list = service.empList();
		list.forEach((emp) -> System.out.println(emp));
		return list;
	}
	
	@GetMapping("/empListParameterMap")	
	@ResponseBody
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {
		System.out.println("empListParameterMap");
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		System.out.println("firstName: " + firstName);
		System.out.println("lastName" + lastName);
		List<EmpDto> list = service.empListParameterMap(map);
		return list;
	}
	
	@GetMapping("/empListParameterMap2")	
	@ResponseBody
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {
		System.out.println("empListParameterMap2");
		System.out.println("firstName: " + firstName);
		System.out.println("lastName" + lastName);
		List<EmpDto> list = service.empListParameterMap2(firstName, lastName);
		return list;
	}
	
	@GetMapping("/empListParameterMap3")	
	@ResponseBody
	public List<EmpDto> empListParameterMap3(EmpDto dto) {
		System.out.println("firstName: " + dto.getFirstName());
		System.out.println("lastName" + dto.getLastName());
		List<EmpDto> list = service.empListParameterMap3(dto);
		return list;
	}
	
	@GetMapping("/empListLike")	
	@ResponseBody
	public List<EmpDto> empListLike(String searchWord) {
		List<EmpDto> list = service.empListLike(searchWord);
		return list;
	}
	
	@GetMapping("/empListWhereIf")	
	@ResponseBody
	public List<EmpDto> empListWherIf(String firstName, String lastName) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		List<EmpDto> list = service.empListWhereIf(map);
		return list;
	}
}
