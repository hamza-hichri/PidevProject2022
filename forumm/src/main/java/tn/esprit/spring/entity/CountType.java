package tn.esprit.spring.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CountType {
	private long count;
	@Enumerated(EnumType.STRING)
	private type  typepublication;

}
