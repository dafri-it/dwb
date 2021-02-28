package de.dafrit.dwb.rubrik;

import java.io.Serializable;

import javax.persistence.Column;

public class RubrikParentChildId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "parent")
	private long parent;

	@Column(name = "child")
	private long child;

	public RubrikParentChildId() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (child ^ (child >>> 32));
		result = prime * result + (int) (parent ^ (parent >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RubrikParentChildId other = (RubrikParentChildId) obj;
		if (child != other.child)
			return false;
		if (parent != other.parent)
			return false;
		return true;
	}

}
