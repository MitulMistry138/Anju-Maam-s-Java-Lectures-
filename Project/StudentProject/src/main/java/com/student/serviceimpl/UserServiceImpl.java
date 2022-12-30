package com.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.User;
import com.student.repository.UserRepository;
import com.student.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User Login(String name, String password) {
	 User user= userRepository.findByUserNameAndUserPassword(name, password);
		return user;
	}

}
