package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.Company;
import com.itmo.projects_registration.domain.Registration;
import com.itmo.projects_registration.domain.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	public List<Registration> listAll(){
		return (List<Registration>) registrationRepo.findAll();
	}
	
	public void save(Registration registration) {
		registrationRepo.save(registration);
	}
	
	public Registration get(Long id) {
		return registrationRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		registrationRepo.deleteById(id);
	}
	
//	public List<Registration> getByClient(Company company) {
//		return registrationRepo.findByClient(company);
//	}
	
	public List<Registration> findByClient(Company client) {
        return registrationRepo.findByClient(client);
    }
	
}
