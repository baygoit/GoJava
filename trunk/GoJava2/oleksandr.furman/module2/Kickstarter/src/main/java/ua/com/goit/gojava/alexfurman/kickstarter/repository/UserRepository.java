package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);


}
