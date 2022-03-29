package tn.esprit.Controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.User;
import tn.esprit.service.EmailSender;
import tn.esprit.service.service;


@RestController
@RequestMapping("/Invitation")
public class InvitationRestController {
	@Autowired 
	service cs;

	@Autowired
	EmailSender emailSender;
	
	 @Autowired
	 UserRepository ur;
	 @Autowired
		JavaMailSender mailSender;

	
	@PostMapping("/addInvitation")
	@ResponseBody
	public void addInvitation(@RequestBody Invitation c,@RequestParam(value="idUsers") List<Long> idUsers)
	{
		
		
		cs.addInvitation(c, idUsers);
	
		for(Long id:idUsers){
			User u= ur.findById(id).get();
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("mouhanned.souissi@esprit.tn");
			message.setTo(u.getEmail());
			message.setSubject("This is an invitation");
			message.setText("Hi,"    +  u.getName()+    
			               "Linkini has invited you to use our Application to collaborate with them. Use the button below to set up your account and get started:");
		
			mailSender.send(message);
			}
	
	}
	
	
	@PostMapping("/addUserToInv/{idUser}/{idInv}")
	@ResponseBody
	public void addUserToInv(@PathVariable("idUser") Long idUser ,@PathVariable("idInv") Long idInv)
	{
		cs.addUserToInvitation(idUser, idInv);
		
	}
	
	@PostMapping("/accepterInv/{idInv}")
	@ResponseBody
	public void accepterInv(@PathVariable("idInv") Long idInv )
	{
		cs.accepterInvitation(idInv);
		
	}
	
	@GetMapping("/get-invitation-by-user/{idUser}")
	@ResponseBody
	public Set<Invitation> getInvitationByUser(@PathVariable("idUser") Long id)
	{
		return cs.invitationsParUser(id);
	}
	
	
	
	@GetMapping("/get-all-Invitation")
	@ResponseBody
	public List<Invitation> getAllInvitation()
	{
		List<Invitation> listInvitation = cs.retrieveAllInvitation();	
		return listInvitation; 	
	}
	
	
	@DeleteMapping("/remove-Invitation/{idInvitation}")
	@ResponseBody
	public void removeInvitation(@PathVariable("idInvitation") Long idInvitation) {
		cs.deleteInvitation(idInvitation);
	}
  	
  	
	@PutMapping("/modify-Invitation")
	@ResponseBody
	public Invitation modifyInvitation(@RequestBody Invitation c)
	{
		return cs.updateInvitation(c);
	}
	
	
	
	
	
	@PutMapping("/modify-Invitation-byID/{id}")
	@ResponseBody
	public Invitation ModifyInvitation(@PathVariable("id") Long idInvitation,@RequestBody Invitation t) {
	return cs.updateInvitationById(t, idInvitation);
	
	}
	
	
	
	@GetMapping("/FindByState/{state}")
	List<Invitation>findByState(@PathVariable("state") boolean state) 
	{
		return cs.findBystate(state);
	
	}
	
	
	
}