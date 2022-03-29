package tn.esprit.service;

import java.util.Set;

import tn.esprit.entities.User;



public interface userService {
	Set<User> retrieveAllUsers();
	User addUser(User user);
	User findUserByUserName(String userName);
	User retrieveUserById(Long iduser);
}
