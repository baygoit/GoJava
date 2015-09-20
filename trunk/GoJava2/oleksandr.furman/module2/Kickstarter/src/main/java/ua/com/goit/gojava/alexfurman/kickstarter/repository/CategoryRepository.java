package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
