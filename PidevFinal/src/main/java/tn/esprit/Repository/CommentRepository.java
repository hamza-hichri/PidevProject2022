package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Comment;



@Repository

public interface CommentRepository extends CrudRepository<Comment ,Long> {

}
