package de.dafrit.dwb.termin;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Termin")
@Table(name = "termin")
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

	public TerminEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public LocalDate getVon() {
		return von;
	}

	public void setVon(LocalDate von) {
		this.von = von;
	}

	public LocalDate getBis() {
		return bis;
	}

	public void setBis(LocalDate bis) {
		this.bis = bis;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Set<ThemaTerminEntity> getThemen() {
		return themen;
	}

	public void setThemen(Set<ThemaTerminEntity> themen) {
		this.themen = themen;
	}

	public boolean hasThemaId(Long themaId) {
		return themen.stream()
				.map(tt -> tt.getThema())
				.anyMatch(thema -> thema.equals(themaId));
	}

}