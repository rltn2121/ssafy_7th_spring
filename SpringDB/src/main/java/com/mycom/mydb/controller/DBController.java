package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@Controller
public class DBController {
	@Autowired
	DBService service;
	
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
}
