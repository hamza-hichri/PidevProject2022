package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Reclamation;
import tn.esprit.entities.User;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{
	List<Reclamation> findByReclamant(User u);

}
