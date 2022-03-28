package tn.esprit.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Repository.RoleRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Role;
import tn.esprit.entities.User;
import tn.esprit.service.ServiceUser;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.security.UserDetailsImpl;
import tn.esprit.spring.security.jwt.JwtUtils;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  ServiceUser serviceUser;
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	  User u = userRepository.findByEmail(loginRequest.getEmail());
		  
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(u.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
   
  }

  @PostMapping("/signup")
  public String registerUser( @RequestBody User signUpRequest) {
			Set<Role> Role = new HashSet();
		String msg="";
	User userExists = userRepository.findByUsername(signUpRequest.getUsername());
		if (userExists != null) {
			msg="There is already a user registered with the user name provided";
		} else {
			Set<Role> roles = signUpRequest.getRoles();
			for (Role role : roles) {
	          
	         Role r= roleRepository.findByRole(role.getRole());
	         if(r == null){
	        	 roleRepository.save(role); 
	        	 r= roleRepository.findByRole(role.getRole());
	         }
	         Role.add(r);
	          
	        }
			signUpRequest.getRoles().clear();
			signUpRequest.setRoles(Role);
			    serviceUser.addUser(signUpRequest);
				msg="User have been added succ"; 
		}
		return msg; 
		}
}
