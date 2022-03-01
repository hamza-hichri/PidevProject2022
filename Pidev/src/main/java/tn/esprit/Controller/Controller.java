package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.User;
import tn.esprit.service.UserService;
import tn.esprit.service.serviceIMPL;

@RestController
public class Controller {
@Autowired
serviceIMPL serviceIMPL ;
@Autowired

UserService userService;

@PostMapping("/registration")

public String createNewUser( @RequestBody User user) { String hello="";

User userExists = userService.findUserByUserName(user.getUserName());

if (userExists != null) {

hello="There is already a user registered with the user name provided";

} else {

userService.saveUser(user);

hello="OK"; } return hello; }

@PostMapping("/AddUEmpl")
@ResponseBody
public User addEmploee(@RequestBody User E) {
	// TODO Auto-generated method stub
	return serviceIMPL.addEmploee(E);}



}
