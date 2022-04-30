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
public class Matching {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_Matching;
private String user1;
private String user2;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "matching")
private Set<Travel> travels;
}
