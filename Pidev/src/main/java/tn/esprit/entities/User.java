package tn.esprit.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id_user")
@Table(name="User")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
@Id
@GeneratedValue(strategy =GenerationType.AUTO  )
	private long id_user;
	private String Name;
	private String Email;
	private String UserName ;
	private String Password ;
	@Enumerated(EnumType.STRING)
    private Role role;
    private String profession;
	private String domain;
    private int likebudge;
    private int feedbackbudge;
    private int activitebudge;
    private int reclamationbudge;
	private long PhoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Feedback> feedbacks ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Invitation> invitations ;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Reclamation> reclamations ;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
	private Set<Publication> publications ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Travel> travel ;

}