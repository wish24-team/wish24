package com.wish.Dtos.Mapper;

import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wish.Constant.RestConstant;
import com.wish.Controller.UserController;
import com.wish.Dtos.Request.UserRegistrationDto;
import com.wish.Exception.CustomException;
import com.wish.Model.User;
import com.wish.Validation.Email;
import com.wish.Validation.MobileNumber;
import com.wish.Validation.Username;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class UserRegistrationDtoMapper {
	private static final Logger logger = Logger.getLogger(UserController.class);

	public UserRegistrationDtoMapper() {
	}

	public static User toUserModel(UserRegistrationDto userRegistrationDto) {
		logger.info("toUserModel Method Called in UserRegistrationDtoMapper Line no= "
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		User user = new User();

		if (!Username.validateusername(userRegistrationDto.getUserName())) {
			logger.info("Username is not valid Line no= "
					+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			throw CustomException.throwException(RestConstant.USERNAME_NOT_VALID);
		}

		if (!MobileNumber.validatePhoneNumber(userRegistrationDto.getPhone())) {
			logger.info("Mobile Number is not valid Line no= "
					+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			throw CustomException.throwException(RestConstant.MOBILE_NO_NOT_VALID);
		}
		if (!Email.EmailValidation(userRegistrationDto.getEmail())) {
			logger.info("Email Id is not valid Line no= "
					+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			throw CustomException.throwException(RestConstant.EMAIL_NOT_VALID);
		}
		if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())) {
			logger.info("Password and confirm Password is not equal Line no= "
					+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			throw CustomException.throwException(RestConstant.PASSWORD_NOT_EQUAL);
		}
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName(userRegistrationDto.getUserName());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
		user.setEmail(userRegistrationDto.getEmail());
		user.setPhoneNumber(userRegistrationDto.getPhone());
		user.setPassword(hashedPassword);
		return user;
	}

}
