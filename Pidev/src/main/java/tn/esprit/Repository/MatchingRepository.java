package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Matching;
@Repository
public interface MatchingRepository extends JpaRepository<Matching, Integer>{

}
