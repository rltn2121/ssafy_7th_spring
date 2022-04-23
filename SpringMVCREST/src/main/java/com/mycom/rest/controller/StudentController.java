package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.StudentDto;

@RestController
@RequestMapping("/api/v2")
public class StudentController {

	@GetMapping("/students")
	public List<StudentDto> list(){
		List<StudentDto> list = new ArrayList<StudentDto>();
		list.add(new StudentDto(11, "홍길동", "hong@gil.com", "010-1111-1111"));
		list.add(new StudentDto(22, "박길동", "park@gil.com", "010-2222-2222"));
		list.add(new StudentDto(33, "조길동", "cho@gil.com", "010-3333-3333"));
		return list;
	}

	@GetMapping("/students/{studentId}")
	public StudentDto detail(@PathVariable int studentId){
		System.out.println("studentId: " + studentId);
		return new StudentDto(33, "조길동", "cho@gil.com", "010-3333-3333");
	}
	
	@PostMapping("/students")
	public int insert(StudentDto dto){
		System.out.println(dto);
		return 1;
	}
	
	@PutMapping("/students/{studentId}")
	public int update(@PathVariable int studentId, @RequestBody StudentDto dto){
		System.out.println("studentId: " + studentId);
		System.out.println(dto);
		return 1;
	}
	
	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable int studentId){
		System.out.println("studentId: " + studentId);
		return 1;
	}
}
