package com.itmo.projects_registration.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RegistrationRepository extends CrudRepository<Registration, Long>, JpaRepository<Registration, Long>
//, SearchRepository<Registration, Long> 
{
	

//	@Query("SELECT r FROM Registration r WHERE " +
//            "r.company.companyName LIKE CONCAT('%',:query, '%')") 
//            "Or r.description LIKE CONCAT('%', :query, '%')")
//    List<Registration> searchRegistration(String query);

	//client,creation_date,creator,place,prolongation_time,registration_id,registration_state,responsible_manager,validity_time
	
	List<Registration> findByClient(@Param("client") Company client);
	
	List<Registration> findByCreator(@Param("creator") Manager creator);
	
	List<Registration> findByPlace(@Param("place") Place place);
	
	List<Registration> findByRegistrationId(@Param("registrationId") String registrationId);
	
	List<Registration> findByResponsibleManager(@Param("responsibleManager") Manager responsibleManager);
	
	//List<Equipment> findByEquipment(@Param("equipment") Equipment equipment);
	
}
