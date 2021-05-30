package de.dafrit.dwb.thema;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import de.dafrit.dwb.termin.TerminEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ThemaDetailsModel extends ThemaListEntryModel {

	private final String text;

	private final String pdf;

	public ThemaDetailsModel(ThemaEntity entity, List<TerminEntity> termine2) {
		super(entity, termine2);
		text = entity.getDetails().getText();

		pdf = entity.getDetails().getPdf();
		
		removeLinks();
		
		add(linkTo(methodOn(ThemaPublicController.class).getByRubrikId(entity.getRubrik())).withRel("rubrik"));
	}
}
