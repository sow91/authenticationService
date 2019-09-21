package com.authenticationService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"id", "uniqueId"})
public class User {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition = "int(11) primary key auto_increment")
	private int id;
	@Column(name="unique_id", columnDefinition="varchar(36) not null unique", unique = true)
	private String uniqueId;
	@Column(columnDefinition = "varchar(50) not null")
	private String name;
	@Column(columnDefinition = "varchar(100) not null unique", unique = true)
	private String email;
	@Column(name = "encryptedPassword", columnDefinition = "varchar(80) not null")
	private String password;
	@Column(columnDefinition = "varchar(29) not null")
	private String salt;
	@Column(columnDefinition = "datetime")
	private Date createdAt;
	@Column(columnDefinition = "datetime null")
	private Date updatedAt;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
