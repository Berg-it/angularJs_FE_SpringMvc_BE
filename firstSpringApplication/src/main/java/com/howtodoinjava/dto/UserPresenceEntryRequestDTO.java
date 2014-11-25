package com.howtodoinjava.dto;

import java.util.Date;
import com.howtodoinjava.model.User;

public class UserPresenceEntryRequestDTO {
	
	private String 	mail;
	private Date 	entrydate;
    private User 	user ;
    private String 	timeEntry;
    
    
    
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTimeEntry() {
		return timeEntry;
	}
	public void setTimeEntry(String timeEntry) {
		this.timeEntry = timeEntry;
	}
    

}
