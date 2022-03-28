package tn.esprit.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.User;
@Service
public class serviceIMPL implements service {
@Autowired
UserRepository employeeRepository ;
@Autowired
UserRepository ur;
@Autowired
EmailSender email = new EmailSender();

@Autowired

CompanyRepository  companyRepository ;
@Autowired 
InvitationRepository repository ;
@Autowired
	EmailSender emailSender;


	@Override
	public User addEmploee(User E) {

		return employeeRepository.save(E);
	}



	@Override
	public Invitation addInvitation(Invitation c, List<Long> idusers) {
		User u= ((List<User>) ur.findAllById(idusers)).get(1);
		List<User> users= new ArrayList<User>();
		
		//c.setUsers(users);
         
		repository.save(c);
	
		email.sendMail("mouhanned.souissi@esprit.tn","Hello", "Content");
		
				return c;
	}



	@Override
	public List<Invitation> retrieveAllInvitation() {

		return (List<Invitation>)repository.findAll();
	}



	@Override
	public void deleteInvitation(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}



	@Override
	public Invitation updateInvitation(Invitation c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}



	@Override
	public Invitation updateInvitationById(Invitation o, Long idInvitation) {
Invitation kl = repository.findById(idInvitation).orElse(null);
//kl.setState(o.);
		return null;
	}



	@Override
	public List<Invitation> findBystate(boolean state) {
		return repository.findByState(state);
	}



	@Override
	public void addUserToInvitation(Long idUser, Long idInv) {
		 System.out.println(idUser);
			User u= ur.findById(idUser).get();
			System.out.println(u);
			Invitation inv= repository.findById(idInv).get();
			u.getInvitations().add(inv);
			ur.save(u);		
	}



	@Override
	public Set<Invitation> invitationsParUser(Long idInv) {
		return ur.findById(idInv).get().getInvitations();
	}



	@Override
	public void accepterInvitation(Long idInv) {
Invitation inv = repository.findById(idInv).get();
inv.setState(true);
repository.save(inv);
	}



	}



