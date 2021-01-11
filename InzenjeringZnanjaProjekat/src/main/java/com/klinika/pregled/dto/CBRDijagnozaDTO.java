package com.klinika.pregled.dto;

import java.util.Set;

public class CBRDijagnozaDTO {
	private Set<String> dijagnoze;

	
	public CBRDijagnozaDTO() {
	}
	
	public CBRDijagnozaDTO(Set<String> dijagnoze) {
		super();
		this.dijagnoze = dijagnoze;
	}

	public Set<String> getDijagnoze() {
		return dijagnoze;
	}

	public void setDijagnoze(Set<String> dijagnoze) {
		this.dijagnoze = dijagnoze;
	}


}
