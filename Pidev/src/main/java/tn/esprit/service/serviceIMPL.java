package tn.esprit.service;

import java.util.List;
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
		if(Userexist(u1, u2)) {

			return reclamationRepository.save(r);
	}
		return null;}

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
	public Boolean Userexist(User u1, User u2) {
	boolean ok1=false;
	boolean ok2=false;
	List<User> usertravel = userRepository.findAll();
    for (User user : usertravel) {
	   if(u1.getId_user()==user.getId_user()) {
	ok1=true; 
	   }
		if (u2.getId_user()==user.getId_user()) {
		ok2=true; 
		}
	   }
    return(ok1&&ok2);
}

}
