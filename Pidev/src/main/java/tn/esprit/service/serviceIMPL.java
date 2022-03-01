package tn.esprit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.RoleRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.entities.User;
@Service
public class serviceIMPL implements service {
@Autowired
UserRepository userRepository ;
@Autowired
RoleRepository  companyRepository ;
@Autowired 
InvitationRepository invitationRepository ;



	@Override
	public User addEmploee(User E) {
		// TODO Auto-generated method stub
		return userRepository.save(E);
	}



	}



