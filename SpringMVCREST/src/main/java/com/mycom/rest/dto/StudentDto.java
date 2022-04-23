package com.mycom.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private String phone;
}
