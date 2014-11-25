package com.howtodoinjava.service;

import com.howtodoinjava.dto.UserAuthResponse;


public interface UserService {
	
	public UserAuthResponse getUserDetails(String mail,String pass );

}
