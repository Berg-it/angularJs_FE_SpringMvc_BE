package com.howtodoinjava.dto;

import java.io.Serializable;

import com.howtodoinjava.model.User;

public class UserAuthResponse  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2317034994534605789L;
	
	private User 	user;
	private String  responseMessage;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
