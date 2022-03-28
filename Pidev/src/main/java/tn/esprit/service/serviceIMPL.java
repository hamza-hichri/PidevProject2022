package tn.esprit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.FeedbackRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.ReclamationRepository;
import tn.esprit.Repository.RoleRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.User;
import tn.esprit.entities.Feedback;
import tn.esprit.entities.Reclamation;

@Service
public class serviceIMPL implements service {
	boolean val= false;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	InvitationRepository invitationRepository;
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public User addEmploee(User E) {
		// TODO Auto-generated method stub
		return userRepository.save(E);
	}

	@Override
	public Reclamation addReclamation(Reclamation r, User u1 , Integer user2_id) {
		User u2 = userRepository.getById((long)user2_id);

			return reclamationRepository.save(r);
	}


	@Override
	public Reclamation updateReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamationById(long idr) {
		reclamationRepository.deleteById(idr);

	}

	@Override
	public List<Reclamation> ShowAllReclamation() {
		// TODO Auto-generated method stub
		return reclamationRepository.findAll();
	}

	@Override
	public Feedback addFeedback(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(f);
	}

	@Override
	public Feedback upadteFeedback(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(f);
	}

	@Override
	public void deleteFeedbackById(Feedback f) {
		// TODO Auto-generated method stub
		feedbackRepository.deleteById(f.getId_feedback());

	}

	@Override
	public List<Feedback> ShowAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}

	@Override
	public Map<User, List<User>> rectable() {
		
		List<User> destinations = new ArrayList();
		List<Reclamation> reclamation = reclamationRepository.findAll();
		for (Reclamation reclamation2 : reclamation) {
			User recl= reclamation2.getReclamant();
			destinations.add(reclamation2.getReclamationdestination());
		}
		
		return null;
	}
	
	
	@Override
	 public boolean  validRec(Long id_reclament , Long id_R_des) {
		 User u= userRepository.findById(id_reclament).orElse(null); 
		 List<Reclamation> r=reclamationRepository.findByReclamant(u);
		 
		 r.forEach(v->{
			 if (v.getReclamationdestination().getId_user()==id_R_des) 
				   val= true ; 
					 });
		 if(val==true) {
			 return false;
			 
		 }else {
			 return true ; 
		 }
		  
	 }

  

}
