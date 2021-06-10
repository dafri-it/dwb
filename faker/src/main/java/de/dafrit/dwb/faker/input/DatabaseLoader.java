package de.dafrit.dwb.faker.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dafrit.dwb.faker.input.model.Rubrik;
import de.dafrit.dwb.faker.input.model.RubrikParentChildEntity;
import de.dafrit.dwb.faker.input.model.RubrikParentChildRepository;
import de.dafrit.dwb.faker.input.model.RubrikRepository;
import de.dafrit.dwb.faker.input.model.Termin;
import de.dafrit.dwb.faker.input.model.TerminRepository;
import de.dafrit.dwb.faker.input.model.Thema;
import de.dafrit.dwb.faker.input.model.ThemaRepository;

@Service
public class DatabaseLoader {

    private RubrikRepository rubrikRepository;
    private ThemaRepository themaRepository;
    private TerminRepository terminRepository;
    private RubrikParentChildRepository rubrikParentChildRepository;

    private List<Rubrik> rubriken;
    private List<Thema> themen;
    private List<Termin> termine;
    private List<RubrikParentChildEntity> childs;

    @Autowired
    public DatabaseLoader(RubrikRepository rubrikRepository, ThemaRepository themaRepository,
            TerminRepository terminRepository, RubrikParentChildRepository rubrikParentChildRepository) {
        this.rubrikRepository = rubrikRepository;
        this.themaRepository = themaRepository;
        this.terminRepository = terminRepository;
        this.rubrikParentChildRepository = rubrikParentChildRepository;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public List<Thema> getThemen() {
        return themen;
    }

    public void load() {
        rubriken = rubrikRepository.findAll();
        themen = themaRepository.findAll();
        termine = terminRepository.findAll();
        childs = rubrikParentChildRepository.findAll();
    }

    public List<Rubrik> getRubriken() {
        return rubriken;
    }

    public List<RubrikParentChildEntity> getRubrikChilds() {
        return childs;
    }

}
