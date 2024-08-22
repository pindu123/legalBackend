package com.example.demo.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Pojos.Login;
import com.example.demo.Pojos.Roles;
import com.example.demo.Pojos.Users;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/Register")
	public ResponseEntity<String> AddUser(@RequestBody Users u)
	{
		 int flag=userservice.AddUser(u);
		 if(flag!=0)
		 {
			 return new ResponseEntity<>("Registration Success",HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<>("Registration failed",HttpStatus.INTERNAL_SERVER_ERROR);
 
		 }
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Map> CheckUser(@RequestBody Login l)
	{
		return userservice.validateUser(l);
	}


	
}
