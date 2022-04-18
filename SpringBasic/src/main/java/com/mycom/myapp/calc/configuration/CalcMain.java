package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.myapp.calc.hasa.Calculator;
import com.mycom.myapp.calc.hasa.UseCalculator;

public class CalcMain {
	public static void main(String[] args) {
//		Calculator calc = new Calculator();
//		int n = calc.add(7, 3);
//		System.out.println(n);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calc = (Calculator) context.getBean("calculator");
		int n = calc.add(7, 3);
		System.out.println(n);
		context.close();
	}
}
