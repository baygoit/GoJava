package com.gojava6.airbnb.repository;

import com.gojava6.airbnb.apartment.ReservedApartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface ReserveBookRepository extends JpaRepository<ReservedApartment, Integer> {
}
