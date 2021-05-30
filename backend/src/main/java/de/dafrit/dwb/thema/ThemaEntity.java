package de.dafrit.dwb.thema;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.dafrit.dwb.termin.ThemaTerminEntity;
import lombok.Data;

@Entity(name = "Thema")
@Table(name = "thema")
@Data
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

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "thema")
	private Set<RubrikThemaEntity> rubriken;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "thema")
	private List<ThemaTerminEntity> termine;
	
	public Long getRubrik() {
		if (rubriken.isEmpty()) {
			return null;
		}
		
		return rubriken.stream()
				.findFirst()
				.map(RubrikThemaEntity::getRubrik)
				.orElse(null);
	}
}
