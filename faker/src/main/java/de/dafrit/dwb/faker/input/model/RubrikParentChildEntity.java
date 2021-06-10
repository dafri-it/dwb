package de.dafrit.dwb.faker.input.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "RubrikParentChild")
@Table(name = "rubrik_parent_child")
@IdClass(RubrikParentChildId.class)
@Data
public class RubrikParentChildEntity {

	@Id
	private long parent;

	@Id
	private long child;

	private int prioritaet;

	public RubrikParentChildEntity() {
	}

	public RubrikParentChildEntity(long parent, long child, int prioritaet) {
		super();
		this.parent = parent;
		this.child = child;
		this.prioritaet = prioritaet;
	}
}