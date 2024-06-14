package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.RegistrationStatus;
import com.cdac.dto.Status;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.service.CustomerService;


@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public RegistrationStatus register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("Customer registered successfully!");
			status.setCustomerId(id);
			return status;
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;			
		}
	}
	
	@PostMapping("/customer/login")
	public Status login(@RequestBody LoginDetails loginDetails) {
		System.out.println("Hello");
		try {
			Customer customer = customerService.loginv2(loginDetails.getEmail(), loginDetails.getPassword());
			
			LoginStatus status = new LoginStatus();
			
			status.setStatus(true);
			status.setMessageIfAny("Login Successfull");
			status.setCustomerId(customer.getId());
			status.setName(customer.getName());
			System.out.println(customer.getId()+" "+customer.getName());
			
			
			return status;
			
		}catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	

}
