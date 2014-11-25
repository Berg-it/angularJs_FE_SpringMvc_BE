package com.howtodoinjava.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.UserDao;
import com.howtodoinjava.dto.UserAuthResponse;
import com.howtodoinjava.model.User;
import com.howtodoinjava.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public UserAuthResponse getUserDetails(String mail, String pass) {

		UserAuthResponse responseWs = new UserAuthResponse();
		
		User userResponse=userDao.getUserDetails(mail, pass);
		
		responseWs.setUser(userResponse);
		if (userResponse.getEmail().isEmpty())
			responseWs.setResponseMessage("error");
		else{
			responseWs.setUser(userResponse);
			responseWs.setResponseMessage("success");
		}
		return responseWs;
	}

}
