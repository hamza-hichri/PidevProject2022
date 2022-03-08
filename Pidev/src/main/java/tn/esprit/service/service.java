package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.User;
import tn.esprit.entities.Feedback;
import tn.esprit.entities.Reclamation;

public interface service {
	public User addEmploee(User E);
	
	////////////Reclamation Functions ////////////////////
	public Reclamation addReclamation(Reclamation r, User u1 , Integer  user2_id);
	public Reclamation updateReclamation(Reclamation r);     
	public void deleteReclamationById(long idr);               
	public List<Reclamation> ShowAllReclamation();               
	                                                               
    ////////////Feedbacks Functions //////////////////////////        
	public Feedback addFeedback(Feedback f);                       
	public Feedback upadteFeedback(Feedback f);                 
	public void deleteFeedbackById(Feedback f);              
	public List<Feedback> ShowAllFeedback();              
	                                                   
	/////////////////Reclamation//////////////////////
	public Boolean Userexist(User u1 , User u2);
}
