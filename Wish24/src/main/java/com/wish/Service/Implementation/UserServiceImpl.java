package com.wish.Service.Implementation;

import java.util.Objects;

import org.jboss.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wish.Constant.RestConstant;
import com.wish.Dtos.Mapper.UserRegistrationDtoMapper;
import com.wish.Dtos.Request.LoginDto;
import com.wish.Dtos.Request.UserRegistrationDto;
import com.wish.Exception.CustomException;
import com.wish.Model.User;
import com.wish.Repository.UserRepository;
import com.wish.Service.Abstraction.UserService;
/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
@Service
public class UserServiceImpl implements UserService {
	private final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public boolean userRegistration(UserRegistrationDto userRegistrationDto) {
		logger.info("userRegistration Method Called in UserServiceImpl Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		userRepository.save(UserRegistrationDtoMapper.toUserModel(userRegistrationDto));
		return true;

	}


	@Override
	public boolean loginUser(LoginDto loginDto) {
		logger.info("loginUser Method Called in UserServiceImpl Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		User mobileUser=new User();
		User emailUser=new User();
		mobileUser=userRepository.findByPhoneNumber(loginDto.getUserName());
		emailUser=userRepository.findByEmail(loginDto.getUserName());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		

		if(Objects.isNull(mobileUser)&&Objects.isNull(emailUser)) {
			logger.info("User is not valid Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			throw CustomException.throwException(RestConstant.CREDENTIAL_NOT_VALID);
		}
		if(Objects.nonNull(mobileUser)) {
			if(!passwordEncoder.matches(loginDto.getPassword(), mobileUser.getPassword())) {
				logger.info("Password is not valid Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
				throw CustomException.throwException(RestConstant.CREDENTIAL_NOT_VALID);
			}
			return true;

		}
		if(Objects.nonNull(emailUser)) {
			
			if(!passwordEncoder.matches(loginDto.getPassword(), emailUser.getPassword())) {
				logger.info("Password is not valid Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
				throw CustomException.throwException(RestConstant.CREDENTIAL_NOT_VALID);
			}
			return true;
		}
		return false;
	}

}
