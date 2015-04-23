package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}