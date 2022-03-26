package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;


import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	CommentRepository commentrepository;
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	EmployeeRepository employeerepository;
	@Override
	public Comment addcomment(Comment com) {
		// TODO Auto-generated method stub
		return  commentrepository.save(com);
	}

	@Override
	public void deletecomment(Long id) {
		// TODO Auto-generated method stub
		commentrepository.deleteById(id);
		
	}

	@Override
	public void deletecom(Comment com) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment addc(Comment c, Long id) {
		
			
			Optional<Publication> p =publicationrepository.findById(id); 
			Publication c2=p.get();
			c.setPublications(c2);
			return commentrepository.save(c);
		}

	@Override
	public Comment updateComment(Comment c) {
		// TODO Auto-generated method stub
		return commentrepository.save(c);

	}

	@Override
	public void ajouterEtaffecterListeComment(Comment comment, Long idp, Long idUser) {
		// TODO Auto-generated method stub

		Publication Publication = publicationrepository.findById(idp).orElse(null);
	       Employee Employee = employeerepository.findById(idUser).orElse(null);
		comment.setPublications(Publication);
		comment.setEmployee(Employee);
		commentrepository.save(comment);
	}
}
