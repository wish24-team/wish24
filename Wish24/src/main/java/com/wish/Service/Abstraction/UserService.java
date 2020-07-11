package com.wish.Service.Abstraction;

import com.wish.Dtos.Request.LoginDto;
import com.wish.Dtos.Request.UserRegistrationDto;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public interface UserService {

	boolean userRegistration(UserRegistrationDto userRegistrationDto);

	boolean loginUser(LoginDto loginDto);

}
