package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("calc1")
public class CalculatorImpl implements Calculator{
	@Override
	public int add(int a, int b) {
		return a+b;
	}
}
