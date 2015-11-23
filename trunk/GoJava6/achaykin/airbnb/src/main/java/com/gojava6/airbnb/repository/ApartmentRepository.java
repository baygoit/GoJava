package com.gojava6.airbnb.repository;

import com.gojava6.airbnb.apartment.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

}
