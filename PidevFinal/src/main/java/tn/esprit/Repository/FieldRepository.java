package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Field;
@Repository
public interface FieldRepository extends JpaRepository<Field,Long >{

}
