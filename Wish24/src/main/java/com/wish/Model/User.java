package com.wish.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
@Entity(name="user")
public class User {
	
	@Id
	@Column(name="user_id",nullable = false,unique = true)
	private String userId;
	
	@Column(name="username",nullable = false)
	private String userName;
	
	@Column(name="phone_number",unique = true)
	private String phoneNumber;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public User setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public User setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + "]";
	}



}
