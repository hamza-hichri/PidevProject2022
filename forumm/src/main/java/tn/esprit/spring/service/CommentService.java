package tn.esprit.spring.service;

import tn.esprit.spring.entity.Comment;



public interface CommentService {
	Comment addcomment(Comment com );

	void deletecomment(Long id);
	void deletecom(Comment com);

	Comment addc(Comment c, Long id);
	Comment updateComment(Comment c);

	public void	ajouterEtaffecterListeComment(Comment comment, Long idp,Long idE);	
}
