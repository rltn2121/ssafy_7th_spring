package com.mycom.adv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	/*
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// return true: 통과 
		// return false: 통과 x
		System.out.println("preHandle()");
		System.out.println(handler);
		
		// session
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		
		if("success".equals(login))
			return true;
		return false;
	}
	*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// return true: 통과 
		// return false: 통과 x
		System.out.println("preHandle()");
		System.out.println(handler);
		
		// 프론트에서 보낸 request header에 API KEY가 담겨 있는지 확인
		String apiKey = request.getHeader("API_KEY");
		if(apiKey == null || "".contentEquals(apiKey))
			return false;
		if(isApiKeyValid(apiKey))
			return true;
		return false;
	}

	private boolean isApiKeyValid(String apiKey) {
		// TODO Auto-generated method stub
		return false;
	}
}
