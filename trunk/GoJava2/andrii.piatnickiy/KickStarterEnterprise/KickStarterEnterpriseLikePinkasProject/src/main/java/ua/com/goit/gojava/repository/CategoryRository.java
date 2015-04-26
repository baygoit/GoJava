package ua.com.goit.gojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.goit.gojava.entity.Category;


public interface CategoryRository extends JpaRepository<Category, Integer>{

}
