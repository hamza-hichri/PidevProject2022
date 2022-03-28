package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id_Publication;
    private int Likes  ;
    private int Substriction ;
    @ManyToOne
    private User user ;
    
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "publication")
    private Set<Comments> comments ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "publication")
    private Set<Followers> followers ; 
}
