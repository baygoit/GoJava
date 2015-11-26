package com.gojava6.airbnb.repository;

import com.gojava6.airbnb.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select * from user b where b.name = :name")
    User findByName(@Param("name") String name);
}
