package de.dafrit.dwb;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.rubrik.RubrikPublicController;
import de.dafrit.dwb.thema.ThemaPublicController;

public class IndexModel extends RepresentationModel<IndexModel> {

	public IndexModel() {
		add(linkTo(methodOn(RubrikPublicController.class).getTree()).withRel("rubriken"));
		add(linkTo(methodOn(ThemaPublicController.class).getAll()).withRel("themen"));
	}

}
