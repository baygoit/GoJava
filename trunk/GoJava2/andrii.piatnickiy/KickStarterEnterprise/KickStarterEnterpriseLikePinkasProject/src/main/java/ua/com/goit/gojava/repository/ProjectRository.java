package ua.com.goit.gojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.entity.Project;

public interface ProjectRository extends JpaRepository<Project, Integer> {
	List<Project> findByCategory(Category category);

}
