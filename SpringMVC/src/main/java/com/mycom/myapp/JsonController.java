package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {
	@PostMapping("/emp")
	public void m1(@RequestBody EmpDto dto) {
		System.out.println(dto);
	}
	
	@PostMapping("/empList")
	public void m2(@RequestBody List<EmpDto> empList) {
		empList.forEach((emp) -> System.out.println(emp));
	}
	
	@GetMapping("/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto dto = new EmpDto(2000, "길동", "조", "gildong5@gildong.com", "2000-04-16");
		
		// @ResponseBody 붙이면
		// 객체를 gson을 이용하여 json으로 변환해줄 필요 없음
		return dto;
	}
	
	@GetMapping("/empList")
	@ResponseBody
	public List<EmpDto> m4() {
		List<EmpDto> list = new ArrayList<>();
		
		list.add( new EmpDto(2000, "길동", "조", "gildong5@gildong.com", "2000-04-16") );
		list.add( new EmpDto(2000, "길동", "박", "gildong5@gildong.com", "2000-11-11") );
		list.add( new EmpDto(2000, "길동", "김", "gildong5@gildong.com", "2000-04-15") );
		
		// @ResponseBody 붙이면
		// 객체를 gson을 이용하여 json으로 변환해줄 필요 없음
		return list;
	}
	
	@GetMapping("/LocalDateTime")
	@ResponseBody
	public LocalDateTime m5() {
		return LocalDateTime.now();
	}
}
