package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Role implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id_Role;
   @Enumerated(EnumType.STRING)
	private RoleName role;
	



@ManyToMany (cascade = CascadeType.ALL)
private Set<User> user ;

}

