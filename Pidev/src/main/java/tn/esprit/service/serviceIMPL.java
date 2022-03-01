package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CompanyRepository;
import tn.esprit.Repository.EmployeeRepository;
import tn.esprit.Repository.FeedbackRepository;
import tn.esprit.Repository.InvitationRepository;
import tn.esprit.Repository.ReclamationRepository;
import tn.esprit.entities.Role;
import tn.esprit.entities.User;
import tn.esprit.entities.Feedback;
import tn.esprit.entities.Invitation;
import tn.esprit.entities.Reclamation;
@Service
public class serviceIMPL implements service {
@Autowired
EmployeeRepository employeeRepository ;
@Autowired
CompanyRepository  companyRepository ;
@Autowired 
InvitationRepository invitationRepository ;
@Autowired
ReclamationRepository reclamationRepository;
@Autowired
FeedbackRepository feedbackRepository;


	@Override
	public User addEmploee(User E) {
		// TODO Auto-generated method stub
		return employeeRepository.save(E);
	}



	@Override
	public Reclamation addReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}



	@Override
	public Reclamation updateReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}



	@Override
	public void deleteReclamationById(long idr) {
		reclamationRepository.deleteById(idr);
		
	}



	@Override
	public List<Reclamation> ShowAllReclamation() {
		// TODO Auto-generated method stub
		return reclamationRepository.findAll() ;
	}



	@Override
	public Feedback addFeedback(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(f); 
	}



	@Override
	public Feedback upadteFeedback(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(f);
	}



	@Override
	public void deleteFeedbackById(Feedback f) {
		// TODO Auto-generated method stub
		feedbackRepository.deleteById(f.getId_feedback());
		
	}



	@Override
	public List<Feedback> ShowAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}



	}



