package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.User;

public interface UserRepository extends CrudRepository<User,Long >{
    User findByUsername(String username);

	User findByEmail(String email);
}
