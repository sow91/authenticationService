package com.authenticationService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authenticationService.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User findByUniqueId(String uniqueId);
	
}
