package tn.esprit.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CountType;
import tn.esprit.entities.Publication;
import tn.esprit.entities.type;



@Repository
public interface PublicationRepository extends JpaRepository<Publication ,Long>  {
	

	
	
	public List<Publication> findBytypepublication(type typepublication);
	@Query(value= "select * from Publication   order by date_creation  desc",nativeQuery = true)
	List<Publication> getAllpublicationbydate();
	@Query("SELECT p FROM Publication p WHERE CONCAT(title ,description ,typepublication) LIKE %?1%")
	public List<Publication> search(String keyword);
	@Query(value = "select new tn.esprit.entities.CountType(COUNT (*)/(Select COUNT(*) from Publication) * 100, typepublication) from Publication GROUP By typepublication") 
	
	public List<CountType> getPercentageGroupByType();
}
