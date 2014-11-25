package com.howtodoinjava.model;

import javax.persistence.Column;

public class MyCompositePK {
	
	private Integer id;
	
	@Column(name="mail")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
