package tn.esprit.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Data;

@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy =GenerationType.AUTO  )
	private long id_user;
	private String name;
	private String email;
	private String username ;
	private String password ;

	private long phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee",fetch=FetchType.LAZY)
	private List <Comment> comments;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Feedback> feedbacks ;
	@ManyToOne
	private Profission Profission;
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Invitation>invitations ;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Reclamation> reclamations ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set <Publication> publications;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER) 
	private Set<Role> roles ;
	@ManyToOne
	private Field field;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Travel> travel ;

}