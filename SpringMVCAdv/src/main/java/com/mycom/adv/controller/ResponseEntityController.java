package com.mycom.adv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.adv.dto.StudentDto;

@RestController
@RequestMapping("/re")
public class ResponseEntityController {

	@GetMapping("/student")
	public ResponseEntity<List<StudentDto>> list(){
		List<StudentDto> list = new ArrayList<>();
		list.add(new StudentDto(111, "홍길동", "email@email.com", "123-1234"));
		list.add(new StudentDto(222, "이길동", "lee@email.com", "123-1234"));
		list.add(new StudentDto(333, "삼길동", "sam@email.com", "123-1234"));
//		return ResponseEntity.ok().body(list);
		return ResponseEntity.badRequest().body(list);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<StudentDto> detail(@PathVariable int studentId){
		StudentDto dto = new StudentDto(333, "삼길동", "sam@email.com", "123-1234");
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
