package tn.esprit.Controller;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import tn.esprit.entities.User;
import tn.esprit.service.userServiceImpl;


import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    userServiceImpl userService;

    @GetMapping("/retrieve-all-users")
    public List<User> getAllUsers(){
        return userService.retrieveAllUsers();
    }
    
    @GetMapping("/best-author")
    public User bestAuthor(){
        return userService.bestAuthor();
    }
    
    @GetMapping("/statistics")
    public void statistics(){
            userService.statistics();
    }
    
    @GetMapping("/retrieve-all-employes")
    public List<User> getAllEmployes(){
        return userService.retrieveEmployes();
        }
    
    @GetMapping("/retrieve-all-companies")
    public List<User> getAllCompanies(){
        return userService.retrieveCompanies();
        }

    @GetMapping("/retrive-user/{user-id}")
    public Optional<User> retriveUser(@PathVariable("user-id") Long id){
        return userService.retriveUser(id);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User u){
        userService.addUser1(u);
        return u;
    }
  

    @DeleteMapping("/remove-user/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping( "/modify-user")
    @ResponseBody
    public User modifyUser(@RequestBody User u){
        return userService.updateUser(u);
    }

    @GetMapping("/find-user-by-email")
    public Optional<User> find_user_by_email(@RequestParam String email){
        return userService.FindUserByEmail(email);
    }

    @GetMapping("/email-exists")
    public boolean MailExists(@RequestParam String email){
        return userService.MailExists(email);
    }

    @PostMapping(path = "/register",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody User user){
        String msg="";
        Optional<User> userExists = userService.FindUserByEmail(user.getEmail());
        if (userExists.isPresent()){
            msg = "user already registered with the email provided";
        }
        else {
            msg="200 OK";
            userService.addUser1(user);
        }
        return msg;
    }

   

    @PostMapping("/authenticate-user")
    public User Authenticate(@RequestBody User u){
        return  userService.Authenticate(u.getEmail(),u.getPassword());
    }

    
}

