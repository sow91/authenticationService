package com.authenticationService.model;

public class Sucessefully {

	private boolean error;
	private String uid;
	private User user;
	
	public Sucessefully() {
	}

	public Sucessefully(boolean error, String uid, User user) {
		super();
		this.error = error;
		this.uid = uid;
		this.user = user;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

