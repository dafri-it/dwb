package de.dafrit.dwb.faker.input.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ThemaTerminId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long thema;

	private Long termin;
}