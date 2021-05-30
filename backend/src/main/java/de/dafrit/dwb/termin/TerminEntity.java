package de.dafrit.dwb.termin;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "Termin")
@Table(name = "termin")
@Data
public class TerminEntity {

	@Id
	private Long id;

	private String nr;

	private LocalDate von;

	private LocalDate bis;

	private String ort;

	@OneToMany
	@JoinColumn(name = "termin")
	private Set<ThemaTerminEntity> themen;

	public boolean hasThemaId(Long themaId) {
		return themen.stream()
				.map(ThemaTerminEntity::getThema)
				.anyMatch(thema -> thema.equals(themaId));
	}

}