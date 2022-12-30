package com.student.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.student.entity.User;
import com.student.model.UserDTO;

@Component
public class UserConverter {

	// convert AddressDto to Entity
	public User convertUserEntity(UserDTO userDto) {
		User user = new User();
		if (userDto != null) {
			BeanUtils.copyProperties(userDto, user);
		}
		return user;
	}

	// convert Adrees entity to AddressDto
	public UserDTO convertToUserDto(User user) {
		UserDTO userDto = new UserDTO();
		if (user != null) {
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}
}

