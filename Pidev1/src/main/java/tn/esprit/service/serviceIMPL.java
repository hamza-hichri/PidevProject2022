package tn.esprit.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.EmployeeRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.MatchingRepository;
import tn.esprit.Repository.TravelRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Matching;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
@Service
public class serviceIMPL implements service {
@Autowired
EmployeeRepository employeeRepository ;
@Autowired
CompanyRepository  companyRepository ;
@Autowired 
InvitationRepository invitationRepository ;
@Autowired
TravelRepository travelrepository;
@Autowired
MatchingRepository matchingRepository;
private List<User> matchingusers;

	@Override
	public User addEmploee(User E) {

		return employeeRepository.save(E);
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
			
			 List<User> users = employeeRepository.findAll();
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
	}



