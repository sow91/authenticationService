package com.authenticationService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authenticationService.dao.UserDao;
import com.authenticationService.helper.Helper;
import com.authenticationService.model.JSONError;
import com.authenticationService.model.Sucessefully;
import com.authenticationService.model.User;

@RestController
public class LoginController {

	@Autowired
	private UserDao userDao;

	@PostMapping(value = "/login", consumes = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user) {
		User u = userDao.findByEmail(user.getEmail());
		
		if (u != null) {
			String passwordPlain = user.getPassword();
			String passwordEncrypted = u.getPassword();
			String salt = u.getSalt();
			
			boolean isTrue = Helper.checkPassword(passwordPlain, salt, passwordEncrypted);
			
			if (isTrue) {
				Sucessefully logsucess = new Sucessefully(false, u.getUniqueId(), u);
				return new ResponseEntity<Object>(logsucess, HttpStatus.OK);
			}

			JSONError logerror = new JSONError("login", 0, 1, "Login credentials are incorrect. Please try again!");
			return new ResponseEntity<Object>(logerror, HttpStatus.OK);
		}
		
		JSONError logerror = new JSONError("login", 0, 1, "Email does not exist!");
		return new ResponseEntity<Object>(logerror, HttpStatus.OK);
	}
}
