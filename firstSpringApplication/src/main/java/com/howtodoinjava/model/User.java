package com.howtodoinjava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7562781209722147220L;
	
	/*
	@Id
    @JoinColumn(name = "categoria") 
	@GeneratedValue
	private Integer id;
	*/
	
	@Id
	@Column(name="mail")
	private String email;
	
	
	@Column(name="password")
	private String pass;
	
	@Column(name="firstname")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
/*
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	
	
	
	
}