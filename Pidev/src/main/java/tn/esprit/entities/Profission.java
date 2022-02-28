package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Profission {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO  )
	private long Id_Field;
	private String Profissiontype ;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "Profission")
	private Set<User>  user;
}
