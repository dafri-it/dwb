package de.dafrit.dwb.thema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "RubrikThema")
@Table(name = "rubrik_thema")
@IdClass(RubrikThemaId.class)
@Data
public class RubrikThemaEntity {

	@Id
	private long rubrik;

	@Id
	private long thema;

	private int prioritaet;
}
