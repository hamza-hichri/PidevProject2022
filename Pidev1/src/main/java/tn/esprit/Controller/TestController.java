package tn.esprit.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Repository.RoleRepository;
import tn.esprit.entities.User;
import tn.esprit.service.ServiceUser;
import tn.esprit.service.UserService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	UserService us;
	@Autowired
	ServiceUser su;
	@Autowired
	RoleRepository Rrepository;
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('WOMEN') or hasRole('EXPERT') or hasRole('FORMER')")
  public String userAccess() {
    return "User Content.";
  }
  @GetMapping("/retrieve-all-users")
  @PreAuthorize("hasRole('WOMEN')")
	public Set<User> getUsers(){
		return us.retrieveAllUsers();
	}

  @GetMapping("/mod")
  @PreAuthorize("hasRole('WOMEN')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ROLE_Company')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  private String getSiteURL(HttpServletRequest request) {
      String siteURL = request.getRequestURL().toString();
      return siteURL.replace(request.getServletPath(), "");
  }  
}
