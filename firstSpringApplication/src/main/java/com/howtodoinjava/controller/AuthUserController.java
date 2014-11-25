package com.howtodoinjava.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howtodoinjava.dto.UserAuthResponse;
import com.howtodoinjava.model.User;
import com.howtodoinjava.service.UserService;


@Controller
@RequestMapping("/users")
public class AuthUserController 
{
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/authUser")
	public @ResponseBody UserAuthResponse authUser(HttpServletResponse response,@RequestParam("mail") String mail,
													@RequestParam("pass") String pass) 
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");// seconds to cache preflight request --> less OPTIONS traffic
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        UserAuthResponse responseWs = userService.getUserDetails(mail,pass);
		
		return responseWs;
	}	

	
	@RequestMapping(value="/userConnectEntry")
	public @ResponseBody User userEnter(HttpServletResponse response,@RequestParam(value="userId") String userId) 
	{
		System.out.println("foofoofoo "+userId);
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");// seconds to cache preflight request --> less OPTIONS traffic
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
       // UserAuthResponse responseWs = userService.getUserDetails(mail,pass);
		
        User user = new User();
        
        user.setLastname("AMINE");
        user.setName("Brg");
		return user;
	}		
}
