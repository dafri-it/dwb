package de.dafrit.dwb.termin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "ThemaTermin")
@Table(name = "thema_termin")
@IdClass(ThemaTerminId.class)
@Data
public class ThemaTerminEntity {

	@Id
	private Long thema;

	@Id
	private Long termin;
	
	private int prioritaet;
}
