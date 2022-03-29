package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Role;
import tn.esprit.entities.RoleName;


public interface RoleRepository extends CrudRepository<Role,Long >{

	Role findByRole(RoleName role);
   
}
