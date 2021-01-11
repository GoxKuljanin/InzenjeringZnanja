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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacijent")
public class Pacijent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToOne//(mappedBy = "pacijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "karton_id")
	private ZdravstveniKarton karton;
	
//	@OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Pregled> pregledi = new HashSet<>();
	
	public Pacijent() {
		super();
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

	public ZdravstveniKarton getKarton() {
		return karton;
	}

	public void setKarton(ZdravstveniKarton karton) {
		this.karton = karton;
	}

//	public Set<Pregled> getPregledi() {
//		return pregledi;
//	}
//
//	public void setPregledi(Set<Pregled> pregledi) {
//		this.pregledi = pregledi;
//	}
}
