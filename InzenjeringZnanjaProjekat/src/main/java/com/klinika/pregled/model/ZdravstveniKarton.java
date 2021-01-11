package com.klinika.pregled.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "karton")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ZdravstveniKarton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pacijent pacijent;
	
	@OneToMany(mappedBy = "karton", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Pregled> pregledi = new HashSet<>();
	
	@Column(name = "pol")
	private String pol;		//Format : m / f;
	
	@Column(name = "rasa")
	private String rasa; 	//Format : white / black / other;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
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
	
	
}
