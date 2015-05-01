package com.gojava2.kickstarter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.Role;
import com.gojava2.kickstarter.entity.User;
import com.gojava2.kickstarter.repository.ProjectRepository;
import com.gojava2.kickstarter.repository.RoleRepository;
import com.gojava2.kickstarter.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
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
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
	}
}