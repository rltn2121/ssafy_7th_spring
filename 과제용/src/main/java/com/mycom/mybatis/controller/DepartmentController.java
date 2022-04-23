package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.mybatis.dto.DepartmentDto;
import com.mycom.mybatis.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService service;
	
	@GetMapping("/{departmentId}")	
	public DepartmentDto departmentDetail(@PathVariable int departmentId) {
		System.out.println("departmentId: " + departmentId);
		DepartmentDto dto = service.departmentDetail(departmentId);
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping("/detail/{departmentId}")	
	public ModelAndView departmentDetailPage(@PathVariable int departmentId, Model model) {
		System.out.println("departmentId: " + departmentId);
		DepartmentDto dto = service.departmentDetail(departmentId);
		ModelAndView mav = new ModelAndView("detail");
		mav.addObject("dto", dto);
		System.out.println(dto);
		return mav;
	}
	
	@GetMapping("/list")	
	public List<DepartmentDto> departmentList() {
		List<DepartmentDto> list = service.departmentList();
		list.forEach((department) -> System.out.println(department));
		return list;
	}
	
	@PostMapping	
	public int departmentInsert(DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentInsert(dto);
		return ret;
	}
	@PostMapping("/json")	
	public int departmentInsertJSON(@RequestBody DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentInsert(dto);
		return ret;
	}
	@PutMapping
	public int departmentUpdate(@RequestBody DepartmentDto dto) {
		System.out.println(dto);
		int ret = service.departmentUpdate(dto);
		return ret;
	}
	
	@DeleteMapping
	public int departmentDelete(int departmentId) {
		System.out.println(departmentId);
		int ret = service.departmentDelete(departmentId);
		return ret;
	}
}
