package com.gojava2.kickstarter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.ProjectRepository;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User getUser(String name) {
		User user = userRepository.findByName(name);
		user.setProjects(projectRepository.findByUser(user));
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
	}
}