package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

}
