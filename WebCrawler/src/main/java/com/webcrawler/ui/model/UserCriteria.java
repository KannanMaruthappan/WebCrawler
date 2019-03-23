package com.webcrawler.ui.model;

import org.hibernate.validator.constraints.NotBlank;

public class UserCriteria {

	@NotBlank(message = "email can't be empty!")
	String email;
	String org;
	String des;
	String freq;

	public UserCriteria() {
		
	}
	
	public UserCriteria(String email, String org, String des, String freq) {
		this.email = email;
		this.org = org;
		this.des = des;
		this.freq = freq;
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
}