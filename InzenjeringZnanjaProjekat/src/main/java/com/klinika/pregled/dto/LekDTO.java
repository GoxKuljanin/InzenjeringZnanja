package com.klinika.pregled.dto;

public class LekDTO {
	
	private Long id;
	private String name;
	
	public LekDTO() {
		// TODO Auto-generated constructor stub
	}
	public LekDTO(String name) {
		// TODO Auto-generated constructor stub
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
		return "CBRLekDTO [lek=" + name + "]";
	}
}
