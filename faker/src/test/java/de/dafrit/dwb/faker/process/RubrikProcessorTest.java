package de.dafrit.dwb.faker.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.dafrit.dwb.faker.input.DatabaseLoader;
import de.dafrit.dwb.faker.input.model.Rubrik;

@SpringBootTest
public class RubrikProcessorTest {

    Logger logger = LoggerFactory.getLogger(RubrikProcessorTest.class);
    
    @Autowired DatabaseLoader loader;

    @Test
    void testGenerator() throws Exception {

        loader.load();
        var processor = new RubrikProcessor(loader);

        processor.process();

        var output = processor.getOutput();

        output.stream().forEach(f -> logger.info(f.toString()));

        assertFalse(output.isEmpty());
        
        assertIdAndNrEquals(loader.getRubriken(), output);
    }

    private void assertIdAndNrEquals(List<Rubrik> rubriken, List<FakedRubrik> output) {

        assertEquals(rubriken.size(), output.size());

        for (int i = 0; i < rubriken.size(); i++) {
            var rubrik = rubriken.get(i);
            var faked = output.get(i);

            assertEquals(rubrik.getId(), faked.getId());
            assertEquals(rubrik.getNr(), faked.getNr());
            assertFalse(faked.getName().isBlank());
            assertFalse(faked.getSlug().isBlank());
        }

    }

}
