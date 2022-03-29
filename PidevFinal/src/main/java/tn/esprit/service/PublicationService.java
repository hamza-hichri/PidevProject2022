package tn.esprit.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.entities.CountType;
import tn.esprit.entities.Publication;



public interface PublicationService {
	Publication addPublication(Publication publication);

List<Publication> retrieveAllPublications();

void deletePublication(Long id);
Publication updatePublication(Publication p);
Publication addc(Publication p, Long id);

Set<Publication> findAllByOrderByCreationDateDesc();
List<CountType> getPercentageGroupByType();


}
