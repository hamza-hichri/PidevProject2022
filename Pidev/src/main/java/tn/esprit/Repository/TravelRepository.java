package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Travel;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {

}
