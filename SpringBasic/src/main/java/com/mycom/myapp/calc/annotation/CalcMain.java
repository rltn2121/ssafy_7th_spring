package com.mycom.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
//		Calculator calc = new Calculator();
//		int n = calc.add(7, 3);
//		System.out.println(n);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml");
		Calculator calc = (Calculator) context.getBean("calculator");
		int n = calc.add(7, 3);
		System.out.println(n);
		context.close();
	}
}
