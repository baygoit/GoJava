package com.gojava6.springioc.service;

import com.gojava6.springioc.model.Customer;
import com.gojava6.springioc.repository.CustomerRepository;
import com.gojava6.springioc.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

		private CustomerRepository customerRepository;

		public CustomerServiceImpl() {

		}

		public CustomerServiceImpl(CustomerRepository customerRepository) {
				this.customerRepository = customerRepository;
		}

		public void setCustomerRepository(CustomerRepository customerRepository) {
				this.customerRepository = customerRepository;
		}

		public List<Customer> findAll() {
				return customerRepository.findAll();
		}

}
