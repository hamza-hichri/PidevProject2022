package tn.esprit.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Dislike;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.repository.DeslikeRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.EmployeeRepository;


@Service
public class DeslikeServiceImp implements DeslikeService {
	@Autowired
	DeslikeRepository Dislikkerepository;
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	EmployeeRepository emprep;
	@Override
	public Dislike adddislike(Dislike d) {
		// TODO Auto-generated method stub
		return Dislikkerepository.save(d);
	}
	
	public void dislikeservice(Dislike Dislike, Long idUser, Long idp) {
		// TODO Auto-generated method stub

		Publication Publication1 = publicationrepository.findById(idp).orElse(null);
	       Employee Employee = emprep.findById(idUser).orElse(null);
	       Dislike.setPublications(Publication1);
	       Dislike.setEmployee(Employee);
	       Dislikkerepository.save(Dislike);
	}
}
	
	
