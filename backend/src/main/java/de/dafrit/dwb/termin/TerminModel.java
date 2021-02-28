package de.dafrit.dwb.termin;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

public class TerminModel extends RepresentationModel<TerminModel> {

	private final Long id;

	private final String nr;

	private final LocalDate von;

	private final LocalDate bis;

	private final String ort;

	public TerminModel(Long id, String nr, LocalDate von, LocalDate bis, String ort) {
		super();
		this.id = id;
		this.nr = nr;
		this.von = von;
		this.bis = bis;
		this.ort = ort;
	}
	
	public TerminModel(TerminEntity entity) {
		this(entity.getId(), entity.getNr(), entity.getVon(), entity.getBis(), entity.getOrt());
	}

	public Long getId() {
		return id;
	}

	public String getNr() {
		return nr;
	}

	public LocalDate getVon() {
		return von;
	}

	public LocalDate getBis() {
		return bis;
	}

	public String getOrt() {
		return ort;
	}

}
