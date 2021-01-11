package com.klinika.pregled.dto;

import java.util.List;

public class CBRSimptomDTO {

	private Long id;
	private List<String> simptomi;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getSimptomi() {
		return simptomi;
	}
	public void setSimptomi(List<String> simptomi) {
		this.simptomi = simptomi;
	}
}
