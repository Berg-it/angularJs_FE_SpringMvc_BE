package com.howtodoinjava.dto;

import java.util.Date;
import java.util.List;

import com.howtodoinjava.model.Presence;

public class VerifyUserPresenceEntryResponseDTO {
	
	private String messageResponse ;
	
	private List<Presence> result;
	
	public List<Presence> getResult() {
		return result;
	}
	public void setResult(List<Presence> result) {
		this.result = result;
	}
	
	public String getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

}
