package de.dafrit.dwb.thema;

import java.io.Serializable;

import lombok.Data;

@Data
public class RubrikThemaId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long rubrik;

	private long thema;
}
