package de.dafrit.dwb.termin;

import java.io.Serializable;

public class ThemaTerminId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long thema;

	private Long termin;

	public ThemaTerminId(Long thema, Long termin) {
		super();
		this.thema = thema;
		this.termin = termin;
	}

	public ThemaTerminId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
		result = prime * result + ((thema == null) ? 0 : thema.hashCode());
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
		ThemaTerminId other = (ThemaTerminId) obj;
		if (termin == null) {
			if (other.termin != null)
				return false;
		} else if (!termin.equals(other.termin))
			return false;
		if (thema == null) {
			if (other.thema != null)
				return false;
		} else if (!thema.equals(other.thema))
			return false;
		return true;
	}

}
