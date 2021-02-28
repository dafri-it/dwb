package de.dafrit.dwb.rubrik;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "RubrikParentChild")
@Table(name = "rubrik_parent_child")
@IdClass(RubrikParentChildId.class)
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

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

	public long getChild() {
		return child;
	}

	public void setChild(long child) {
		this.child = child;
	}

	public int getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(int prioritaet) {
		this.prioritaet = prioritaet;
	}

}
