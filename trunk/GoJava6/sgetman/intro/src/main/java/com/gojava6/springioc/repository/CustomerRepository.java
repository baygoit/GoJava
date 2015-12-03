package com.gojava6.springioc.repository;


import com.gojava6.springioc.model.Customer;

import java.util.List;

public interface CustomerRepository {

	List<Customer> findAll();

}