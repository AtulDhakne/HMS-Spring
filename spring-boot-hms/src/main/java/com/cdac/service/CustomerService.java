package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public int register(Customer customer) {

		Optional<Customer> customerCheck = customerRepository.findByEmail(customer.getEmail());
		if(customerCheck.isEmpty()) {
			Address address = customer.getAddress();
			if(address != null)
				address.setCustomer(customer);
			Customer savedCustomer = customerRepository.save(customer);
			return savedCustomer.getId();
		}
		else
			throw new CustomerServiceException("Customer already registered!");
	}

	public void login() {
		
	}
	
	public Customer loginv2(String email, String password) {
		Long count = customerRepository.findIfCustomerIsPresent(email, password);
		if(count == 0)
			throw new CustomerServiceException("Invalid Email/Password");
		else {
			return customerRepository.findByEmail(email).get();
		}
	}

}