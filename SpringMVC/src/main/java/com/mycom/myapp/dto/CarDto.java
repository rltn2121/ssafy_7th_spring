package com.mycom.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class CarDto {
	private String name;
	private int price;
	private String owner;
}
