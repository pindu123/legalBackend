package com.example.demo.Services;


import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration; 


import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Pojos.Login;
import com.example.demo.Pojos.Roles;
import com.example.demo.Pojos.Users;
 

@Service
public class UserService {
@Autowired
JdbcTemplate jdbctemplate;

public static String GetMacId() {
	try {
	Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
	if (networkInterfaces == null) {
	System.out.println("No network interfaces found.");
	return null;
	}
	StringBuilder macAddress = new StringBuilder();
	for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
		if (networkInterface.isLoopback() || !networkInterface.isUp()) {
			continue;
		}
	byte[] macBytes = networkInterface.getHardwareAddress();
	if (macBytes == null) {
	continue;
	}

	if(macAddress.isEmpty())
	{
	for (int i = 0; i < macBytes.length; i++) {
	macAddress.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
      }
	}
	System.out.println("MAC Address1: " + macAddress.toString());
	}
	return macAddress.toString();

	} catch (SocketException e) {
		return e.getMessage();

	}
	
}

@SuppressWarnings("deprecation")
public int AddUser(Users user)
{
	

int j=0;
String firstName=user.getFirst_name();
String lastName=user.getLast_name();
String dateOfBirth=user.getDob().toString();
String pswd=firstName.substring(firstName.length()-2,firstName.length()-1).toUpperCase()+firstName.substring(firstName.length()-1)+"#"+lastName.substring(lastName.length()-2)+dateOfBirth.substring(0,4);   
 
String Uname=user.getFirst_name()+dateOfBirth.substring(5,7)+dateOfBirth.substring(8);

//String s3="insert into login(email,username,passwrd) values(?,?,?)";
//
//int k=jdbctemplate.update(s3,user.getEmail(),Uname,pswd);
String userQuery="Insert into users(first_name,last_name,middle_name,dob,email,gender,city,district,state,role_id,contact_no,username,passwrd) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

int userResult=jdbctemplate.update(userQuery,user.getFirst_name(),user.getLast_name(),user.getMiddle_name(),user.getDob(),user.getEmail(),user.getGender(),user.getCity(),user.getDistrict(),user.getState(),user.getRole_id(),user.getContact_no(),Uname,pswd);
 
    if(userResult!=0)
     {
	    System.out.println("Hello");
 
        String rolesQuery="select roleName from roles where role_id=?";
 
	 
	     String roleName;
         try {
        	 	roleName = jdbctemplate.queryForObject(rolesQuery, new Object[]{user.getRole_id()}, String.class);
         	} catch (EmptyResultDataAccessException e) {
         // Handle the case where the role_id does not exist
         		throw new IllegalArgumentException("Role ID not found: " + user.getRole_id(), e);
         	}
         	System.out.println(roleName);
         	if(roleName.equals("lawyer"))
         	{
         		System.out.println("hello");
         		String lawyerQuery="insert into lawyers(college,degree,experience,no_of_cases_dealt,law_categories) values(?,?,?,?,?)";
         		j =jdbctemplate.update(lawyerQuery,user.getCollege(),user.getDegree(),user.getExperience(),user.getNo_of_cases_dealt(),user.getLaw_categories());
 }
 else if(roleName.equals("client"))
 {
	 String s2="insert into clients(active_cases,occupation) values(?,?)";
	 j=jdbctemplate.update(s2,user.getActive_cases(),user.getOccupation());
	 
 }
}
 return j;
}

public ResponseEntity<Map> validateUser(Login login)
{
	LinkedHashMap hm=new LinkedHashMap();
	try
	{
	String s="Select * from users where username=? and passwrd=?";
	Map<String, Object> loginDetails=jdbctemplate.queryForMap(s,login.getUsername(),login.getPasswrd());
	 System.out.println(loginDetails);
	if(!loginDetails.isEmpty())
	{
		String mail=(String)loginDetails.get("email");
		String roleNameQuery="select roleName from roles where role_id=?";
		Map<String,Object> roleDetails=jdbctemplate.queryForMap(roleNameQuery,loginDetails.get("role_id"));
		String loginQuery="Insert into login(email,username,passwrd,mac_id) values(?,?,?,?)";
		jdbctemplate.update(loginQuery,mail,login.getUsername(),login.getPasswrd(),GetMacId());
	hm.put("Success","Login Successful");	
	hm.put("mail",loginDetails.get("email"));
	hm.put("token",loginDetails.get("jwt"));
	hm.put("role",roleDetails.get("roleName"));
	hm.put("mac-id", GetMacId());
	return  new ResponseEntity<>(hm,HttpStatus.OK);
	}
	else
	{
	 hm.put("fail", "Login Failed");
	  return new ResponseEntity<>(hm,HttpStatus.BAD_REQUEST);
	}
	}
	catch (Exception e)
	{
		 hm.put("fail", "Login Failed");
		 return new ResponseEntity<>(hm,HttpStatus.BAD_REQUEST); 
	}
}

}
 