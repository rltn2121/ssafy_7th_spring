package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.DepartmentDto;
import com.mycom.mybatis.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService service;
	
	@GetMapping("/{departmentId}")	
	@ResponseBody
	public DepartmentDto departmentDetail(@PathVariable int departmentId) {
		System.out.println("departmentId: " + departmentId);
		DepartmentDto dto = service.departmentDetail(departmentId);
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping("/detail/{departmentId}/")	
	public String departmentDetailPage(@PathVariable int departmentId, Model model) {
		System.out.println("departmentId: " + departmentId);
		DepartmentDto dto = service.departmentDetail(departmentId);
		model.addAttribute("dto", dto);
		System.out.println(dto);
		return "detail";
	}
	
	@GetMapping("/list")	
	@ResponseBody
	public List<DepartmentDto> departmentList() {
		List<DepartmentDto> list = service.departmentList();
		list.forEach((department) -> System.out.println(department));
		return list;
	}
	
	@PostMapping	
	@ResponseBody
	public int departmentInsert(DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentInsert(dto);
		return ret;
	}
	@PostMapping("/json")	
	@ResponseBody
	public int departmentInsertJSON(@RequestBody DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentInsert(dto);
		return ret;
	}
	@PatchMapping("/update")
	@ResponseBody
	public int departmentUpdate(DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentUpdate(dto);
		return ret;
	}
	
	@PostMapping("/delete")	
	@ResponseBody
	public int departmentDelete(int departmentId) {
		System.out.println(departmentId);
		int ret = service.departmentDelete(departmentId);
		return ret;
	}
}
