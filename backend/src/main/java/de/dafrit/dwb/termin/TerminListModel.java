package de.dafrit.dwb.termin;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class TerminListModel extends RepresentationModel<TerminListModel> {

	private final Long themaId;

	private final List<TerminModel> termine;

	public TerminListModel(Long themaId, List<TerminModel> termine) {
		super();
		this.themaId = themaId;
		this.termine = termine;
//		add(linkTo(methodOn(PublicController.class).getTermineByThema(themaId)).withRel("them"));
	}
}
