package com.klinika.pregled.dto;

public class SimptomiDTO {

	private Long id;
	private String name;
	
	public SimptomiDTO() {
		// TODO Auto-generated constructor stub
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
		return "SimptomiDTO [id=" + id + ", name=" + name + "]";
	}
}
