package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Matching;
@Repository
public interface MatchingRepository extends JpaRepository<Matching, Integer> {
	

}
