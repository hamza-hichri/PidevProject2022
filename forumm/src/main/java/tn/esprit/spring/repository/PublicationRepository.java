package tn.esprit.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.type;

@Repository
public interface PublicationRepository extends JpaRepository<Publication ,Long>  {
	

	
	
	public List<Publication> findBytypepublication(type typepublication);
	@Query(value= "select * from Post   order by date_creation  desc",nativeQuery = true)
	List<Publication> getAllpublicationbydate();
	@Query("SELECT p FROM Post p WHERE CONCAT(title ,description ,typepost) LIKE %?1%")
	public List<Publication> search(String keyword);
}
