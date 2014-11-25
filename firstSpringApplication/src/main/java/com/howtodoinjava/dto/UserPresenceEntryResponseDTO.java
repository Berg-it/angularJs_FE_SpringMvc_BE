package com.howtodoinjava.dto;

import java.io.Serializable;

public class UserPresenceEntryResponseDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5411782007254171346L;
	private String dateEntry ;
	private String timeEntry ;
	
	public String getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(String dateEntry) {
		this.dateEntry = dateEntry;
	}
	public String getTimeEntry() {
		return timeEntry;
	}
	public void setTimeEntry(String timeEntry) {
		this.timeEntry = timeEntry;
	}
	
	
}
