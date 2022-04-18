package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class UseCalculator {
	@Autowired
	@Qualifier("calc1")
	Calculator calculator;
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}
