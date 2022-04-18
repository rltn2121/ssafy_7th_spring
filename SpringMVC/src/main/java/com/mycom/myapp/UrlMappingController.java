package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 기존 서블릿과 다른 점
// 1. 기존 서블릿은 맨 앞에 / 빼면 오류 발생 -> tomcat 시작 (X)
// 2. 서브 도메인 처리가 다르다. 서블릿은 /* 1개만 가능. Spring은 /*와 /**를 구분
//	    서블릿에 /** <- 문자 또 다른 url

// 인사, 회계, 재무, 자재 등..
// Controller 단위에도 URL 지정 가능
@Controller
@RequestMapping("/insa")
public class UrlMappingController {
	@RequestMapping("/hello")
	public String m1() {
		System.out.println("/hello");
		return "home";
	}
	
	@RequestMapping("/hello/ssafy")
	public String m2() {
		System.out.println("/hello/ssafy");
		return "home";
	}
	
	@RequestMapping(value={"url1", "url2"})
	public String m3() {
		System.out.println("/url1 /url2");
		return "home";
	}
	
	// select 목록조회, 상세조회
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public String m4() {
		System.out.println("/get");
		return "home";
	}
	// insert 등록
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public String m5() {
		System.out.println("/post");
		return "home";
	}
	// update 수정
	@RequestMapping(value="/method/{num}", method=RequestMethod.PUT)
	public String m6(@PathVariable int num) {
		System.out.println(num);
		return "home";
	}
	
	@RequestMapping(value="/method/{num}/and/{str}", method=RequestMethod.PUT)
	public String m7(@PathVariable int num, @PathVariable String str) {
		System.out.println(num);
		System.out.println(str);
		return "home";
	}
	
	@RequestMapping(value="/method/{num}", method=RequestMethod.DELETE)
	public String m8(@PathVariable int num) {
		System.out.println("/delete");
		System.out.println(num);
		return "home";
	}
	
	@GetMapping("/getmapping")
	public String m9() {
		System.out.println("/getMapping");
		return "home";
	}
	
	@PostMapping("/postmapping")
	public String m10() {
		System.out.println("/PostMapping");
		return "home";
	}
	
	// sub url
	// 하위의 하위 url은 불가능
	@GetMapping("/subtest/*")
	public void m11() {
		System.out.println("/subtest/*");
	}
	
	// 하위의 하위 url도 가능
	@GetMapping("/subtest/**")
	public void m12() {
		System.out.println("/subtest/**");
	}
}
