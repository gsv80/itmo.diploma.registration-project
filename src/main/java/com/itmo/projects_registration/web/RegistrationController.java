package com.itmo.projects_registration.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmo.projects_registration.domain.Registration;
import com.itmo.projects_registration.domain.RegistrationRepository;

@RestController
public class RegistrationController {

	public RegistrationController(RegistrationRepository regRepo) {
		this.regRepo = regRepo;
	}

	private final RegistrationRepository regRepo;
	
	@GetMapping("/registrations")
    public Iterable<Registration> getRegistration() {
		return regRepo.findAll(); }
}
