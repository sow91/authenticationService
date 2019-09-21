package com.authenticationService.helper;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Helper {

	public static String generateRandom() {
		String unique = UUID.randomUUID().toString();
		return unique;
	}

	public static String generateSalt() {
		String salt = (String) BCrypt.gensalt(12);
		return salt;
	}

	public static String hashPassword(String password, String salt) {
		String pw_hash = BCrypt.hashpw(password, salt);
		return pw_hash;
	}

	public static String encodePassword(String pw_hash) throws UnsupportedEncodingException {
		String encrypted = Base64.getEncoder().encodeToString(pw_hash.getBytes("utf-8"));
		return encrypted;
	}

	public static boolean checkPassword(String passwordPlain, String salt, String passwordEncrypted) {
		String pw_hash = Helper.hashPassword(passwordPlain, salt);

		String encrypted = null;
		try {
			encrypted = Helper.encodePassword(pw_hash);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (encrypted.equals(passwordEncrypted)) {
			return true;
		}
		return false;
	}
}
