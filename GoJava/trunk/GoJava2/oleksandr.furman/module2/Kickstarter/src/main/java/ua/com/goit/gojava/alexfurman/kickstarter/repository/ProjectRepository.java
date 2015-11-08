package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<Project> findByCategory(Category category);
	
	List<Project> findByUser(User user);
	
}
