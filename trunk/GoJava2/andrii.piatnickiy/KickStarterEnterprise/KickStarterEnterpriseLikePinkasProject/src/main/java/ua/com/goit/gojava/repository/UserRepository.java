package ua.com.goit.gojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
