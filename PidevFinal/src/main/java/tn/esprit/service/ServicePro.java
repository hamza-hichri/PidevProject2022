package tn.esprit.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.entities.User;

public interface ServicePro {
	  List<User> retrieveAllUsers();
	    User addUser1(User u);
	    void deleteUser(Long id);
	    User updateUser(User u);
	    Optional<User>retriveUser(Long id);
	    Optional<User> FindUserByEmail(String email);
	    boolean MailExists(String email);
	    User Authenticate(String email,String password);
	    boolean checkDomain(String domain);
	    boolean checkProfession(String profession);
	    List<User> retrieveEmployes();
	    List<User> retrieveCompanies();
	    User bestAuthor() ;
	    public void statistics();
	    
}
