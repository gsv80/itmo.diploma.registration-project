package com.itmo.projects_registration.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ManagerRepository extends CrudRepository<Manager, Long> {
	Optional<Manager> findByUsername(String username);

}
