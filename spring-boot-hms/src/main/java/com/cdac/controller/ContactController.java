package com.cdac.controller;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.dto.ContactStatus;
import com.cdac.entity.Contact;
import com.cdac.exception.ContactServiceException;
import com.cdac.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	 @PostMapping("/api/contact")
	    public void saveContact(@RequestBody Contact contact) {
	        contactService.saveContact(contact);
	    }
	 
	 @GetMapping("/api/contacts")
	    public List<Contact> getAllContacts() {
	        return contactService.getAllContacts();
	   }
	 
	 @GetMapping("/api/contact/{id}")
	    public Contact getContactById(@PathVariable int id) {
	        return contactService.getContactById(id);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	  public void deleteContact(@PathVariable int id) {
		 System.out.println("hello" + id);
	      contactService.deleteContactById(id);
	}
}
