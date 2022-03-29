package tn.esprit.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.User;
@Slf4j
@Service
public class ServiceUser implements userService{
	@Autowired
	UserRepository userRepository;
	@Override
	public Set<User> retrieveAllUsers() {
		Set<User> users = new HashSet<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User addUser(User user) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	public User view(User userName) {
		return userName ;
	}
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User retrieveUserById(Long iduser) {
		return userRepository.findById(iduser).orElse(null);
	}



	

}
