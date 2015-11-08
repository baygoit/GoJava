package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}