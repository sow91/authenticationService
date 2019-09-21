package com.authenticationService.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authenticationService.dao.UserDao;
import com.authenticationService.helper.Helper;
import com.authenticationService.model.JSONError;
import com.authenticationService.model.Sucessefully;
import com.authenticationService.model.User;
import com.authenticationService.model.UserList;

@RestController
public class RegisterController {

	@Autowired
	UserDao userDao;

	@GetMapping(value = "register/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		return userDao.findById(id);

	}

	@GetMapping(value = "/register/users")
	public ResponseEntity<UserList> listUsers() {
		List<User> users = userDao.findAll();
		UserList usersList = new UserList(users);
		return new ResponseEntity<UserList>(usersList, HttpStatus.OK);
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		String uniqueId = Helper.generateRandom();
		String salt = Helper.generateSalt();
		String pw_hash = Helper.hashPassword(user.getPassword(), salt);
		String encrypted_pw = null;
		try {
			encrypted_pw = Helper.encodePassword(pw_hash);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User u1 = userDao.findByEmail(user.getEmail());

		if (u1 == null) {
			user.setCreatedAt(new Date());
			user.setUniqueId(uniqueId);
			user.setSalt(salt);
			user.setPassword(encrypted_pw);
			Sucessefully regsucess = new Sucessefully(false, uniqueId, user);
			User storedUser = userDao.save(user);
			if (storedUser != null) {

				return new ResponseEntity<Object>(regsucess, HttpStatus.OK);
			} else {
				JSONError regerror = new JSONError(1, "Unknown error occurred in registration!" );
				return new ResponseEntity<Object>(regerror, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

		JSONError regerror = new JSONError(2, "User already existed with " + u1.getEmail());
		return new ResponseEntity<Object>(regerror, HttpStatus.CONFLICT);

	}

}