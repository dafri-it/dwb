package de.dafrit.dwb.thema;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.RepresentationModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ThemaOverviewEntryModel extends RepresentationModel<ThemaOverviewEntryModel> {
    
    private Long id;

    
    private String nr;
    
	private String name;
    
	private String subTitle;
    
	private String description;
    
    public ThemaOverviewEntryModel(Long id, String nr, String name, String subTitle, String description) {
        this.id = id;
        this.nr = nr;
        this.name = name;
        this.subTitle = subTitle;
        this.description = description;
        add(linkTo(methodOn(ThemaPublicController.class).getDetails(id)).withRel("details"));
    }

    public ThemaOverviewEntryModel(ThemaEntity entity) {
        this(entity.getId(), entity.getNr(), entity.getName(), entity.getSubTitle(), entity.getDescription());
    }
}
