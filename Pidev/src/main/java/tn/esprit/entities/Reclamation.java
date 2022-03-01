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
    private String Username ;
    private int Usermaxcount;
    @Temporal(TemporalType.DATE)
    private Date creating_date;
    @ManyToOne
    private User user ;
	public long getIdreclamation() {
		return Idreclamation;
	}
	public void setIdreclamation(long idreclamation) {
		Idreclamation = idreclamation;
	}
	public String getReclamation() {
		return Reclamation;
	}
	public void setReclamation(String reclamation) {
		Reclamation = reclamation;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getUsermaxcount() {
		return Usermaxcount;
	}
	public void setUsermaxcount(int usermaxcount) {
		Usermaxcount = usermaxcount;
	}
	public Date getCreating_date() {
		return creating_date;
	}
	public void setCreating_date(Date creating_date) {
		this.creating_date = creating_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Idreclamation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamation other = (Reclamation) obj;
		return Idreclamation == other.Idreclamation;
	}
	public Reclamation(long idreclamation, String reclamation, String username, int usermaxcount, Date creating_date,
			User user) {
		super();
		Idreclamation = idreclamation;
		Reclamation = reclamation;
		Username = username;
		Usermaxcount = usermaxcount;
		this.creating_date = creating_date;
		this.user = user;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
