package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Invitation;

@Repository
public interface InvitationRepository  extends JpaRepository<Invitation, Long >{
	@Query(value ="SELECT i FROM Invitation i where i.State=: state")
	List<Invitation>findByState(@Param("state") boolean state);
}
