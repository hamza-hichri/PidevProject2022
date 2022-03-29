package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Role;
@Repository
public interface CompanyRepository extends JpaRepository<Role,Long > {

}
