package com.student.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminDTO extends UserDTO{

	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
}
