package ua.com.goit.gojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.goit.gojava.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
