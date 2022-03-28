package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.*;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT U FROM User U WHERE U.Email like ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT U FROM User U WHERE U.Email like %?1")
    User findByEmail2(String email);
    
    @Query("SELECT U FROM User U WHERE U.role='Employe'")
    List<User> retrieveEmployes();
    
    @Query("SELECT U FROM User U WHERE U.role='Company'")
    List<User> retrieveCompanies();
    
    
    @Query("SELECT Max(p.Likes) FROM Publication p ")
    int maxLikes();

    @Query("SELECT p FROM Publication p WHERE p.Likes=?1")
    Publication findBestAuthor(int likes);
   
}
