package com.klinika.pregled.dto;

public class DijagnozaDTO {
	
	private Long id;
	private String name;
	
	
	public DijagnozaDTO() {
		super();
	}

	
	public DijagnozaDTO(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	} 

	@Override
	public String toString() {
		return "DijagnozaDTO [id=" + id + ", name=" + name + "]";

	}
	
	
}
