package com.howtodoinjava.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Presence.verifIfConnected",
			query = "SELECT p FROM Presence p WHERE ((p.userLocale = :user) and (p.entrydate = :entrydate)) "),
    @NamedQuery(name="Presence.verifIfConnected.andGetList",
			query = "SELECT p FROM Presence p WHERE ((p.userLocale = :user)) "),
    @NamedQuery(name="Presence.exit.user",
			query = "UPDATE Presence  p SET p.exitdate =:exitdate, p.exittime =:exittime, p.total =:total " +
					" WHERE ((p.userLocale = :user) and (p.entrydate = :entrydate) ) ")				
})

 
public class Presence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6089295284708640396L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String mail;
	private Date entrydate;
	private String entrytime;
	private Date exitdate;
	private String exittime;
	private String total;
	private String comment;
	private String state;
	
	@ManyToOne
	@JoinColumn (name="idPU")
    private User userLocale ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getExitdate() {
		return exitdate;
	}

	public void setExitdate(Date exitdate) {
		this.exitdate = exitdate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUserLocale() {
		return userLocale;
	}

	public void setUserLocale(User user) {
		this.userLocale = user;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getExittime() {
		return exittime;
	}

	public void setExittime(String exittime) {
		this.exittime = exittime;
	}
	
	
	
}
