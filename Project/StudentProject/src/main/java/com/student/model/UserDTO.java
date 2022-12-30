package com.student.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {

	@NotNull
	private int id;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String userPassword;
	
	@NotNull
	private String userRole;
}
