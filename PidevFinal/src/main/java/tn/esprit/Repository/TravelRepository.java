package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Travel;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
	@Query(value="select destination from travel t", nativeQuery = true)
	List<String> getdestinations();
	

}
