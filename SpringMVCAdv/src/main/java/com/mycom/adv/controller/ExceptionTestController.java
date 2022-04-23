package com.mycom.adv.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionTestController {
	@GetMapping("/exception")
	public void makeException() throws Exception {
		System.out.println("/exception");
		throw new RuntimeException();
	}
	
	// MVC 모델에서는 예외 처리를 적극적으로!
	// 예외 발생 시 사용자에게 공지
	// JSP로 분기 (ERROR 페이지)
	//@ExceptionHandler({SQLException.class, IOException.class})
	public String handler(HttpServletRequest request, Model model) {
		System.out.println("ExceptionHandler");
		
		// 추가적인 정보 전달
		StringBuffer url = request.getRequestURL();
		model.addAttribute("url",url);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handler2(HttpServletRequest request, Model model){
		Map<String, String> map = new HashMap<>();
		map.put("result", "ajax_exception");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
}
