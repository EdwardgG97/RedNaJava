package com.red.entities;

public class ClientEntity {
	
	//FIELDS
	public static final String ID = "ID_CLIENT";
	public static final String TELEPHONE = "TELEPHONE";
	public static final String COMPLETE_NAME = "COMPLETE_NAME";
	public static final String EMAIL = "EMAIL";
	public static final String PASSWORD = "PASS";
	public static final String ROLE = "ROLE";
	
	private int id, telephone;
	private String completeName, email, pass, role;
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCompleteName() {
		return completeName;
	}
	
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}	
	
	public int getTelephone() {
		return telephone;
	}
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
}
