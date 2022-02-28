package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Profission;
@Repository
public interface ProfissionRepository extends JpaRepository<Profission, Long >{

}
