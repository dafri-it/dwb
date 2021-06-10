package de.dafrit.dwb.faker.process;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FakedRubrik {

    private Long id;

	private String nr;

	private String name;

	private String slug;

	private String description;

}
