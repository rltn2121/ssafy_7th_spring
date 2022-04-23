package com.mycom.adv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorTestController {
	
	@GetMapping("/login")
	public String login() {
		System.out.println("/login");
		return "/login";
	}
	
	
	// 세션에 login:success를 담는다
	@GetMapping("/login/ok")
	public String loginOk(HttpServletRequest request) {
		System.out.println("/login/ok");
		HttpSession session = request.getSession();
		session.setAttribute("login", "success");
		return "/login/ok";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("/logout");
		HttpSession session = request.getSession();
		session.invalidate();
		return "/logout";
	}
	
	@GetMapping("/users")
	public String users() {
		System.out.println("/users");
		return "/users";
	}
}
