package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Feedback;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Role;
import tn.esprit.entities.User;
import tn.esprit.service.serviceIMPL;

@RestController
public class Controller {
@Autowired
serviceIMPL serviceIMPL ;

@PostMapping("/AddUEmpl")
@ResponseBody
public User addEmploee(@RequestBody User E) {
	// TODO Auto-generated method stub
	return serviceIMPL.addEmploee(E);}

@PostMapping("/AddReclamation")
@ResponseBody
public Reclamation addReclamation(@RequestBody Reclamation r) {
      return serviceIMPL.addReclamation(r); 	
}
@PutMapping("/UpdateReclamation")
@ResponseBody
public Reclamation updateReclamation(@RequestBody Reclamation r) {
	return serviceIMPL.updateReclamation(r); 
}
@DeleteMapping
@ResponseBody
public void DeleteReclamationById(@RequestBody Reclamation r) {
	serviceIMPL.deleteReclamationById(r);
}
@GetMapping("/ShowAll")
@ResponseBody
public List<Reclamation> ShowAllReclamation(@RequestBody Reclamation r) {
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
@DeleteMapping
@ResponseBody
public void DeleteFeedbackbyId(@RequestBody Feedback f) {
	serviceIMPL.deleteFeedbackById(f); 
}
@GetMapping("/ShowAll")
@ResponseBody
public List<Feedback> ShowAllFeedback(@RequestBody Feedback f) {
	return serviceIMPL.ShowAllFeedback(); 
}
}
