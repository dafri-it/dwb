package de.dafrit.dwb.rubrik;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.thema.ThemaPublicController;

public class RubrikModel extends RepresentationModel<RubrikModel> {

	private final long id;

	private final String nr;

	private final String name;

	private final String slug;

	private final String description;

	private final List<RubrikModel> childs;

	public RubrikModel(long id, String nr, String name, String slug, String description, RubrikModel parent) {
		super();
		this.id = id;
		this.nr = nr;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.childs = new ArrayList<RubrikModel>();
		if (parent != null) {
			parent.childs.add(this);
		}
		add(linkTo(methodOn(ThemaPublicController.class).getByRubrikId(id)).withRel("themen"));
		
	}
	
	public static RubrikModel createRoot() {
		return new RubrikModel(-1, "", "", "", "", null);
	}

	public long getId() {
		return id;
	}

	public String getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}

	public String getSlug() {
		return slug;
	}

	public String getDescription() {
		return description;
	}

	public List<RubrikModel> getChilds() {
		return childs;
	}

}
