package com.klinika.pregled.dto;

import java.util.HashSet;
import java.util.Set;

public class CBRLekDTO {
	private Set<String> lekovi = new HashSet<>();
	
	public CBRLekDTO() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Set<String> getLekovi() {
		return lekovi;
	}

	public void setLekovi(Set<String> lekovi) {
		this.lekovi = lekovi;
	}

	@Override
	public String toString() {
		return "CBRLekDTO [lekovi=" + lekovi + "]";
	}
}
