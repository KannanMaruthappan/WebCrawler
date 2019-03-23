package com.webcrawler.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceDao {

	@Autowired
	private UserRepository repository;
	
	public UserDetailsModel newUser(UserDetailsModel user) {
		return repository.save(user);
	}
	
	public List<UserDetailsModel> getAll(){
		return repository.findAll();
	}
	
	public UserDetailsModel getByEmail(String email){
		return repository.findByEmail(email);
	}
}
