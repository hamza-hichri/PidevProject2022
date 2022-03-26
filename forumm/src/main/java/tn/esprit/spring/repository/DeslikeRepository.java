package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Dislike;

@Repository

public interface DeslikeRepository extends CrudRepository<Dislike ,Long> {
	@Query("Select COUNT(etatdislike) FROM Dislike  c  Where  c.etatdislike=1 ")
	int getNbrLikee2();

	@Query("Select COUNT(etatdislike) FROM Dislike c Where c.etatdislike=0")
	int getNbrLikee3();
}
