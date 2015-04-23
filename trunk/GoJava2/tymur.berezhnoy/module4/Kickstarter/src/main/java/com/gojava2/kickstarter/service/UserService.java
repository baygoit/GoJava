package com.gojava2.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String name) {
		return userRepository.findByName(name);
	}
}