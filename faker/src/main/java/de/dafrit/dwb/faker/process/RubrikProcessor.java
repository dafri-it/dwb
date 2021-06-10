package de.dafrit.dwb.faker.process;

import java.util.List;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;

import de.dafrit.dwb.faker.input.DatabaseLoader;
import de.dafrit.dwb.faker.input.model.Rubrik;

public class RubrikProcessor {

    private DatabaseLoader loader;

    private List<FakedRubrik> output;

    @Autowired
    public RubrikProcessor(DatabaseLoader loader) {
        this.loader = loader;
    }

    public void process() {
        output = loader.getRubriken().stream()
            .map(RubrikProcessor::toFaked)
            .collect(Collectors.toList());
    }

    public List<FakedRubrik> getOutput() {
        return output;
    }

    public static FakedRubrik toFaked(Rubrik rubrik) {

        var faker = new Faker();
        var programmingLanguage = faker.programmingLanguage();
        var name = programmingLanguage.name();
        var slug = Slugger.toSlug(name);

        var description = new StringBuilder()
            // .append("Created by: ")
            // .append(programmingLanguage.creator())
            // .append(System.lineSeparator())
            .append(faker.lorem().sentence())
            .toString();

        return FakedRubrik.builder()
            .id(rubrik.getId())
            .nr(rubrik.getNr())
            .name(name)
            .description(description)
            .slug(slug)
            .build();
    }

}
