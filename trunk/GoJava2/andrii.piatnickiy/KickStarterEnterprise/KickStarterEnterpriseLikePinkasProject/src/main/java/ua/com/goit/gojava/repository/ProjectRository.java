package ua.com.goit.gojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.entity.Project;






public interface ProjectRository extends JpaRepository<Project, Integer>{

}
