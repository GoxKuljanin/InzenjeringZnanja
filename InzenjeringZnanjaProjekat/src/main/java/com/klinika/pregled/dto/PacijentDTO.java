package com.klinika.pregled.dto;

public class PacijentDTO {
	private Long id;
	private String name;
	private String lastname;
	private String pol;		//Format : m / f;
	private String rasa; 	//Format : white / black / other;
	
	public PacijentDTO() {
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	@Override
	public String toString() {
		return "PacijentDTO [name=" + name + ", lastname=" + lastname + ", pol=" + pol + ", rasa=" + rasa + "]";
	}
	
	
}
