package tn.esprit.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CommentRepository;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.CountType;
import tn.esprit.entities.Publication;
import tn.esprit.entities.User;




@Service
public class PublicationServiceImp implements PublicationService{
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	CommentRepository repositorycomment;
	@Autowired
	UserRepository employeerepository;
	@Override
	public Publication addPublication(Publication p) {
		// TODO Auto-generated method stub
		 return publicationrepository.save(p);
	}

	
	

	@Override
	public List<Publication> retrieveAllPublications() {
		// TODO Auto-generated method stub
		return (List<Publication>)publicationrepository.getAllpublicationbydate();

	}

	@Override
	public void deletePublication(Long id) {
		// TODO Auto-generated method stub
		publicationrepository.deleteById( id);

		
	}

	@Override
	public Publication updatePublication(Publication p) {
		// TODO Auto-generated method stub
		return publicationrepository.save(p);
	}

	public List<Publication> getpost()
	{
	return publicationrepository.getAllpublicationbydate();
	}


	@Override
	public Publication addc(Publication p, Long id) {
		java.util.Optional<User> u = employeerepository.findById(id); 
		User u2=u.get();
			p.setEmployee(u2);      
			return publicationrepository.save(p);
	}

	@Override
	public Set<Publication> findAllByOrderByCreationDateDesc() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CountType> getPercentageGroupByType(){
		
		return publicationrepository.getPercentageGroupByType();
	}




	



	
}



