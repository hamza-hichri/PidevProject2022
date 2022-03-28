package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Profession;
@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long> {

	
	 
    @Query("SELECT p FROM Profession p")
    List<Profession> findAllProfessions();
}
