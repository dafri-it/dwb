package de.dafrit.dwb.faker.input.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Termin {

    @Id
    Long id;

    String nr;

    @OneToMany
	@JoinColumn(name = "termin")
	private Set<ThemaTerminEntity> themen;

}
