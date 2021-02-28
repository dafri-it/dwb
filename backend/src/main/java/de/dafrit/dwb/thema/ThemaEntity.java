package de.dafrit.dwb.thema;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.dafrit.dwb.termin.ThemaTerminEntity;

@Entity(name = "Thema")
@Table(name = "thema")
public class ThemaEntity {
	@Id
	private Long id;

	private String nr;

	private String name;

	@Column(name = "beschrlang")
	private String subTitle;

	private String description;

	@Embedded
	private ThemaDetails details;

	@OneToMany
	@JoinColumn(name = "thema")
	private Set<RubrikThemaEntity> rubriken;

	@OneToMany
	@JoinColumn(name = "thema")
	private List<ThemaTerminEntity> termine;

	public ThemaEntity() {
	}
	
	public Long getRubrik() {
		if (rubriken.isEmpty()) {
			return null;
		}
		
		return rubriken.stream()
				.findFirst()
				.map(r -> r.getRubrik())
				.orElse(null);
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

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ThemaDetails getDetails() {
		return details;
	}

	public void setDetails(ThemaDetails details) {
		this.details = details;
	}

	public Set<RubrikThemaEntity> getRubriken() {
		return rubriken;
	}

	public void setRubriken(Set<RubrikThemaEntity> rubriken) {
		this.rubriken = rubriken;
	}

	public List<ThemaTerminEntity> getTermine() {
		return termine;
	}

	public void setTermine(List<ThemaTerminEntity> termine) {
		this.termine = termine;
	}

}
