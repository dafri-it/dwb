package de.dafrit.dwb.thema;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.rubrik.RubrikPublicController;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ThemaListModel extends RepresentationModel<ThemaListModel> {

	private final Long rubrikId;

	private final List<ThemaListEntryModel> list;

	public ThemaListModel(Long rubrikId, List<ThemaListEntryModel> list) {
		super();
		this.rubrikId = rubrikId;
		this.list = list;
		add(linkTo(methodOn(RubrikPublicController.class).getTree()).withRel("rubriken"));
	}
}
