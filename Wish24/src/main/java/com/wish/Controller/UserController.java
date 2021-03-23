package com.wish.Controller;


import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wish.Constant.RestConstant;
import com.wish.Dtos.Request.LoginDto;
import com.wish.Dtos.Request.UserRegistrationDto;
import com.wish.Exception.CustomException;
import com.wish.Service.Abstraction.UserService;
import com.wish.Utils.Response;
import com.wish.Utils.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
@Api(value = "Wish24 User Management Controller", tags = "Wish24 User Management Controller")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(RestConstant.WISH24_USER_HOME)
public class UserController {
	private final Logger logger = Logger.getLogger(UserController.class);
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value = "User Registration ")
    @PostMapping({RestConstant.V1 + RestConstant.REGISTRATION_USER})
	public ResponseEntity<Response> userRegistration(@Valid @RequestBody UserRegistrationDto userRegistrationDto, Errors error){
		logger.info("userRegistration Method Called in UserController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfRegistration= userService.userRegistration(userRegistrationDto);
		if(statusOfRegistration) {
			logger.info("Successfully Register Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.REGISTRATION_SUCCESS)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess Register Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.REGISTRATION_FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Login User")
    @PostMapping({RestConstant.V1 + RestConstant.LOGIN_USER})
	public ResponseEntity<Response> loginUser(@Valid @RequestBody LoginDto loginDto, Errors error){
		logger.info("loginUser Method Called in UserController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfRegistration= userService.loginUser(loginDto);
		if(statusOfRegistration) {
			logger.info("Successfully Login Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.LOGIN_SUCCESS)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess Login Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.LOGIN_FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
}
