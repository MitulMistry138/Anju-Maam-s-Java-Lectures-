package com.student.model;

import com.student.entity.Address;

import lombok.Data;


@Data
public class StudentDTO {
	
	private int id;
	private String studentName;
	private long phone;
	private String email;

	private Address address;
}
