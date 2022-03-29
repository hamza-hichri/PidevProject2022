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

import tn.esprit.entities.Feedback;
import tn.esprit.entities.Matching;
import tn.esprit.entities.Reclamation;
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
	return serviceIMPL.addEmploee(E);}



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


@PostMapping("/AddReclamation/{user1_Id}/{user2_id}")
public Reclamation addReclamation(@RequestBody Reclamation r,@PathVariable(name = "user1_Id")long user1_Id,@PathVariable (name = "user2_id") long user2_id) {
       
	return serviceIMPL.addReclamation(r, user1_Id,user2_id); 	
}
@PutMapping("/UpdateReclamation")
@ResponseBody
public Reclamation updateReclamation(@RequestBody Reclamation r) {
	return serviceIMPL.updateReclamation(r); 
}
@DeleteMapping("DeleteRec/{idr}")
public void DeleteReclamationById(@PathVariable("idr") long idr) {
	serviceIMPL.deleteReclamationById(idr);
}
@GetMapping("valdRec/{id_reclament}/{id_R_des}/")
public boolean validRec(@PathVariable("id_reclament") long id_reclament,@PathVariable("id_R_des") long id_R_des) {
	return serviceIMPL.validRec(id_reclament, id_R_des);
}
@GetMapping("/ShowAllRecl")
@ResponseBody
public List<Reclamation> ShowAllReclamation() {
	return serviceIMPL.ShowAllReclamation(); 
}
@PostMapping("/AddFeedback")
@ResponseBody
public Feedback addFeedback(@RequestBody Feedback f) {
	return serviceIMPL.addFeedback(f); 
}
@PutMapping("/UpdateFeedback")
@ResponseBody
public Feedback updateFeedback(@RequestBody Feedback f) {
	return serviceIMPL.upadteFeedback(f) ; 
}
@DeleteMapping("Delete")
@ResponseBody
public void DeleteFeedbackbyId(@RequestBody Feedback f) {
	serviceIMPL.deleteFeedbackById(f); 
}
@GetMapping("/ShowAll")
@ResponseBody
public List<Feedback> ShowAllFeedback() {
	return serviceIMPL.ShowAllFeedback(); 
}
}