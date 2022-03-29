package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Domain;
@Repository
public interface DomainRepository extends CrudRepository<Domain, Long> {

	  @Query("SELECT d FROM Domain d")
	  List<Domain> findAllDomains();
	  
	 
}
