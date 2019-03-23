package com.webcrawler.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetailsModel {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String org;
	private String des;
	private String freq;

	public UserDetailsModel() {
		
	}
	
	public UserDetailsModel(String email, String org, String des, String freq) {
		this.email = email;
		this.org = org;
		this.des = des;
		this.freq = freq;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "UserDetailsModel [id=" + id + ", email=" + email + ", org=" + org + ", des=" + des + ", freq=" + freq
				+ "]";
	}

}
