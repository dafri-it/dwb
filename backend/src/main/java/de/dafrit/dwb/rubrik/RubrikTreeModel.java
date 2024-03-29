package de.dafrit.dwb.rubrik;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.HomeController;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RubrikTreeModel extends RepresentationModel<RubrikTreeModel> {

	private final List<RubrikModel> tree;

	public RubrikTreeModel(List<RubrikModel> tree) {
		this.tree = tree;
		add(linkTo(methodOn(HomeController.class).index()).withRel("index"));
	}
}
