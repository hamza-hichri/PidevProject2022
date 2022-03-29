package tn.esprit.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.FeedbackRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.MatchingRepository;
import tn.esprit.Repository.ReclamationRepository;
import tn.esprit.Repository.TravelRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Feedback;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.Matching;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
@Service
public class serviceIMPL implements service {
	@Autowired
	TravelRepository travelrepository;
	@Autowired
	MatchingRepository matchingRepository;
	boolean val= false;

	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	private List<User> matchingusers;
@Autowired
UserRepository employeeRepository ;
@Autowired
UserRepository ur;
@Autowired
EmailSender email = new EmailSender();

@Autowired

CompanyRepository  companyRepository ;
@Autowired 
InvitationRepository repository ;
@Autowired
	EmailSender emailSender;


	@Override
	public User addEmploee(User E) {

		return employeeRepository.save(E);
	}



	@Override
	public Invitation addInvitation(Invitation c, List<Long> idusers) {
		User u= ((List<User>) ur.findAllById(idusers)).get(1);
		List<User> users= new ArrayList<User>();
		
		//c.setUsers(users);
         
		repository.save(c);
	
		email.sendMail("mouhanned.souissi@esprit.tn","Hello", "Content");
		
				return c;
	}



	@Override
	public List<Invitation> retrieveAllInvitation() {

		return (List<Invitation>)repository.findAll();
	}



	@Override
	public void deleteInvitation(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}



	@Override
	public Invitation updateInvitation(Invitation c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}



	@Override
	public Invitation updateInvitationById(Invitation o, Long idInvitation) {
Invitation kl = repository.findById(idInvitation).orElse(null);
//kl.setState(o.);
		return null;
	}



	@Override
	public List<Invitation> findBystate(boolean state) {
		return repository.findByState(state);
	}



	@Override
	public void addUserToInvitation(Long idUser, Long idInv) {
		 System.out.println(idUser);
			User u= ur.findById(idUser).get();
			System.out.println(u);
			Invitation inv= repository.findById(idInv).get();
			u.getInvitations().add(inv);
			ur.save(u);		
	}



	@Override
	public Set<Invitation> invitationsParUser(Long idInv) {
		return ur.findById(idInv).get().getInvitations();
	}



	@Override
	public void accepterInvitation(Long idInv) {
Invitation inv = repository.findById(idInv).get();
inv.setState(true);
repository.save(inv);
	}


	@Override
	public Travel AddTravel(Travel t) {

		return travelrepository.save(t);
	}

	@Override
	public Travel UpdateTravel(Travel t) {

		return travelrepository.save(t);
	}

	@Override
	public void DeleteTravelById(int tid) {
		travelrepository.deleteById(tid);

	}

	@Override
	public List<Travel> DisplayAll() {

		return travelrepository.findAll();
	}

	@Override
	public Matching AlgoMatch(User u) {
		/*List<User> users=employeeRepository.findAll();
		Matching match= new Matching();
		Set<Travel> tr=u.getTravel();
		for (Travel travel : tr) {
			
		}
		
		
		
		
		*/
			Matching match= new Matching();
			
			 List<User> users = ur.findAll();
			matchingusers = null;
			Set<Travel> myTravel = u.getTravel();
			
		
			
			
			
			for (User user : users) {
				Set<Travel> travelers = user.getTravel();
				for (Travel traveler : travelers) {
					for (Travel travel : myTravel) {

						if (traveler.getDestination() == travel.getDestination()&&traveler.getStart_date()==travel.getStart_date()&&user.getProfission()==u.getProfission()&&user.getField()==u.getField()) 
						{
							matchingusers.add(user);
						}
					}
				}
				
			}
			if (u.getName()!=match.getUser1()) {
				match.setUser1(u.getName());
				match.setUsers((Set<User>)matchingusers);
			}
			
			return matchingRepository.save(match);
			
				
			}
		
		
		
	

	@Override
	public Map<String,Integer> MostVisitedStats() {
		List<String> destinations=travelrepository.getdestinations();
		Map<String,Integer> stats=new HashMap<>();
		for (String dest : destinations) 
		{
			stats.putIfAbsent(dest,0);
			stats.put(dest, stats.get(dest)+1);
		}
		return stats;
		}
	
	
	@Override
	public Reclamation addReclamation(Reclamation r, long id1 , long id2) {
		boolean v = validRec(id1, id2);
		if (v==true) {
			r.setReclamant(ur.getById(id1));
			r.setReclamationdestination(ur.getById(id2));
		return reclamationRepository.save(r);
		}
		else {
			String msg = "mrigel bro";
			System.out.println(msg);
			return null ;
		}
			
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
		 User u= ur.findById(id_reclament).orElse(null); 
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



