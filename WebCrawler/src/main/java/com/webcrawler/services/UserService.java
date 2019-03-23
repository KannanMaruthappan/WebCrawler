package com.webcrawler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcrawler.dao.UserDetailsModel;
import com.webcrawler.dao.UserServiceDao;
import com.webcrawler.ui.model.UserCriteria;

@Service
public class UserService {

	@Autowired
	private UserServiceDao dao;
    
    public String saveAndEmailUser(UserCriteria user) {
		UserDetailsModel model = new UserDetailsModel(user.getEmail(), user.getOrg(), user.getDes(), user.getFreq());
		String email = dao.newUser(model).getEmail();
		sendMail(email);
    	return email;
    }
    
    private void sendMail(String email) {
    	//TODO: EMAIL TRIGGER
    }

	public List<UserDetailsModel> getAllDetails() {
		return dao.getAll();
	}
    
}
