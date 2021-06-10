package de.dafrit.dwb.faker.input;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.dafrit.dwb.faker.input.model.RubrikParentChildRepository;
import de.dafrit.dwb.faker.input.model.RubrikRepository;
import de.dafrit.dwb.faker.input.model.TerminRepository;
import de.dafrit.dwb.faker.input.model.ThemaRepository;

@SpringBootTest
public class DatabaseLoaderTest {

    @Autowired
    private RubrikRepository rubrikRepository;
    @Autowired
    private ThemaRepository themaRepository;
    @Autowired
    private TerminRepository terminRepository;
    @Autowired
    private RubrikParentChildRepository childRepository;

    @Test
    void loadDatabase() throws Exception {
        var loader = new DatabaseLoader(rubrikRepository, themaRepository, terminRepository, childRepository);
        loader.load();
        assertFalse(loader.getRubriken().isEmpty());
        assertFalse(loader.getThemen().isEmpty());
        assertFalse(loader.getTermine().isEmpty());
        assertFalse(loader.getRubrikChilds().isEmpty());
    }

}
