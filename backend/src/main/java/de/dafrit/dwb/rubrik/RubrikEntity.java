package de.dafrit.dwb.rubrik;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "Rubrik")
@Table(name = "rubrik")
@Data
public class RubrikEntity {

	@Id
	private Long id;

	private String nr;

	private String name;

	private String slug;

	private String description;

	public RubrikEntity() {
	}

	public RubrikEntity(Long id, String nr, String name) {
		super();
		this.id = id;
		this.nr = nr;
		this.name = name;
	}
}
