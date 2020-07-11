package com.wish.Dtos.Request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class LoginDto {

	@NotNull(message="UserName Can Not be Null!")
	@NotEmpty(message="UserName Can Not be Empty!")
	private String UserName;
	
	@NotNull(message="Password Can Not be Null!")
	@NotEmpty(message="User Password Can Not be Empty!")
	private String Password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public LoginDto setUserName(String userName) {
		UserName = userName;
		return this;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public LoginDto setPassword(String password) {
		Password = password;
		return this;
	}
	@Override
	public String toString() {
		return "LoginDto [UserName=" + UserName + ", Password=" + Password + "]";
	}
	
	
}
