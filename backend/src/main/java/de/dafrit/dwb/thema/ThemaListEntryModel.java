package de.dafrit.dwb.thema;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.termin.TerminEntity;
import de.dafrit.dwb.termin.TerminModel;

public class ThemaListEntryModel extends RepresentationModel<ThemaListEntryModel> {

	private final Long id;

	private final String nr;

	private final String name;
	
	private final String subTitel;

	private final String description;
	
	private final List<TerminModel> termine;

	public ThemaListEntryModel(Long id, String nr, String name, String subTitel, String description, List<TerminEntity> termine2) {
		super();
		this.id = id;
		this.nr = nr;
		this.name = name;
		this.subTitel = subTitel;
		this.description = description;
		this.termine = termine2.stream().map(entity -> new TerminModel(entity)).collect(Collectors.toList());
		add(linkTo(methodOn(ThemaPublicController.class).getDetails(id)).withRel("details"));
	}
	
	public ThemaListEntryModel(ThemaEntity entity, List<TerminEntity> termine2) {
		this(entity.getId(), entity.getNr(), entity.getName(), entity.getSubTitle(), entity.getDescription(), termine2);
	}

	public Long getId() {
		return id;
	}

	public String getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}
	
	public String getSubTitel() {
		return subTitel;
	}

	public String getDescription() {
		return description;
	}
	
	public List<TerminModel> getTermine() {
		return termine;
	}
}
