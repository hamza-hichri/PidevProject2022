package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long > {
Role fidByRole(String role);
}
