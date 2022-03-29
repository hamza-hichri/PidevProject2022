package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.DomainRepository;
import tn.esprit.Repository.ProfessionRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Domain;
import tn.esprit.entities.Profession;
import tn.esprit.entities.Publication;
import tn.esprit.entities.User;


import java.util.*;

@Service
public class userServiceImpl implements ServicePro{

    private final UserRepository userRepository;

     @Autowired
     DomainRepository dr;

     @Autowired
     ProfessionRepository pr;
    //BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    @Autowired
    public userServiceImpl(UserRepository userRepository)
       {
    	this.userRepository=userRepository;
       }

	@Override
	public List<User> retrieveAllUsers() {
	       return (List<User>)userRepository.findAll();
	    }

	    @Override
	    public User addUser1(User u) {
	    	
	    	if (u.getRoles().toString()=="ROLE_Company")
	    	{
	    		
	    		String domain= u.getDomain();
	    		if(this.checkDomain(domain))
	    		{
	    			System.out.println("Domaine existant!");
	    		}
	    		else
	    		{
	    			Domain d= new Domain();
	    			d.setName(u.getDomain());
	    			dr.save(d);
	    			System.out.println("Nouveau domaine ajouté : "+u.getDomain());

	    		}
	    	}
	    	else if(u.getRoles().toString()=="ROLE_Employee")
	    	{
	    		String profession= u.getProfession();
	    		if(this.checkProfession(profession))
	    		{
	    			System.out.println("Profession existante!");
	    		}
	    		else
	    		{   
	    			Profession p= new Profession();
	    			p.setName(u.getProfession());
	    			pr.save(p);
	    			System.out.println("Nouvelle profession ajoutée: "+u.getProfession());

	    		}
	    	}
	        userRepository.save(u);

	        return u;
	    }


	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User u) {
		 userRepository.save(u);
	        return u;
	}

	@Override
	public Optional<User> retriveUser(Long id) {
        return userRepository.findById(id);

	}

	@Override
	public Optional<User> FindUserByEmail(String email) {
        return userRepository.findByEmail1(email);

	}

	@Override
	public boolean MailExists(String email) {
        return userRepository.findByEmail1(email).isPresent();

	}

	@Override
	public User Authenticate(String email, String password) {
		   Optional<User> UserExists=userRepository.findByEmail1(email);
	        if(UserExists.isPresent()){
	            User user=UserExists.get();
	            if (password.matches(user.getPassword())){
	                return user;
	            }
	        }
	        return null;
	}

	@Override
	public boolean checkDomain(String Newdomain) {
		List<Domain> domains= dr.findAllDomains(); 
		for (Domain domain : domains) {
	        if ((domain.getName()).equals(Newdomain)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public boolean checkProfession(String Newprofession) {
		List<Profession> professions= pr.findAllProfessions(); 
		for (Profession profession : professions) {
	        if ((profession.getName()).equals(Newprofession)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public List<User> retrieveEmployes() {
		return userRepository.retrieveEmployes();
	}

	@Override
	public List<User> retrieveCompanies() {

		return userRepository.retrieveCompanies();
	}

	@Override
	public User bestAuthor() {
		int likes= userRepository.maxLikes();
		System.out.println(likes);
		Publication p=userRepository.findBestAuthor(likes);
		System.out.println(p);
		User u= p.getEmployee();
		int likebudge= u.getLikebudge();
		u.setLikebudge(likebudge+1);
		userRepository.save(u);
		return u;
	}

	@Override
	public void statistics() {
		int employes= userRepository.retrieveEmployes().size();
		
		int companies= userRepository.retrieveCompanies().size();
		
		int somme=employes+companies;
		
		float pourcentageE=(employes*100)/somme;
		float pourcentageC=(companies*100)/somme;
		
		
		System.out.println("Le pourcentage des employés est: "+pourcentageE+"%");
		System.out.println("Le pourcentage des companies est: "+pourcentageC+"%");

	}

	
	


}
