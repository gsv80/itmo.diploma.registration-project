package com.itmo.projects_registration.service;

import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.itmo.projects_registration.domain.Manager;
import com.itmo.projects_registration.domain.ManagerRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final ManagerRepository managerRepo;

	public UserDetailsServiceImpl(ManagerRepository managerRepo) {
		this.managerRepo = managerRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Manager> user = managerRepo.findByUsername(username);
		
		UserBuilder builder = null;
	    if (user.isPresent()) {
	        Manager currentUser = user.get();
	        builder = org.springframework.security.core.userdetails.User.withUsername(username);
	        
	        builder.password(currentUser.getPassword());
	        builder.roles(currentUser.getRole().toString());
	    } else 
	    {
	        throw new UsernameNotFoundException("User not found.");
	    }
	    return builder.build();
	}

}
