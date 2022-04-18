package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("calc2")
public class CalculatorImpl2 implements Calculator{
	@Override
	public int add(int a, int b) {
		return a+b;
	}
}
