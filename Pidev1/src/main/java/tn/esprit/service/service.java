package tn.esprit.service;

import java.util.List;
import java.util.Map;

import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.Matching;

public interface service {
	public User addEmploee(User E);
///////////////////TravelCrud///////////////////
	public Travel AddTravel(Travel t);
	public Travel UpdateTravel(Travel t);
	public void DeleteTravelById(int tid);
	public List<Travel> DisplayAll();
	public Matching AlgoMatch(User u);
	public Map<String,Integer> MostVisitedStats();
}
