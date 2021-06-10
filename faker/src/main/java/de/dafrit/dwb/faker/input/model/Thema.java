package de.dafrit.dwb.faker.input.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Thema {

    @Id
    Long id;

    String nr;

    @OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "thema")
	private Set<RubrikThemaEntity> rubriken;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "thema")
	private List<ThemaTerminEntity> termine;
}
