package de.dafrit.dwb.thema;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import de.dafrit.dwb.HomeController;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ThemaOverviewModel extends RepresentationModel<ThemaOverviewModel> {
    
    private List<ThemaOverviewEntryModel> themen;

    public ThemaOverviewModel(List<ThemaOverviewEntryModel> themen) {
        this.themen = themen;
        add(linkTo(methodOn(HomeController.class).index()).withRel("index"));
    }

}
