package tn.esprit.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import javax.print.attribute.standard.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.action.Action;
import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.EmployeeRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.MatchingRepository;
import tn.esprit.Repository.TravelRepository;
import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
import tn.esprit.entities.Invitation;

@Service
public class serviceIMPL implements service {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	InvitationRepository invitationRepository;
	@Autowired
	TravelRepository travelrepository;
	@Autowired
	MatchingRepository matchingrepository;

	@Override
	public User addEmploee(User E) {
		// TODO Auto-generated method stub
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
	public List<User> AlgoMatch(User u) {
		List<User> users = employeeRepository.findAll();
		List<User> Matchingusers = null;
		Set<Travel> myTravel = u.getTravel();
		
	
		
		
		
		for (User user : users) {
			Set<Travel> travelers = user.getTravel();
			for (Travel traveler : travelers) {
				for (Travel travel : myTravel) {

					if (traveler.getDestination() == travel.getDestination()&&traveler.getStart_date()==travel.getStart_date()&&user.getProfission()==u.getProfission()) 
					{
						Matchingusers.add(user);
					}
				}
			}
		}
		return Matchingusers;
	}

}
