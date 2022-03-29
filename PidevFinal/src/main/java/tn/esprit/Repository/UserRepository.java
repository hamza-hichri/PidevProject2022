package tn.esprit.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Publication;
import tn.esprit.entities.User;

public interface UserRepository extends JpaRepository<User,Long >{
    User findByUsername(String username);
    @Query("SELECT U FROM User U WHERE U.email like ?1")
    Optional<User> findByEmail1(String email);

    @Query("SELECT U FROM User U WHERE U.email like %?1")
    User findByEmail2(String email);
    
    @Query("SELECT U FROM User U WHERE U.role='Employe'")
    List<User> retrieveEmployes();
    
    @Query("SELECT U FROM User U WHERE U.role='Company'")
    List<User> retrieveCompanies();
    
    
    @Query("SELECT Max(p.Likes) FROM Publication p ")
    int maxLikes();

    @Query("SELECT p FROM Publication p WHERE p.Likes=?1")
    Publication findBestAuthor(int likes);

	User findByEmail(String email);
}
