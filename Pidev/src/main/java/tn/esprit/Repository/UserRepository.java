package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
