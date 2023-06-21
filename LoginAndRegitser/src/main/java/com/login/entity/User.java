package com.login.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Nonnull
	private String emailid;
	@Nonnull
	private String username;
	@Nonnull
	private String password;
	
	
	public User() {
		super();
	}


	public User(int id, String emailid, String username, String password) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", emailid=" + emailid + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
