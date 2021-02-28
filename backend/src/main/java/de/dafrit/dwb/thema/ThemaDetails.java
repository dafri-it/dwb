package de.dafrit.dwb.thema;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ThemaDetails {

	@Column(name = "beschrausf")
	private String text;
	
	private String pdf;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
}
