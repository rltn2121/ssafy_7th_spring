package com.mycom.adv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private String phone;
	
	public boolean equals(Object obj) {
		if(obj != null) {
			StudentDto dto = (StudentDto)obj;
			if(this.studentId == dto.studentId && this.getEmail() != null
					&& dto.getEmail() != null && dto.getEmail().contentEquals(this.email))
				return true;
			return false;
		}
		return false;
	}
}
