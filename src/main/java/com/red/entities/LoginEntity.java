package com.red.entities;

public class LoginEntity {
	
	private String response, userEmail, userCompleteName;
	private int status, userId;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserCompleteName() {
		return userCompleteName;
	}
	public void setUserCompleteName(String userCompleteName) {
		this.userCompleteName = userCompleteName;
	}
	
	
}
