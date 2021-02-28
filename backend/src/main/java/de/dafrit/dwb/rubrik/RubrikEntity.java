package de.dafrit.dwb.rubrik;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Rubrik")
@Table(name = "rubrik")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
