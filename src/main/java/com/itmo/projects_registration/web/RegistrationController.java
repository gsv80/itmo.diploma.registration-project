package com.itmo.projects_registration.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itmo.projects_registration.domain.Company;
import com.itmo.projects_registration.domain.Registration;
import com.itmo.projects_registration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@GetMapping("/registrations")
    public List<Registration> listAll() {
		return service.listAll(); 
	}
	
	@GetMapping("/registrations/{id}")
	public ResponseEntity<Registration> read(@PathVariable("id") Long id) {
		
		try {
			Registration registration =  service.get(id);
			return new ResponseEntity<Registration>(registration , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Registration>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/registrations/{company}")
    public List<Registration> findByClient(@PathVariable("client") Company client ) {
        return service.findByClient(client);
    }
	
	@PostMapping("/registrations")
	public void create(@RequestBody Registration registration) {
		service.save(registration);
	}
	
	@PutMapping("/registrations/{id}")
	public ResponseEntity<Registration> update(@RequestBody Registration registration, @PathVariable("id") Long id) {
		try{
			Registration existRegistration = service.get(id);
			service.save(registration);
			return new ResponseEntity<Registration>(HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Registration>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/registrations/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
	
	
}
