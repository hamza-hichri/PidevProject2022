
package tn.esprit.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Repository.TravelRepository;
import tn.esprit.entities.Matching;
import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
import tn.esprit.service.serviceIMPL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pidev")
public class Controller {
@Autowired
serviceIMPL serviceIMPL ;

@PostMapping("/AddUEmpl")
@ResponseBody
public User addEmploee(@RequestBody User E) {
	// TODO Auto-generated method stub
	return serviceIMPL.addEmploee(E);
	}

@PostMapping("/AddTravel")
public Travel addtravel(@RequestBody Travel v) {
	return serviceIMPL.AddTravel(v);
}
@GetMapping("/ShowAllTravels")
public List<Travel> DisplayTravel() {
	return serviceIMPL.DisplayAll();
}
@PutMapping("/UpdateTravel")
public Travel UpdateTravel(@RequestBody Travel t) {
	return serviceIMPL.UpdateTravel(t);
}
@DeleteMapping("/DeleteTravel/{tid}")
public void DeleteTravelById(@PathVariable(name = "tid") int tid) {
	serviceIMPL.DeleteTravelById(tid);
}
@GetMapping("/Visited")
	public Map<String,Integer> MostVisitedStats() 
	{
	return serviceIMPL.MostVisitedStats();
	}

@GetMapping("/MatchingAlgorithm")
public Matching AlgoMatch(@RequestBody User u) {
	return serviceIMPL.AlgoMatch(u);
}
}

