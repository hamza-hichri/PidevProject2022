package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.CommentRepository;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Publication;
import tn.esprit.entities.User;

import java.util.Optional;




@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	CommentRepository commentrepository;
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	UserRepository employeerepository;
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
	       User Employee = employeerepository.findById(idUser).orElse(null);
		comment.setPublications(Publication);
		comment.setEmployee(Employee);
		commentrepository.save(comment);
	}
}
