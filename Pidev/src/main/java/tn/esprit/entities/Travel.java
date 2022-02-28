package tn.esprit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Travel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
		private int id_voyage;
		private String destination;
		@Temporal(TemporalType.DATE)
		private Date start_date;
		@Temporal(TemporalType.DATE)
		private Date finish_date;
		private String schudle;
		
		@ManyToMany(cascade = CascadeType.ALL , mappedBy = "travel")
		private Set<User> user ;
}
