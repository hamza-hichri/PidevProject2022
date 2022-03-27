package tn.esprit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.EmployeeRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.entities.User;
@Service
public class serviceIMPL implements service {
@Autowired
EmployeeRepository employeeRepository ;
@Autowired
CompanyRepository  companyRepository ;
@Autowired 
InvitationRepository invitationRepository ;



	@Override
	public User addEmploee(User E) {

		return employeeRepository.save(E);
	}



	}



