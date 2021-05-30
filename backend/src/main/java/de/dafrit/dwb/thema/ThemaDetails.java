package de.dafrit.dwb.thema;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ThemaDetails {

	@Column(name = "beschrausf")
	private String text;
	
	private String pdf;
}
