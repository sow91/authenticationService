package com.authenticationService.model;

import java.util.List;

public class UserList {

	private List<User> listUsers;
	
	public UserList() {
		// TODO Auto-generated constructor stub
	}

	public UserList(List<User> listUsers) {
		super();
		this.listUsers = listUsers;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	
	
	
}
