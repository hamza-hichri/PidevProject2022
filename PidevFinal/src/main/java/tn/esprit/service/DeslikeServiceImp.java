package tn.esprit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.DeslikeRepository;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Dislike;
import tn.esprit.entities.Publication;
import tn.esprit.entities.User;




@Service
public class DeslikeServiceImp implements DeslikeService {
	@Autowired
	DeslikeRepository Dislikkerepository;
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	UserRepository emprep;
	@Override
	public Dislike adddislike(Dislike d) {
		// TODO Auto-generated method stub
		return Dislikkerepository.save(d);
	}
	
	public void dislikeservice(Dislike Dislike, Long idUser, Long idp) {
		// TODO Auto-generated method stub

		Publication Publication1 = publicationrepository.findById(idp).orElse(null);
	       User Employee = emprep.findById(idUser).orElse(null);
	       Dislike.setPublications(Publication1);
	       Dislike.setEmployee(Employee);
	       Dislikkerepository.save(Dislike);
	}
}
	
	
