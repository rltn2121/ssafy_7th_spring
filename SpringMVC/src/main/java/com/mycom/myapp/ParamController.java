package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {

	// Query Parameter 받아오기
	@GetMapping("/param1")
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		System.out.println("/param1 seq : " + seq);
	}
	
	// Frontend에서 전달하는 parameter의 이름이 동일하면
	// request에서 바다서 getParameter() 할 필요 없이
	// 바로 String으로 받을 수 잇음
	@GetMapping("/param2")
	public void m2(String seq) {
		System.out.println("/param2 seq : " + seq);
	}
	
	// 좀 더 엄격하게 처리
	// 이름이 매칭되지 않으면 오류 발생시키기
	// required = false -> 필수 파라미터 아님.
	// 없으면 그냥 null로 처리
	@GetMapping("/param3")
	public void m3(@RequestParam(name="seqq",required=false) String seq) {
		System.out.println("/param3 seq : " + seq);
	}
	
	@GetMapping("/car1")
	public void m4(String name, int price) {
		System.out.println("name: " + name);
		System.out.println("price: " + price);
	}
	
	// dto로 바로 받을 수 있음
	@GetMapping("/car2")
	public void m5(CarDto dto) {
		System.out.println(dto);
	}	
	// dto로 바로 받을 수 있음
//	@GetMapping("/car2")
//	public void m11(CarDto dto) {
//		System.out.println(dto);
//	}
	
	// key, value 쌍을 둘 다 활용하는 경우
	// Map<>은 @RequestParam 필요함
	@GetMapping("/map")
	public void m6(@RequestParam Map<String, String> map) {
		System.out.println(map.get("name"));
		System.out.println(map.get("price"));
		System.out.println(map.get("owner"));
	}
	
	
	// @RequestHeader() 안에 value= 넣어도 되고 빼도 됨
	@GetMapping("/header")
	public void m7(
			@RequestHeader("Accept") String accept, 
			@RequestHeader("Host") String host) {
		System.out.println(accept);
		System.out.println(host);
	}
	
	@GetMapping("/session")
	public String m8(String msg, HttpSession session) {
		System.out.println(msg);
		session.setAttribute("msg", msg);
		return "sessionTest";
	}
}

