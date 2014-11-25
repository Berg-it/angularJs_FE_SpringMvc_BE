package com.howtodoinjava.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howtodoinjava.dto.UserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.UserPresenceEntryResponseDTO;
import com.howtodoinjava.dto.UserPresenceExitRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryResponseDTO;
import com.howtodoinjava.model.User;
import com.howtodoinjava.service.PresenceService;

@Controller
@RequestMapping("/presence")
public class PresenceUserController {

		@Autowired
		PresenceService presenceService;
		
		@RequestMapping(value="/addUserEntry")
		public @ResponseBody UserPresenceEntryResponseDTO entryUser(HttpServletResponse response,@RequestParam(value="userMail") String userMail) 
		{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");// seconds to cache preflight request --> less OPTIONS traffic
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		UserPresenceEntryRequestDTO dto = new UserPresenceEntryRequestDTO();
		User 	user =  new User();
		user.setEmail(userMail);
		dto.setMail(userMail);
		dto.setEntrydate(new Date());
		dto.setUser(user);
		
		UserPresenceEntryResponseDTO responseDto = new UserPresenceEntryResponseDTO();
		responseDto = presenceService.addPresenceUser(dto);
		return responseDto;
		}
		

		@RequestMapping(value="/verifUserEntry")
		public @ResponseBody VerifyUserPresenceEntryResponseDTO verifEntryUser(HttpServletResponse response,
						@RequestParam("userMail")String userMail	)
		{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");// seconds to cache preflight request --> less OPTIONS traffic
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		VerifyUserPresenceEntryRequestDTO dto = new VerifyUserPresenceEntryRequestDTO();
		dto.setMail(userMail);
		VerifyUserPresenceEntryResponseDTO responseDto =presenceService.verifPresenceUser(dto);
		
		return responseDto;
		}
		
		@RequestMapping(value="/UserExit")
		public @ResponseBody void UserExit(HttpServletResponse response,
						@RequestParam("userMail")String userMail,
						@RequestParam("entryTime")String entryTime,
						@RequestParam("entryDate")String entryDate	)
		{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");// seconds to cache preflight request --> less OPTIONS traffic
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		UserPresenceExitRequestDTO dto = new UserPresenceExitRequestDTO();
		dto.setUserMail(userMail);
		dto.setEntryTime(entryTime);
		dto.setEntrydate(entryDate);
		presenceService.exitPresenceUser(dto);
		
		}		
		
}
