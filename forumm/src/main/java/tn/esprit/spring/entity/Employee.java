package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

Long	id;
//	@OneToMany(cascade = CascadeType.ALL)
	//private List <Publicationt> publications;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee",fetch=FetchType.LAZY)
	private List <Comment> comments;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set <Publication> publications;

	
	
}
	