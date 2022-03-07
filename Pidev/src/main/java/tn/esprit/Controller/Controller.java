package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Role;
import tn.esprit.entities.Travel;
import tn.esprit.entities.User;
import tn.esprit.service.serviceIMPL;

@RestController
public class Controller {
	@Autowired
	serviceIMPL serviceIMPL;

	@PostMapping("/AddUEmpl")
	@ResponseBody
	public User addEmploee(@RequestBody User E) {
		// TODO Auto-generated method stub
		return serviceIMPL.addEmploee(E);
	}

	@PostMapping("/AddTravel")
	@ResponseBody
	public Travel AddTravel(@RequestBody Travel t) {
		return serviceIMPL.AddTravel(t);
	}

	@PutMapping("/UpdateTravel")
	@ResponseBody
	public Travel UpdateTravel(@RequestBody Travel t) {
		return serviceIMPL.UpdateTravel(t);
	}

	@DeleteMapping("/DeleteTravel/{tid}")
	@ResponseBody
	public void DeleteTravelById(@PathVariable int tid) {
		serviceIMPL.DeleteTravelById(tid);
	}

	@GetMapping("/ShowAll")
	@ResponseBody
	public List<Travel> DisplayAlltravel() {
		return serviceIMPL.DisplayAll();
	}

}
