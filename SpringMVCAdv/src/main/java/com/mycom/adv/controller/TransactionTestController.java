package com.mycom.adv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.adv.dto.StudentDto;
import com.mycom.adv.service.StudentService;

@RestController
@RequestMapping("/tx")
public class TransactionTestController {

	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	public ResponseEntity<Integer> studentInsert(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto);
		int ret = service.studentInsert(studentDto);
		return new ResponseEntity<Integer>(ret, HttpStatus.OK);
	}
}
