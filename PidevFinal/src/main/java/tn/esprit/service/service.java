package tn.esprit.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import tn.esprit.entities.Feedback;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.Matching;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;

public interface service {
	public User addEmploee(User E);

	public Invitation addInvitation(Invitation c, List<Long> idusers);

	// void addInvitation(Invitation c,List<Long> idusers);
	List<Invitation> retrieveAllInvitation();

	void deleteInvitation(Long id);

	Invitation updateInvitation(Invitation c);

	Invitation updateInvitationById(Invitation o, Long idInvitation);

	List<Invitation> findBystate(boolean state);

	void addUserToInvitation(Long idUser, Long idInv);

	public Set<Invitation> invitationsParUser(Long idInv);

	public void accepterInvitation(Long idInv);

///////////////////TravelCrud///////////////////
	public Travel AddTravel(Travel t);

	public Travel UpdateTravel(Travel t);

	public void DeleteTravelById(int tid);

	public List<Travel> DisplayAll();

	public Matching AlgoMatch(User u);

	public Map<String, Integer> MostVisitedStats();

////////////Reclamation Functions ////////////////////
	public Reclamation addReclamation(Reclamation r, long id1, long id2);

	public Reclamation updateReclamation(Reclamation r);

	public void deleteReclamationById(long idr);

	public List<Reclamation> ShowAllReclamation();

////////////Feedbacks Functions //////////////////////////        
	public Feedback addFeedback(Feedback f);

	public Feedback upadteFeedback(Feedback f);

	public void deleteFeedbackById(Feedback f);

	public List<Feedback> ShowAllFeedback();

/////////////////Reclamation//////////////////////
	public Map<User, List<User>> rectable();

	boolean validRec(Long id_reclament, Long id_R_des);

}
