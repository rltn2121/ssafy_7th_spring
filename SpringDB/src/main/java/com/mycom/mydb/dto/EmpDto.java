package com.mycom.mydb.dto;

import lombok.Data;

@Data
public class EmpDto {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;
}
