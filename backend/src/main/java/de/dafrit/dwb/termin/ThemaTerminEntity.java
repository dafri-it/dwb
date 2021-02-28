package de.dafrit.dwb.termin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "ThemaTermin")
@Table(name = "thema_termin")
@IdClass(ThemaTerminId.class)
public class ThemaTerminEntity {

	@Id
	private Long thema;

	@Id
	private Long termin;
	
	private int prioritaet;

	public Long getThema() {
		return thema;
	}

	public void setThema(Long thema) {
		this.thema = thema;
	}

	public Long getTermin() {
		return termin;
	}

	public void setTermin(Long termin) {
		this.termin = termin;
	}

	public int getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(int prioritaet) {
		this.prioritaet = prioritaet;
	}
	
	
}
