package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Role;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.ProjectRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.RoleRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.UserRepository;

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

	public User findOne(int id) {
		return userRepository.findOne(id);
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

	public Integer findOneWithProjects(String name) {
		User user = userRepository.findByName(name);
		return user.getId();
	}

	public User findOneWithProjects(Integer id) {
		User user = findOne(id);
		List<Project> projects = projectRepository.findByUser(user);
		user.setProjects(projects);
		return user;
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findOne(String username) {
		return userRepository.findByName(username);
	}

}
