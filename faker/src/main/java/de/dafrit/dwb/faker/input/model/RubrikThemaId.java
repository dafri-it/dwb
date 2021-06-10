package de.dafrit.dwb.faker.input.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RubrikThemaId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long rubrik;

	private long thema;
}
