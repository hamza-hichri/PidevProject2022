package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
import tn.esprit.entities.Invitation;

public interface service {
	public User addEmploee(User E);
	
	///////////////////TravelCrud///////////////////
	public Travel AddTravel(Travel t);
	public Travel UpdateTravel(Travel t);
	public void DeleteTravelById(Travel t);
	public List<Travel> DisplayAll(Travel t);
	public List<User> AlgoMatch(User u);
}

