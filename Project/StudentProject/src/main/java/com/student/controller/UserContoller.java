package com.student.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.User;
import com.student.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String validate(@RequestBody User  user) throws ServletException {
	
		String jwtToken="";
		
		if(user.getUserName()==null || user.getUserPassword()==null ||user.getUserRole()==null)
		{
			throw new ServletException("Cannot find user name and password and role");
		}
		
		String userName=user.getUserName();
		String password=user.getUserPassword();
		user= userService.Login(userName, password);
	
		if(user==null)
		{
			throw new ServletException("user details not found ");
		}
		
		jwtToken=Jwts.builder().setSubject(userName).claim("roles",user.getUserRole()).
				setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		return jwtToken;
	
	}

}
