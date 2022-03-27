package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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



}
