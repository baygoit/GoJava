package com.gojava2.kickstarter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String name) {
		return userRepository.findByName(name);
	}

	public void save(User user) {
		userRepository.save(user);
	}
}