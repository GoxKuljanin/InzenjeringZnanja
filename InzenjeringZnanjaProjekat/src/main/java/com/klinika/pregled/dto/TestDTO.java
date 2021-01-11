package com.klinika.pregled.dto;

public class TestDTO {
	
	private Long id;
	private String name;
	
	public TestDTO() {
		// TODO Auto-generated constructor stub
	}
	public TestDTO(String name) {
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
		return "TestDTO [name=" + name + "]";
	}

	
}
