package de.dafrit.dwb.faker.input.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class RubrikParentChildId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "parent")
	private long parent;

	@Column(name = "child")
	private long child;
}
