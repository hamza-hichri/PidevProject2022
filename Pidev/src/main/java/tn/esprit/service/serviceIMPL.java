package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.EmployeeRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.entities.Role;
import tn.esprit.entities.User;
import tn.esprit.entities.Invitation;
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
		// TODO Auto-generated method stub
		return employeeRepository.save(E);
	}



	}



