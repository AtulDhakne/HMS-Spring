package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
}