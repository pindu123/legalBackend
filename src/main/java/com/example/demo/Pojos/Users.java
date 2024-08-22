package com.example.demo.Pojos;

import java.sql.Date;

public class Users {
	private int userid;
	private String first_name;
	private String last_name;
	private String middle_name;
	private Date dob;	
	private String email;
	private String  gender;
	private String city;
	private String district;
	private String state;
	private int role_id	;
	private String contact_no;
	
	private int lawyer_id;
	private String college	;
	private String degree;
	private int experience	;
	private int no_of_cases_dealt;
	private String law_categories;
	private String username;
	private String paswd;
	private String approval;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaswd() {
		return paswd;
	}
	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	private int client_id;
	private int active_cases;
	private String occupation;
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getActive_cases() {
		return active_cases;
	}
	public void setActive_cases(int active_cases) {
		this.active_cases = active_cases;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	public int getLawyer_id() {
		return lawyer_id;
	}
	public void setLawyer_id(int lawyer_id) {
		this.lawyer_id = lawyer_id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getNo_of_cases_dealt() {
		return no_of_cases_dealt;
	}
	public void setNo_of_cases_dealt(int no_of_cases_dealt) {
		this.no_of_cases_dealt = no_of_cases_dealt;
	}
	public String getLaw_categories() {
		return law_categories;
	}
	public void setLaw_categories(String law_categories) {
		this.law_categories = law_categories;
	}
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	
}
