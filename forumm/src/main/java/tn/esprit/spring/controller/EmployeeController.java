package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeservice;
	
	//http://localhost:8089/SpringMVC/Produit/affectation-fournisseur/p/f

	
	@PutMapping("/affectation-publication/{id-employee}/{idp}")
	@ResponseBody
	public void assignuserToPublication (@PathVariable("id-employee") Long id,@PathVariable ("idp") Long idp) {
		employeeservice.assignerToPublication(id, idp);
	}
	

}
