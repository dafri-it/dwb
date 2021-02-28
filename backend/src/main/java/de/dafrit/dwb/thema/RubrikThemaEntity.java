package de.dafrit.dwb.thema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "RubrikThema")
@Table(name = "rubrik_thema")
@IdClass(RubrikThemaId.class)
public class RubrikThemaEntity {

	@Id
	private long rubrik;

	@Id
	private long thema;

	private int prioritaet;

	public RubrikThemaEntity() {
	}

	public RubrikThemaEntity(long rubrik, long thema, int prioritaet) {
		this.rubrik = rubrik;
		this.thema = thema;
		this.prioritaet = prioritaet;
	}

	public long getRubrik() {
		return rubrik;
	}

	public void setRubrik(long rubrik) {
		this.rubrik = rubrik;
	}

	public long getThema() {
		return thema;
	}

	public void setThema(long thema) {
		this.thema = thema;
	}

	public int getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(int prioritaet) {
		this.prioritaet = prioritaet;
	}

}
