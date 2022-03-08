package tn.esprit.entities;


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
public class Invitation {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO  )
	private long Id_Invitation;
	private String Content;
	private String Email;
	private String Invitaiondestination ;
	@Enumerated(EnumType.STRING)
	private State State;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User>  user ;
	
}
