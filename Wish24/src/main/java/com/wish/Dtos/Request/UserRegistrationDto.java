package com.wish.Dtos.Request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class UserRegistrationDto {
	
	@NotNull(message="UserName Can Not be Null!")
	@NotEmpty(message="UserName Can Not be Empty!")
	private String UserName;
	
	@NotNull(message="Password Can Not be Null!")
	@NotEmpty(message="Password Can Not be Empty!")
	private String Password;
	
	@NotNull(message="ConfirmPassword Can Not be Null!")
	@NotEmpty(message="ConfirmPassword Can Not be Empty!")
	private String ConfirmPassword;
	
	@NotNull(message="phone Can Not be Null!")
	@NotEmpty(message="phone Can Not be Empty!")
	private String phone;
	
	@NotNull(message="Email Can Not be Null!")
	@NotEmpty(message="Email Can Not be Empty!")
	private String email;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public UserRegistrationDto setUserName(String userName) {
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
	public UserRegistrationDto setPassword(String password) {
		Password = password;
		return this;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public UserRegistrationDto setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
		return this;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public UserRegistrationDto setPhone(String phone) {
		this.phone = phone;
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
	public UserRegistrationDto setEmail(String email) {
		this.email = email;
		return this;
	}
	@Override
	public String toString() {
		return "UserRegistrationDto [UserName=" + UserName + ", Password=" + Password + ", ConfirmPassword="
				+ ConfirmPassword + ", phone=" + phone + ", email=" + email + "]";
	}
	

}
