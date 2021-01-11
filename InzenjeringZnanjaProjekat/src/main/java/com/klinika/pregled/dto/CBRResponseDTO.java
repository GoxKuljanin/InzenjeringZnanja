package com.klinika.pregled.dto;

import java.util.List;

public class CBRResponseDTO {

	private Long id;
	private List<String> simptomi;
	private String dijagnoza;
	//private String simptom;
	
	@Override
	public String toString() {
		return "CBRResponseDTO [id=" + id + ", simptomi=" + simptomi + ", dijagnoza=" + dijagnoza + "]";
	}
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
	public String getDijagnoza() {
		return dijagnoza;
	}
	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
//	public String getSimptom() {
//		return simptom;
//	}
//	public void setSimptom(String simptom) {
//		this.simptom = simptom;
//	}
}
