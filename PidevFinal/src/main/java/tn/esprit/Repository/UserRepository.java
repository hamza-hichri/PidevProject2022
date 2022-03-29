package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.User;

public interface UserRepository extends JpaRepository<User,Long >{
    User findByUsername(String username);

	User findByEmail(String email);
}
