package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Idreclamation;
    private String Reclamation ;
//    private String reclamationdestination; 
    @Temporal(TemporalType.DATE)
    private Date creating_date;
    @ManyToOne
    private User reclamant ;
    @ManyToOne
    private User reclamationdestination ; 
    }
