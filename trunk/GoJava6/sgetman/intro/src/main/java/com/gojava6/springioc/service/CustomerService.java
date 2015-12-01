package com.gojava6.springioc.service;


import com.gojava6.springioc.model.Customer;

import java.util.List;

public interface CustomerService {

	List<Customer> findAll();

}