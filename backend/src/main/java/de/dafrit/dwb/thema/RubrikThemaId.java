package de.dafrit.dwb.thema;

import java.io.Serializable;

public class RubrikThemaId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long rubrik;

	private long thema;

	public RubrikThemaId() {
	}

	public RubrikThemaId(long rubrik, long thema) {
		super();
		this.rubrik = rubrik;
		this.thema = thema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rubrik ^ (rubrik >>> 32));
		result = prime * result + (int) (thema ^ (thema >>> 32));
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
		RubrikThemaId other = (RubrikThemaId) obj;
		if (rubrik != other.rubrik)
			return false;
		if (thema != other.thema)
			return false;
		return true;
	}

}
