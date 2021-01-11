package com.klinika.pregled.dto;

public class NewPregledDTO {

	private Long id;
	private String godina;
	private String tezina;
	
	public NewPregledDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	@Override
	public String toString() {
		return "NewPregledDTO [godina=" + godina + ", tezina=" + tezina + "]";
	}
	
	
}
