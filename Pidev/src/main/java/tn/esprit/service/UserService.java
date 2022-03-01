package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.User;
public class UserService {
@Autowired 
private 
UserRepository userRepository ;
@Autowired
 

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
public User findUserByUserName(String userName) {
return userRepository.findByUserName(userName);
}

public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
      return userRepository.save(user); }

}


