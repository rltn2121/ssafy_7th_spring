package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {
	
	@GetMapping("/viewTest1")
	public String viewTest1() {
		return "viewTest1";
	}
	
	@GetMapping("/viewTest2")
	public String viewTest2() {
		return "sub/viewTest2";
	}
	
	// Controller <-> service
	// data : jsp로 보내줄 데이터가 존재
	@GetMapping("/viewTest3")
	public String viewTest3(Model model) {
		model.addAttribute("seq", "12345");
		model.addAttribute("empDto", new EmpDto(1600, "박", "기수", "rltn2121@naver.com", "1997-11-11"));
		return "viewTest3";
	}
}
